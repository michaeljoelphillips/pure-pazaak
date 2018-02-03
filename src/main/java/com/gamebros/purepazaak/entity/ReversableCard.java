package com.gamebros.purepazaak.entity;

import com.gamebros.purepazaak.entity.Card;

public class ReversableCard extends Card {
  public ReversableCard(int value) {
    super(value);
  }

  public void reverseValue() {
    this.value *= -1;
  }
}
