package com.gamebros.purepazaak.view;

import java.util.ArrayList;

import com.gamebros.purepazaak.entity.CardInterface;
import com.gamebros.purepazaak.ui.CardGrid;

public class PlayerOneDeckView extends DeckView {
  private final int x = 190;

  private final int y = 870;

  private final int width = 580;

  private final int height = 190;

  public PlayerOneDeckView(ArrayList<CardInterface> deck) {
    super(deck);

    this.grid = new CardGrid(this.x, this.y, this.width, this.height);
  }
}
