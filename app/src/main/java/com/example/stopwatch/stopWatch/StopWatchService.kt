package com.example.stopwatch.stopWatch

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.NotificationCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StopWatchService: Service() {

    @Inject
    lateinit var notificationManager: NotificationManager
    @Inject
    lateinit var notificationBuilder: NotificationCompat.Builder



    var hour = mutableStateOf("00")
        private set
    var minute = mutableStateOf("00")
        private set
    var second = mutableStateOf("00")
        private set
    var  currentState = mutableStateOf(StopWatchState.Idle)
        private set

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}