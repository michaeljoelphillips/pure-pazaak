package com.gamebros.purepazaak.view;

import java.util.ArrayList;
import java.util.Optional;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.gamebros.purepazaak.Board;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.event.CardClickedEvent;
import com.gamebros.purepazaak.ui.CardGrid;
import com.gamebros.purepazaak.view.AbstractView;

public class DeckView extends AbstractView {
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
    this.acceptsInput = true;

    this.grid = new CardGrid(x, y, width, height);
  }

  public void render(Graphics graphics) {
    try {
      this.grid.setCards(this.deck);
      this.grid.render(graphics);
    } catch (Exception e) {
      return;
    }
  }

  protected Optional<Card> getClickedCard(int x, int y) {
    return this.grid.getClickedCard(x, y);
  }

  public void mouseReleased(int button, int x, int y) {
    Optional<Card> clickedCard = this.getClickedCard(x, y);

    if (clickedCard.isPresent()) {
      this.notifyListeners(new CardClickedEvent(clickedCard.get()));
    }
  }
}
