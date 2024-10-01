package com.example.stopwatch.stopWatch

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.stopwatch.MainActivity
import com.example.stopwatch.stopWatch.constant.Constant.CANCEL_REQUEST_CODE
import com.example.stopwatch.stopWatch.constant.Constant.CLICK_REQUEST_CODE
import com.example.stopwatch.stopWatch.constant.Constant.RESUME_REQUEST_CODE
import com.example.stopwatch.stopWatch.constant.Constant.STOPWATCH_STATE
import com.example.stopwatch.stopWatch.constant.Constant.STOP_REQUEST_CODE
import kotlinx.coroutines.CancellationException

object ServiceHelper {

    val flag = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        PendingIntent.FLAG_MUTABLE else 0

    fun clickPendingIntent(context: Context): PendingIntent{
       val  clickIntent = Intent(context,MainActivity::class.java)
        return PendingIntent.getActivity(context, CLICK_REQUEST_CODE,clickIntent, flag)
    }



    fun stopPendingIntent(context: Context): PendingIntent{
        val stopIntent = Intent(context,StopWatchService::class.java).apply {
            putExtra(STOPWATCH_STATE,StopWatchState.Stopped.name)
        }
        return PendingIntent.getService(context, STOP_REQUEST_CODE,stopIntent, flag)
    }

    fun resumePendingIntent(context: Context): PendingIntent{
        val resumeIntent = Intent(context,StopWatchService::class.java).apply {
            putExtra(STOPWATCH_STATE,StopWatchState.Started.name)
        }
        return PendingIntent.getService(context, RESUME_REQUEST_CODE,resumeIntent,flag)
    }


    fun cancelPendingIntent(context: Context): PendingIntent{

    val cancelIntent = Intent(context,StopWatchService::class.java).apply {
        putExtra(STOPWATCH_STATE,StopWatchState.Canceled.name)
    }
        return PendingIntent.getService(context, CANCEL_REQUEST_CODE,cancelIntent, flag)
    }



    fun triggerForegroundService(context: Context,action: String){
        Intent(context,StopWatchService::class.java).apply {
            this.action =action
            context.startService(this)
        }
    }
}