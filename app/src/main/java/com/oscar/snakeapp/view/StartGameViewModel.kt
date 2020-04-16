package com.oscar.snakeapp.view

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.oscar.snakeapp.Events.FragmentEvent
import com.oscar.snakeapp.Events.NavLiveEvent
import com.oscar.snakeapp.R

class StartGameViewModel : ViewModel() {

    val navEvent = NavLiveEvent()

    override fun onCleared() {
        super.onCleared()
    }

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