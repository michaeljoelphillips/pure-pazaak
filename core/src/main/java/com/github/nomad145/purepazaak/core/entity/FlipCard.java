package com.github.nomad145.purepazaak.core.entity;

public class FlipCard implements CardInterface {
  protected int value;

  public FlipCard(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public String getImagePath() {
    return "cards/flip.png";
  }
}


