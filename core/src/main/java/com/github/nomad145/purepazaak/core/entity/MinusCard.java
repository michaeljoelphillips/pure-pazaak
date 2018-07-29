package com.github.nomad145.purepazaak.core.entity;

import com.github.nomad145.purepazaak.core.card.CardInterface;

public class MinusCard implements CardInterface {
  protected int value;

  public MinusCard(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public String getImagePath() {
    return "cards/minus.png";
  }
}


