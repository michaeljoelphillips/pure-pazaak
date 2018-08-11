<<<<<<< HEAD
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
=======
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
>>>>>>> 83facc4fec2ed2c10b8d956333ed324576f7b753
