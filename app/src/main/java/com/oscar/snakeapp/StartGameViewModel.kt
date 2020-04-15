package com.oscar.snakeapp

import android.os.Bundle
import androidx.lifecycle.ViewModel

class StartGameViewModel : ViewModel() {

    val navEvent = NavLiveEvent()

    override fun onCleared() {
        super.onCleared()
    }

    fun startGamePressed() {
        launchGameBoardFragment()
    }

    fun launchGameBoardFragment() {
        val bundle = Bundle()
        navEvent.value = FragmentEvent(R.id.gameBoardFragment, bundle)
    }

}