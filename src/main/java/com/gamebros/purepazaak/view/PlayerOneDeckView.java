package com.gamebros.purepazaak.view;

import java.util.ArrayList;

import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.ui.CardGrid;
import com.gamebros.purepazaak.valueobject.Area;

public class PlayerOneDeckView extends DeckView {
  private final Area area = new Area(20, 480, 380, 100);

  public PlayerOneDeckView(ArrayList<Card> deck) {
    super(deck);

    this.grid = new CardGrid(this.area);
  }
}
