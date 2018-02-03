package com.gamebros.purepazaak.view;

import java.util.ArrayList;

import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.ui.CardGrid;
import com.gamebros.purepazaak.valueobject.Area;

public class PlayerTwoDeckView extends DeckView {
  private final Area area = new Area(400, 480, 380, 100);

  public PlayerTwoDeckView(ArrayList<Card> deck) {
    super(deck);

    this.grid = new CardGrid(this.area);
  }
}

