package com.github.nomad145.purepazaak.core.card

import org.junit.Assert.*
import org.junit.Test

class FlipCardTest{
    @Test
    fun testValueGetter(){
        val test = FlipCard(2)

        assertEquals(2,test.value)
        assertEquals("cards/flip.png", test.getImagePath())
    }
}

