package com.oscar.snakeapp.view

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.oscar.snakeapp.events.FragmentEvent
import com.oscar.snakeapp.events.NavLiveEvent
import com.oscar.snakeapp.R

class StartGameViewModel : ViewModel() {

    val navEvent = NavLiveEvent()

    fun startGamePressed() {
        launchGameBoardFragment()
    }

    private fun launchGameBoardFragment() {
        val bundle = Bundle()
        navEvent.value = FragmentEvent(
            R.id.gameBoardFragment,
            bundle
        )
    }
}