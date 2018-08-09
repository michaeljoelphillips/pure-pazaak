package com.github.nomad145.purepazaak.core.card

class MinusCard(override val value:Int):CardInterface{
    fun getImagePath():String{
        return "cards/minus.png"
    }
}