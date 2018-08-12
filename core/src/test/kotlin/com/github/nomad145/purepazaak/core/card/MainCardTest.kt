package com.github.nomad145.purepazaak.core.card;

import org.junit.Assert.*;
import org.junit.Test;

class MainCardTest {
  @Test
  fun testValueGetter() {
    val subject = MainCard(2)

    assertEquals(2, subject.value)
  }
}
