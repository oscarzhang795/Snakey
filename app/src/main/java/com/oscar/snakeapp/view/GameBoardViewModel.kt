package com.oscar.snakeapp.view

import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oscar.snakeapp.Card
import com.oscar.snakeapp.CardGenerator
import com.oscar.snakeapp.R
import com.oscar.snakeapp.Timer
import com.oscar.snakeapp.events.FragmentEvent
import com.oscar.snakeapp.events.NavLiveEvent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class GameBoardViewModel : ViewModel() {

    val navEvent = NavLiveEvent()
    var timerData: MutableLiveData<String> = MutableLiveData()
    private var cardList: LiveData<List<Card>> = MutableLiveData()

    private val cardGenerator = CardGenerator()
    private val timer = Timer()

    private var matchCount = 0

    private val onTickListener = object : Timer.OnTickListener {
        override fun onTick() {
            timerData.postValue(timer.getTime())
        }
    }

    fun initTimer() {
        timer.setOnTickListener(onTickListener)
        timer.startTimer()
    }

    fun initCardData(): LiveData<List<Card>> {
        val cards = cardGenerator.generateMatchingCards(16)
        cards.shuffle()
        cardList = MutableLiveData(cards)
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
        bundle.putString("time", timerData.value)
        navEvent.value = FragmentEvent(
            R.id.scoreScreenFragment,
            bundle
        )
    }
}