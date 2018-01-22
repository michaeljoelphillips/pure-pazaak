package com.gamebros.purepazaak.controller;

import java.awt.Container;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.gamebros.purepazaak.Match;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.event.CardClickedEvent;
import com.gamebros.purepazaak.event.ContextualEventInterface;
import com.gamebros.purepazaak.listener.ActionListenerInterface;
import com.gamebros.purepazaak.view.DeckView;

public class DeckController extends AbstractController implements ActionListenerInterface {
  protected GameContainer container;

  protected ArrayList<Card> deck;

  protected DeckView deckView;

  protected Match match;

  public DeckController(
      GameContainer container,
      ArrayList<Card> deck,
      Match match
  ) {
    this.container = container;
    this.deck = deck;
    this.match = match;
    this.init();
  }

  public void render(Graphics graphics) {
    try {
      this.deckView.render(graphics);
    } catch (Exception e) {
      return;
    }
  }

  protected void init() {
    this.deckView = new DeckView(
        this.deck,
        20,
        480,
        380,
        100
    );

    // @TODO: See refactor notes.
    this.deckView.addListener(this);
    this.container.getInput().addMouseListener(this.deckView);
  }

  /**
   */
  public void handle(ContextualEventInterface event) {
    // @TODO: Throw exceptions when bad things happen.
    // if (!event.get().isPresent()) {
    //   throw new Exception("Cannot handle an event without a Card Set.");
    // }

    Card clickedCard = (Card) event.get().get();

    this.deck.remove(clickedCard);

    this.match
      .getCurrentSet()
      .getBoard(PlayerEnum.PLAYERONE)
      .addCard(clickedCard);
  }
}
