package com.github.nomad145.purepazaak.core.entity;

import com.github.nomad145.purepazaak.core.entity.Inventory;
import com.github.nomad145.purepazaak.core.entity.SideDeck;

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
