package com.gamebros.purepazaak.entity;

import com.gamebros.purepazaak.entity.Inventory;
import com.gamebros.purepazaak.entity.SideDeck;

public class Player {
  protected Inventory inventory;

  protected SideDeck sideDeck;

  public Player(SideDeck sideDeck) {
    this.sideDeck = sideDeck;
  }

  public SideDeck getSideDeck() {
    return this.sideDeck;
  }
}
