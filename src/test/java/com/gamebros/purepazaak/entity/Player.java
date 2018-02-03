package com.gamebros.purepazaak.entity;

public class Player {
  protected String name;

  protected SideDeck sideDeck;

  public Player(String name, SideDeck sideDeck) {
    this.name = name;
    this.sideDeck = sideDeck;
  }

  public SideDeck getSideDeck() {
    return this.sideDeck;
  }
}
