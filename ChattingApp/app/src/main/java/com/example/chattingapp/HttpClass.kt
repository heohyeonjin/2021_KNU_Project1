package com.donga.st.app02.common

import android.os.Handler
import android.os.Message
import android.util.Log
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


/**
 * Type : post
URL : http://lucky.0za3979.com/index.php/Aiak/searchBarcode
파라미터 : id_num

등록번호 검색
Type : post
URL : http://lucky.0za3979.com/index.php/Aiak/search
파라미터 : reg_id
 * */

class HttpClass:Thread{
    val TAG:String = "HttpClass"



    companion object {
        var HTTP_ACTION01:Int = 1001
        var HTTP_ACTION02:Int = 1002
        var HTTP_ACTION03:Int = 1003
        var HTTP_ACTION04:Int = 1004
        var HTTP_ACTION05:Int = 1005
        var HTTP_ACTION06:Int = 1006
        var HTTP_ACTION07:Int = 1007
        var HTTP_ACTION08:Int = 1008
        var HTTP_ACTION09:Int = 1009

        var HTTP_ACTION10:Int = 1010
        var HTTP_ACTION11:Int = 1011
        var HTTP_ACTION12:Int = 1012
        var HTTP_ACTION13:Int = 1013
        var HTTP_ACTION14:Int = 1014
        var HTTP_ACTION15:Int = 1015
        var HTTP_ACTION16:Int = 1016

        var HTTP_ACTION21:Int = 1021
        var HTTP_ACTION22:Int = 1022
        var HTTP_ACTION23:Int = 1023

        /** 개체식별번호 검색*/
        val HTTP_OUTTER_ACTION01:Int = 2000

        /** 등록번호 검색*/
        val HTTP_OUTTER_ACTION02:Int = 2001

        val HTTP_KAKAO_ALIM_TALK01:Int = 301
        val HTTP_KAKAO_ALIM_TALK02:Int = 302
        val HTTP_KAKAO_ALIM_TALK03:Int = 303
        val HTTP_KAKAO_ALIM_TALK04:Int = 304
        val HTTP_KAKAO_ALIM_TALK05:Int = 305

        val HTTP_SALE_ONLY_UPLOAD_01:Int = 401
        val HTTP_SALE_ONLY_UPLOAD_02:Int = 402
        val HTTP_SALE_ONLY_UPLOAD_03:Int = 403

    }


    val mRootURL:String = "http://schemi.0za.kr/app/"
    var mSubURL:String = ""

    var mHandler: Handler?=null

    var mOrder:Int=0

    var mParams_Map:HashMap<String, String> = HashMap()
    var mFileList:ArrayList<String> = ArrayList()


    constructor(_order:Int, _handler:android.os.Handler, _params:HashMap<String, String>){
        mOrder = _order
        mHandler = _handler
        mParams_Map = _params
    }

    constructor(_order:Int, _handler:android.os.Handler, _params:HashMap<String, String>, _fileList:ArrayList<String>){
        mOrder = _order
        mHandler = _handler
        mParams_Map = _params
        mFileList = _fileList
    }

    override fun run() {
        when(mOrder) {
            HTTP_ACTION01,
            HTTP_ACTION02,
            HTTP_ACTION03,
            HTTP_ACTION04,
            HTTP_ACTION05,
            HTTP_ACTION06,
            HTTP_ACTION07,
            HTTP_ACTION08,
            HTTP_ACTION09,
            HTTP_ACTION10,
            HTTP_ACTION11,
            HTTP_ACTION12,
            HTTP_ACTION13,
            HTTP_ACTION14,
            HTTP_ACTION15,
            HTTP_ACTION16,
            HTTP_ACTION21,
            HTTP_ACTION22,
            HTTP_ACTION23-> {
                mSubURL = mRootURL + mParams_Map.remove("url")
                httpMyInfoUpload_MultiImage()
            }



            HTTP_KAKAO_ALIM_TALK01,
            HTTP_KAKAO_ALIM_TALK02,
            HTTP_KAKAO_ALIM_TALK03,
            HTTP_KAKAO_ALIM_TALK04,
            HTTP_KAKAO_ALIM_TALK05-> {
                mSubURL = mParams_Map.remove("url").toString()
                httpMyInfoUpload_MultiImage()
            }


            HTTP_SALE_ONLY_UPLOAD_01,
            HTTP_SALE_ONLY_UPLOAD_02,
            HTTP_SALE_ONLY_UPLOAD_03 ->{
                mSubURL = mRootURL + mParams_Map.remove("url").toString()
                httpMyInfoUpload_MultiImage_Only_sale()
            }


        }
    }


