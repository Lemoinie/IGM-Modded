package it.paranoidsquirrels.idleguildmaster.storage

import android.content.Context
import it.paranoidsquirrels.idleguildmaster.MainActivity
import java.util.Timer
import java.util.TimerTask

class SaveManager private constructor() {
    private var timer: Timer? = null
    private var timerTask: TimerTask? = null

    companion object {
        private var SAVE_TIMER: SaveManager? = null
        @JvmField
        var inhibitSave: Boolean = false

        @JvmStatic
        fun getInstance(): SaveManager {
            if (SAVE_TIMER == null) {
                SAVE_TIMER = SaveManager()
            }
            return SAVE_TIMER!!
        }
    }

    fun startTimer(context: Context) {
        stopTimerTask()
        val t = Timer()
        this.timer = t
        initializeTimerTask(context)
        t.schedule(this.timerTask, 8000L, 3000L)
    }

    fun stopTimerTask() {
        timer?.cancel()
        timer = null
    }

    fun initializeTimerTask(context: Context) {
        this.timerTask = object : TimerTask() {
            override fun run() {
                saveToFile(context)
            }
        }
    }

    private fun saveToFile(context: Context) {
        if (!MainActivity.IDLE_THREAD_FINISHED.value || inhibitSave) {
            return
        }
        FileManager.save(context)
    }

    fun save(context: Context) {
        Thread {
            saveToFile(context)
        }.start()
    }
}
