package com.gamebros.purepazaak.entity;

public class Card implements CardInterface {
  protected int value;

  public Card(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
