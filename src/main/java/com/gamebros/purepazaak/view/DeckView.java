package com.github.nomad145.purepazaak.view;

import java.util.ArrayList;
import java.util.Optional;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.github.nomad145.purepazaak.Board;
import com.github.nomad145.purepazaak.entity.CardInterface;
import com.github.nomad145.purepazaak.event.CardClickedEvent;
import com.github.nomad145.purepazaak.ui.CardGrid;
import com.github.nomad145.purepazaak.view.AbstractView;

abstract public class DeckView extends AbstractView {
  protected ArrayList<CardInterface> deck;

  protected CardGrid grid;

  public DeckView(ArrayList<CardInterface> deck) {
    this.deck = deck;
    this.acceptsInput = true;
  }

  public void render(Graphics graphics) {
    try {
      this.grid.setCards(this.deck);
      this.grid.render(graphics);
    } catch (Exception e) {
      return;
    }
  }

  protected Optional<CardInterface> getClickedCard(int x, int y) {
    return this.grid.getClickedCard(x, y);
  }

  public void mouseReleased(int button, int x, int y) {
    Optional<CardInterface> clickedCard = this.getClickedCard(x, y);

    if (clickedCard.isPresent()) {
      this.notifyListeners(new CardClickedEvent(clickedCard.get()));
    }
  }
}
