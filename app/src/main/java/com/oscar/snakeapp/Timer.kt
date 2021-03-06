package com.oscar.snakeapp

import kotlinx.coroutines.*

class Timer {
    var minutes = 0
    var seconds = 0

    var listener: OnTickListener? = null
    var job: Job? = null

    fun setOnTickListener(listener: OnTickListener) {
        this.listener = listener
    }

    fun startTimer() {
        job = GlobalScope.launch {
            for (i in 0 until Integer.MAX_VALUE) {
                delay(1000)
                seconds++
                if (seconds % 60 == 0) {
                    seconds = 0
                    minutes++
                }
                listener?.onTick()
            }
        }
    }

    fun getTime(): String {
        var timeString = minutes.toString()
            .plus(":")
        if (seconds < 10)
            timeString = timeString.plus("0")

        timeString = timeString.plus(seconds.toString())
        return timeString
    }

    fun reset() {
        minutes = 0
        seconds = 0
        job?.cancel()
    }

    interface OnTickListener {
        fun onTick()
    }
}