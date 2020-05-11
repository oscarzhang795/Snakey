package com.oscar.snakeapp.view

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oscar.snakeapp.Card
import com.oscar.snakeapp.CardGenerator
import com.oscar.snakeapp.R
import com.oscar.snakeapp.events.FragmentEvent
import com.oscar.snakeapp.events.NavLiveEvent

class GameBoardViewModel : ViewModel() {

    val navEvent = NavLiveEvent()

    private var cardList: LiveData<List<Card>> = MutableLiveData()

    private val cardGenerator = CardGenerator()

    private var matchCount = 0

    fun initCardData(): LiveData<List<Card>> {
        cardList = MutableLiveData(cardGenerator.generateMatchingCards(16))
        return cardList
    }

    fun incrementMatch() {
        matchCount ++
    }

    fun checkIfWin() {
        if (matchCount == 8) {
            launchScoreFragment()
        }
    }

    private fun launchScoreFragment() {
        val bundle = Bundle()
        navEvent.value = FragmentEvent(
            R.id.gameBoardFragment,
            bundle
        )
    }
}