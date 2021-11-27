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

    override fun onMessageReceived(remoteMessage: RemoteMessage)
    {
        val msg_data : String? = remoteMessage.data["body"]
        val body = remoteMessage.data["body"]
        val title = remoteMessage.data["title"]

//        if(remoteMessage.data.isNotEmpty()){
//            Log.d(TAG, "From: ${remoteMessage.from}")
//            if (body != null ) {
//                    sendNotification(title,body)
//
//            }
//        }

        val intent = Intent(applicationContext,ChatActivity::class.java)
        intent.putExtra("msg_data", msg_data)

        val pendingIntent = PendingIntent.getActivity(
            applicationContext,
            UUID.randomUUID().hashCode(),
            intent,
            PendingIntent.FLAG_ONE_SHOT
        )

        if (body != null) {
            Log.d(TAG,"sendNoti")
            sendNotification(title,body,pendingIntent)
        }
    }



    override fun onNewToken(token: String)
    {
        Log.d(TAG, "Refreshed token : $token")
        super.onNewToken(token)
    }

    // 받은 알림을 기기에 표시하는 메서드
    private fun sendNotification(title: String?, body: String, pendingIntent : PendingIntent)
    {
        val uniId: Int = (System.currentTimeMillis() / 7).toInt()
//        val intent = Intent(this, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//            PendingIntent.FLAG_ONE_SHOT)

        val channelId = "my_channel"
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ic_email)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // 오레오 버전 예외처리
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(uniId /* ID of notification */, notificationBuilder.build())

    }
}