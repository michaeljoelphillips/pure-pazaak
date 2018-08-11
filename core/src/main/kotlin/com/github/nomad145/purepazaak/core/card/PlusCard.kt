package com.github.nomad145.purepazaak.core.card;

import java.lang.IllegalArgumentException;

open class PlusCard(override val value: Int) : CardInterface {
  init {
    if (value < 0) {
      throw IllegalArgumentException("The card value must be positive");
    }
  }
}

