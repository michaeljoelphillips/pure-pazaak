package com.gamebros.purepazaak.view;

import java.util.ArrayList;
import java.util.Optional;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.gamebros.purepazaak.Board;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.ui.CardGrid;

public class DeckView {
  protected ArrayList<Card> deck;

  protected CardGrid grid;

  public DeckView(
      ArrayList<Card> deck,
      int x,
      int y,
      int width,
      int height
  ) {
    this.deck = deck;

    this.grid = new CardGrid(x, y, width, height);
  }

  public void render(Graphics graphics) throws SlickException {
    this.grid.setCards(this.deck);
    this.grid.render(graphics);
  }

  public Optional<Card> getClickedCard(int x, int y) {
    return this.grid.getClickedCard(x, y);
  }
}
