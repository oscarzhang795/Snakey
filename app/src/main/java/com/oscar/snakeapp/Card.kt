package com.oscar.snakeapp

class Card (val imageRef: Int, val characterType: CharacterType, var isFlipped: Boolean = false) {

    var isMatched = false

    enum class CharacterType {
        HEDGEHOG,
        CHICK,
        CAT,
        BUNNY,
        DOG,
        PENGUIN,
        OWL,
        HAMSTER
    }
}