package com.github.nomad145.purepazaak.core.card;

import org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import java.lang.IllegalArgumentException;

class PlusCardTest {
  @get:Rule
  public var exception = ExpectedException.none()

  @Test
  fun testValueGetter() {
    val subject = PlusCard(2)

    assertEquals(2, subject.value)
  }

  fun testConstructorThrowsExceptionWhenGivenNegativeValue() {
    exception.expect(IllegalArgumentException::class.java)

    PlusCard(-2)
  }
}

