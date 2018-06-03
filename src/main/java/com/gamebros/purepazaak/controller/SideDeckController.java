package com.gamebros.purepazaak.controller;

import java.awt.Container;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.gamebros.purepazaak.Match;
import com.gamebros.purepazaak.entity.CardInterface;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.event.CardClickedEvent;
import com.gamebros.purepazaak.event.ContextualEventInterface;
import com.gamebros.purepazaak.listener.ActionListenerInterface;
import com.gamebros.purepazaak.view.DeckView;
import com.gamebros.purepazaak.view.PlayerOneDeckView;

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
