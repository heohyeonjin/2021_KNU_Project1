package com.example.chattingapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.chattingapp.data.model.EnterDTO
import com.example.chattingapp.ui.ChatActivity
import com.example.chattingapp.ui.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.ktx.remoteMessage
import java.net.URLDecoder
import java.util.*
import kotlin.math.log

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG: String = this.javaClass.simpleName
    lateinit var enterDTO : EnterDTO

    override fun onMessageReceived(remoteMessage: RemoteMessage)
    {

        Log.d(TAG,"asdf")
        val roomNo = remoteMessage.data["roomId"]?.toLong()
//        val Title = remoteMessage.notification!!.title
        Log.d(TAG,"roomNo : $roomNo")
//        Log.d(TAG,"Title : $Title")

        val body = remoteMessage.data["body"]
        val title = remoteMessage.data["title"]
        enterDTO = EnterDTO(roomNo!!, title!!, 0)
//        if(remoteMessage.data.isNotEmpty()){
//            Log.d(TAG, "From: ${remoteMessage.from}")
//            if (body != null ) {
//                    sendNotification(title,body)
//1
//            }
//        }

        val intent = Intent(applicationContext,ChatActivity::class.java)
        intent.putExtra("EnterDTO", enterDTO)

        val pendingIntent = PendingIntent.getActivity(
            applicationContext,
            1,
            intent,
            PendingIntent.FLAG_ONE_SHOT
        )

        if (body != null) {
            Log.d(TAG, "sendNoti ${enterDTO.roomNo}")
            sendNotification(title,body,pendingIntent,roomNo!!.toInt())
        }
    }



    override fun onNewToken(token: String)
    {
        Log.d(TAG, "Refreshed token : $token")
        super.onNewToken(token)
    }



    // 받은 알림을 기기에 표시하는 메서드
    private fun sendNotification(title: String?, body: String, pendingIntent : PendingIntent, id: Int)
    {
        val uniId: Int = (System.currentTimeMillis() / 7).toInt()
//        val intent = Intent(this, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//            PendingIntent.FLAG_ONE_SHOT)

        val channelId = "my_channel"
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, title!!)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ic_email)
            .setGroup(title)

        val summarynotificationBuilder = NotificationCompat.Builder(this, title)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.ic_email)
            .setGroup(title)
            .setGroupSummary(true)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setOnlyAlertOnce(true)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // 오레오 버전 예외처리
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                title,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(uniId /* ID of notification */, notificationBuilder.build())
        notificationManager.notify(id, summarynotificationBuilder.build())

    }
}