package com.oscar.snakeapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.oscar.snakeapp.Events.FragmentEvent
import com.oscar.snakeapp.R
import kotlinx.android.synthetic.main.fragment_start_game.*

class StartGameFragment : Fragment() {

    private val viewModel: StartGameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_start_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.navEvent.observe(viewLifecycleOwner, Observer {
            if (it is FragmentEvent) {
                findNavController().navigate(it.resourceId, it.bundle)
            }
        })

        btn_start_game.setOnClickListener {
            viewModel.startGamePressed()
        }
    }
}