package com.udacity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService

/**
 * Created by heinhtet deevvdd@gmail.com on 13,July,2021
 */
private const val REQUEST_CODE = 101
private const val NOTIFICATION_ID = 1

fun NotificationManager.sendCompleteDownloadFile(
    fileName: String,
    status: String,
    context: Context
) {
    createNotificationChannel(context)
    val intent = Intent(context, DetailActivity::class.java).apply {
        putExtra(DetailActivity.FILE_NAME, fileName)
        putExtra(DetailActivity.STATUS, status)
    }
    val pendingIntent = PendingIntent.getActivity(
        context,
        REQUEST_CODE,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )
    val checkStatusAction = NotificationCompat.Action.Builder(
        null,
        context.getString(R.string.check_status),
        pendingIntent
    ).build()

    val builder = NotificationCompat.Builder(
        context,
        context.getString(R.string.channel_loading_app)
    )
        .setSmallIcon(R.drawable.ic_assistant_black_24dp)
        .setContentTitle(
            context
                .getString(R.string.notification_title)
        )
        .setContentText("Download file -> $status")
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .addAction(checkStatusAction)
    notify(NOTIFICATION_ID, builder.build())
}

fun NotificationManager.createNotificationChannel(context: Context) {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = context.getString(R.string.channel_loading_app)
        val descriptionText = context.getString(R.string.channel_description)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(
            context.getString(R.string.channel_loading_app),
            name,
            importance
        ).apply {
            description = descriptionText
        }
        createNotificationChannel(channel)
    }
}