    /** 여러개의 이미지를 서버에 전송할때 사용함. */
    private val lineEnd:String = "\r\n"
    private val twoHyphens:String = "--"
    private val boundary:String = "*****"

    private var mFileInputStream:FileInputStream?=null

    fun httpMyInfoUpload_MultiImage(){
        try {
            Log.v(TAG, "httpMyInfoUpload_MultiImage() / mSubURL : " + mSubURL);

            var connectURL = URL(mSubURL)
            var conn = connectURL.openConnection() as HttpURLConnection


            conn.doInput = true
            conn.doOutput = true
            conn.useCaches = false
            conn.requestMethod = "POST"
            conn.setRequestProperty("Connection", "Keep-Alive")
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=$boundary")

            var pw = PrintWriter(OutputStreamWriter(conn.outputStream, "utf-8"), true)

            for((_key, _value) in mParams_Map){
                Log.v(TAG, "_key:$_key, _value:$_value")

                pw.write(twoHyphens + boundary + lineEnd)
                pw.write("Content-Disposition: form-data; name=\"$_key\"$lineEnd") //key
                pw.write(lineEnd)
                pw.write(_value) //value

                pw.write(lineEnd)
            }

            pw.flush()

            var _isImage = false

            if(mFileList.size > 0){
                _isImage = true
            }

            Log.v(TAG, "_imImage:$_isImage")


            if(_isImage){
                var dos = DataOutputStream(conn.outputStream)

                var _pos = 0

                for( _imgUrl in mFileList){
                    Log.i(TAG, "${_pos} : ${(_imgUrl)}")
                    if( _imgUrl.isEmpty() || _imgUrl.contains("/app/sale_imgs/") || _imgUrl.contains("/app/commu_imgs/") ){
                        if(_imgUrl.contains("/app/sale_imgs/") || _imgUrl.contains("/app/commu_imgs/") ){
                            _pos++
                        }
                        continue
                    }

                    dos = DataOutputStream(conn.outputStream)

                    dos.writeBytes(twoHyphens + boundary + lineEnd)

                    try {
                        dos.writeBytes(
                            "Content-Disposition: form-data; name=\"attach$_pos\";filename=\"${URLEncoder.encode(_imgUrl, "UTF-8")}\"$lineEnd"
                        )
                    }catch(e:Exception){
                        Log.e(TAG, e.message!!)
                    }
                    _pos++

                    dos.writeBytes(lineEnd)
                    Log.v(TAG, "${_pos} / _imgUrl : $_imgUrl ")

                    mFileInputStream = FileInputStream(File(_imgUrl))

                    var bytesAvailable = mFileInputStream!!.available()
                    Log.v(TAG, "1 / bytesAvailable : $bytesAvailable")
                    val maxBufferSize = 1024 * 1024 * 1
                    var bufferSize = Math.min(bytesAvailable, maxBufferSize)
                    val buffer = ByteArray(bufferSize)
                    var bytesRead = mFileInputStream!!.read(buffer, 0, bufferSize)

                    Log.v(TAG, "httpMyInfoUpload() / image byte is $bytesRead")
                    // read image

                    // read image
                    while (bytesRead > 0) {
                        dos.write(buffer, 0, bufferSize)
                        bytesAvailable = mFileInputStream!!.available()
                        Log.v(TAG, "2/ bytesAvailable : $bytesAvailable")
                        bufferSize = Math.min(bytesAvailable, maxBufferSize)
                        bytesRead = mFileInputStream!!.read(buffer, 0, bufferSize)
                    }

                    dos.writeBytes(lineEnd)
                    dos.flush() // finish upload...

                    //=====================원본파일 전송 완료========================//

                }
                /** ======  end for  ====== */
                dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd)

                Log.v(TAG, "httpMyInfoUpload() / File is written");
                if ( mFileInputStream != null) {
                    mFileInputStream?.close()
                }

                dos.close()


            }
            /** ============    send Images Finish()  =========*/

            var _ch:String? = ""
            var _is = conn.inputStream
            var _br = BufferedReader(InputStreamReader(_is, "utf-8"))
            var _sb = StringBuffer("")




            do{
                _ch = _br.readLine()
                if(_ch == null){
                    break
                }

                _sb.append(_ch)

            }while(true)


            var _str = _sb.toString()
            Log.v(TAG, "result : $_str")

            _br.close()
            _is.close()

            pw.close()
            conn.disconnect()


            if( mHandler != null){
                var _msg = Message()
                _msg.what = mOrder
                _msg.obj = _str
                mHandler!!.sendMessage(_msg)
            }

        }catch(e:Exception){
            Log.e(TAG, e.message!!)

            val _msg = "{\"res\":-1,\"msg\":\"fail to connection\"}"

            if (mHandler != null) {
                val msg = Message()
                msg.what = mOrder
                msg.obj = _msg
                mHandler!!.sendMessage(msg)
            }
        }
    }









    /** 21.03.23 - 소판매 등록에만 사용함, 이미지 등록시 위치가 고정되게 되어야 함. */
    fun httpMyInfoUpload_MultiImage_Only_sale(){
        try {
            Log.v(TAG, "httpMyInfoUpload_MultiImage_Only_sale() / mSubURL : " + mSubURL);

            var connectURL = URL(mSubURL)
            var conn = connectURL.openConnection() as HttpURLConnection


            conn.doInput = true
            conn.doOutput = true
            conn.useCaches = false
            conn.requestMethod = "POST"
            conn.setRequestProperty("Connection", "Keep-Alive")
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=$boundary")

            var pw = PrintWriter(OutputStreamWriter(conn.outputStream, "utf-8"), true)

            for((_key, _value) in mParams_Map){
                Log.v(TAG, "_key:$_key, _value:$_value")

                pw.write(twoHyphens + boundary + lineEnd)
                pw.write("Content-Disposition: form-data; name=\"$_key\"$lineEnd") //key
                pw.write(lineEnd)
                pw.write(_value) //value

                pw.write(lineEnd)
            }

            pw.flush()

            var _isImage = false

            if(mFileList.size > 0){
                _isImage = true
            }

            Log.v(TAG, "_imImage:$_isImage")


            if(_isImage){
                var dos = DataOutputStream(conn.outputStream)

                var _pos = 0

                for( _imgUrl in mFileList){
                    if( _imgUrl.isEmpty() || _imgUrl.contains("/app/sale_imgs/")){
                        //if(_imgUrl.contains("/app/sale_imgs/")){
                        _pos++
                        //}
                        continue
                    }

                    dos = DataOutputStream(conn.outputStream)

                    dos.writeBytes(twoHyphens + boundary + lineEnd)

                    try {
                        dos.writeBytes(
                            "Content-Disposition: form-data; name=\"attach$_pos\";filename=\"${URLEncoder.encode(_imgUrl, "UTF-8")}\"$lineEnd"
                        )
                    }catch(e:Exception){
                        Log.e(TAG, e.message!!)
                    }
                    _pos++

                    dos.writeBytes(lineEnd)
                    Log.v(TAG, "${_pos} / _imgUrl : $_imgUrl ")

                    mFileInputStream = FileInputStream(File(_imgUrl))

                    var bytesAvailable = mFileInputStream!!.available()
                    Log.v(TAG, "1 / bytesAvailable : $bytesAvailable")
                    val maxBufferSize = 1024 * 1024 * 1
                    var bufferSize = Math.min(bytesAvailable, maxBufferSize)
                    val buffer = ByteArray(bufferSize)
                    var bytesRead = mFileInputStream!!.read(buffer, 0, bufferSize)

                    Log.v(TAG, "httpMyInfoUpload() / image byte is $bytesRead")
                    // read image

                    // read image
                    while (bytesRead > 0) {
                        dos.write(buffer, 0, bufferSize)
                        bytesAvailable = mFileInputStream!!.available()
                        Log.v(TAG, "2/ bytesAvailable : $bytesAvailable")
                        bufferSize = Math.min(bytesAvailable, maxBufferSize)
                        bytesRead = mFileInputStream!!.read(buffer, 0, bufferSize)
                    }

                    dos.writeBytes(lineEnd)
                    dos.flush() // finish upload...

                    //=====================원본파일 전송 완료========================//

                }
                /** ======  end for  ====== */
                dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd)

                Log.v(TAG, "httpMyInfoUpload() / File is written");
                if ( mFileInputStream != null) {
                    mFileInputStream?.close()
                }

                dos.close()


            }
            /** ============    send Images Finish()  =========*/

            var _ch:String? = ""
            var _is = conn.inputStream
            var _br = BufferedReader(InputStreamReader(_is, "utf-8"))
            var _sb = StringBuffer("")




            do{
                _ch = _br.readLine()
                if(_ch == null){
                    break
                }

                _sb.append(_ch)

            }while(true)


            var _str = _sb.toString()
            Log.v(TAG, "result : $_str")

            _br.close()
            _is.close()

            pw.close()
            conn.disconnect()


            if( mHandler != null){
                var _msg = Message()
                _msg.what = mOrder
                _msg.obj = _str
                mHandler!!.sendMessage(_msg)
            }

        }catch(e:Exception){
            Log.e(TAG, e.message!!)

            val _msg = "{\"res\":-1,\"msg\":\"fail to connection\"}"

            if (mHandler != null) {
                val msg = Message()
                msg.what = mOrder
                msg.obj = _msg
                mHandler!!.sendMessage(msg)
            }
        }
    }
}