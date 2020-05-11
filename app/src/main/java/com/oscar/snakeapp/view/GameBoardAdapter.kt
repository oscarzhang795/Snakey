package com.oscar.snakeapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.oscar.snakeapp.Card
import com.oscar.snakeapp.R
import kotlinx.android.synthetic.main.item_button.view.*

class GameBoardAdapter(
    private var cardList: List<Card>,
    private var winConditionCallback: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var selectedPair = mutableListOf<Card>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val buttonView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false)
        return ViewHolder(buttonView)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder.itemView.card_button as Button).apply {
            this.setBackgroundResource(R.drawable.ic_asset_9)
            this.setOnClickListener {
                val selectedCard = cardList[position]
                if (!selectedCard.isMatched)
                    flipCard(selectedCard, it)
                if (checkIfMatch(selectedPair))
                    winConditionCallback.invoke()
            }
        }
    }

    private fun flipCard(selectedCard: Card, view: View) {
        selectedCard.isFlipped = !selectedCard.isFlipped
        if (selectedCard.isFlipped && selectedPair.size < 2) {
            view.setBackgroundResource(selectedCard.imageRef)
            selectedPair.add(selectedCard)
        } else {
            view.setBackgroundResource(R.drawable.ic_asset_9)
            selectedPair.remove(selectedCard)
        }
    }

    private fun checkIfMatch(selectedPair: List<Card>): Boolean {
        var isMatch = false
        if (selectedPair.size == 2 && selectedPair[0].characterType == selectedPair[1].characterType) {
            selectedPair[0].isMatched = true
            selectedPair[1].isMatched = true
            (selectedPair as ArrayList).clear()
            isMatch = true
        }
        return isMatch
    }

    fun setData(newCardList: List<Card>) {
        cardList = newCardList
        notifyDataSetChanged()
    }

    class ViewHolder(button: View) : RecyclerView.ViewHolder(button)
}
