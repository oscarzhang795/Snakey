package com.oscar.snakeapp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.oscar.snakeapp.Card
import com.oscar.snakeapp.R
import kotlinx.android.synthetic.main.item_button.view.*

class GameBoardAdapter(private val cardList: List<Card>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val buttonView = LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false)
        return ViewHolder(buttonView)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder.itemView.test_button as Button).text = cardList[position].cardText
        holder.itemView.test_button.setOnClickListener {
            cardList[position].isFlipped = !cardList[position].isFlipped
            Log.d("isFlipped", "Flipped to ${cardList[position].isFlipped}")
        }
    }

    class ViewHolder(private var button: View) : RecyclerView.ViewHolder(button)
}
