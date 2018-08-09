package com.github.nomad145.purepazaak.core.card

import org.junit.Assert.*
import org.junit.Test

class MinusCardTest {
    @Test
    fun testValueGetter(){
        val test = MinusCard(2)

        assertEquals(2, test.value)
        assertEquals("cards/minus.png", test.getImagePath())
    }
}
