package com.oscar.snakeapp

class CardGenerator {

    fun generateMatchingCards(numberOfCards: Int): List<Card> {
        val cardList = mutableListOf<Card>()
        while (cardList.size < numberOfCards) {
            val randomPair = generateRandomPair()

            if (isUniquePair(randomPair, cardList)) {
                cardList.addAll(randomPair)
            }
        }
        return cardList
    }

    private fun isUniquePair(pair: List<Card>, cardList: List<Card>): Boolean {
        val newCard = pair[0]
        cardList.forEach {
            if (it.characterType == newCard.characterType)
                return false
        }
        return true
    }

    private fun generateRandomPair(): List<Card> {
        val asset = when ((0..7).random()) {
            0 -> Pair(ASSET_ONE, Card.CharacterType.HEDGEHOG)
            1 -> Pair(ASSET_TWO, Card.CharacterType.CHICK)
            2 -> Pair(ASSET_THREE, Card.CharacterType.CAT)
            3 -> Pair(ASSET_FOUR, Card.CharacterType.BUNNY)
            4 -> Pair(ASSET_FIVE, Card.CharacterType.DOG)
            5 -> Pair(ASSET_SIX, Card.CharacterType.PENGUIN)
            6 -> Pair(ASSET_SEVEN, Card.CharacterType.OWL)
            else -> Pair(ASSET_EIGHT, Card.CharacterType.HAMSTER)
        }
        return mutableListOf(Card(asset.first, asset.second), Card(asset.first, asset.second))
    }

    companion object {
        const val ASSET_ONE = R.drawable.ic_asset_1
        const val ASSET_TWO = R.drawable.ic_asset_2
        const val ASSET_THREE = R.drawable.ic_asset_3
        const val ASSET_FOUR = R.drawable.ic_asset_4
        const val ASSET_FIVE = R.drawable.ic_asset_5
        const val ASSET_SIX = R.drawable.ic_asset_6
        const val ASSET_SEVEN = R.drawable.ic_asset_7
        const val ASSET_EIGHT = R.drawable.ic_asset_8
    }

}