package com.github.nomad145.purepazaak.entity;

import com.github.nomad145.purepazaak.entity.Inventory;
import com.github.nomad145.purepazaak.entity.SideDeck;

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
