package com.example.stopwatch.stopWatch

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.stopwatch.R
import com.example.stopwatch.stopWatch.constant.Constant.NOTIFICATION_CHANNEL
import com.example.stopwatch.stopWatch.constant.Constant.NOTIFICATION_CHANNEL_ID
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped


@Module
@InstallIn(ServiceComponent::class)
object StopWatchModule {

    @Provides
    @ServiceScoped
    fun provideNotificationBuilder(@ApplicationContext context: Context): NotificationCompat.Builder{


        return NotificationCompat.Builder(
            context,
            NOTIFICATION_CHANNEL_ID,
        ).setContentTitle("StopWatch")
            .setContentText("")
            .setOngoing(true)
            .setSmallIcon(R.drawable.stopwatch)
            .addAction(0,"Stop",ServiceHelper.stopPendingIntent(context))
            .addAction(0,"Cancel",ServiceHelper.cancelPendingIntent(context))
            .setContentIntent(ServiceHelper.clickPendingIntent(context))

    }


    @Provides
    @ServiceScoped
    fun provideNotificationManger(@ApplicationContext context: Context): NotificationManager{

        return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

}