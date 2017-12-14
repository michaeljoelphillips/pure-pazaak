package com.gamebros.purepazaak.entity;

public class Card implements CardInterface {
  public int x = 0;

  public int y = 0;

  protected int value;

  public Card(int value, int x, int y) {
    this.value = value;
    this.x = x;
    this.y = y;
  }

  public Card(int value){
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}
