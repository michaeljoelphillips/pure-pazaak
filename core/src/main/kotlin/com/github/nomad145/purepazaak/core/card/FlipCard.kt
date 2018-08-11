package com.github.nomad145.purepazaak.core.card

class FlipCard(override val value: Int):CardInterface{
    fun getImagePath():String{
        return "cards/flip.png"
    }
}
