package com.github.nomad145.purepazaak.core.entity;

public class MainCard implements CardInterface {
  protected int value;

  public MainCard(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public String getImagePath() {
    return "cards/main.png";
  }
}
