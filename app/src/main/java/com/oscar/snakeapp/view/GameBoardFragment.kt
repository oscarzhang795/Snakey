package com.oscar.snakeapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.oscar.snakeapp.Card
import com.oscar.snakeapp.R
import kotlinx.android.synthetic.main.fragment_game_board.*

class GameBoardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_game_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeGrid()
    }

    private fun initializeGrid() {
        val cardList = arrayListOf(Card("test"), Card("test 2"), Card("test 3"), Card("test 4"),
            Card("test5"), Card("test 6"), Card("test 7"), Card("test 8"))
        rv_game_board.adapter = GameBoardAdapter(cardList)
        rv_game_board.layoutManager = GridLayoutManager(activity, 4)
    }
}