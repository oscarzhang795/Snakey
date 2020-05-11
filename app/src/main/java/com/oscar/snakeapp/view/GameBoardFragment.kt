package com.oscar.snakeapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.oscar.snakeapp.Card
import com.oscar.snakeapp.R
import com.oscar.snakeapp.events.FragmentEvent
import kotlinx.android.synthetic.main.fragment_game_board.*

class GameBoardFragment : Fragment() {

    private val viewModel: GameBoardViewModel by activityViewModels()

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
        viewModel.initTimer()

        viewModel.initCardData().observe(
            viewLifecycleOwner,
            Observer { onChangeAdapterData(it) }
        )

        viewModel.navEvent.observe(viewLifecycleOwner, Observer {
            if (it is FragmentEvent) {
                findNavController().navigate(it.resourceId, it.bundle)
            }
        })

        viewModel.timerData.observe(viewLifecycleOwner, Observer {
            tv_timer.text = it
        })
    }

    private fun initializeGrid() {
        val winConditionCallback = {
            viewModel.incrementMatch()
            viewModel.checkIfWin()
        }

        rv_game_board.adapter = GameBoardAdapter(mutableListOf(), winConditionCallback)
        rv_game_board.layoutManager = GridLayoutManager(activity, 4)
    }

    private fun onChangeAdapterData(cardList: List<Card>) {
        (rv_game_board.adapter as GameBoardAdapter).setData(cardList)
    }


}