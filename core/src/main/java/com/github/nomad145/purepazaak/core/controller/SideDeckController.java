package com.github.nomad145.purepazaak.controller;

import java.awt.Container;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.github.nomad145.purepazaak.Match;
import com.github.nomad145.purepazaak.entity.CardInterface;
import com.github.nomad145.purepazaak.enumerable.PlayerEnum;
import com.github.nomad145.purepazaak.event.CardClickedEvent;
import com.github.nomad145.purepazaak.event.ContextualEventInterface;
import com.github.nomad145.purepazaak.listener.ActionListenerInterface;
import com.github.nomad145.purepazaak.view.DeckView;
import com.github.nomad145.purepazaak.view.PlayerOneDeckView;

public class SideDeckController extends AbstractController implements ActionListenerInterface {
  protected GameContainer container;

  protected ArrayList<CardInterface> sideDeck;

  protected DeckView sideDeckView;

  protected Match match;

  public SideDeckController(GameContainer container, Match match) {
    this.container = container;
    this.match = match;

    this.init();
  }

  public void render(Graphics graphics) {
    try {
      this.sideDeckView.render(graphics);
    } catch (Exception e) {
      return;
    }
  }

  protected void init() {
    this.sideDeck = this.match.getPlayerOneDeck();

    this.createDeckView();
    this.addInputListeners();
  }

  private void createDeckView() {
    this.sideDeckView = new PlayerOneDeckView(this.sideDeck);
  }

  private void addInputListeners() {
    this.sideDeckView.addListener(this);
    this.container.getInput().addMouseListener(this.sideDeckView);
  }

  /**
   */
  public void handle(ContextualEventInterface event) {
    // @TODO: Throw exceptions when bad things happen.
    // if (!event.get().isPresent()) {
    //   throw new Exception("Cannot handle an event without a Card Set.");
    // }

    CardInterface clickedCard = (CardInterface) event.get().get();

    this.sideDeck.remove(clickedCard);

    this.match
      .getCurrentSet()
      .getPlayerOneBoard()
      .addCard(clickedCard);
  }
}
