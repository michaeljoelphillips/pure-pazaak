package com.gamebros.purepazaak.entity;

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


