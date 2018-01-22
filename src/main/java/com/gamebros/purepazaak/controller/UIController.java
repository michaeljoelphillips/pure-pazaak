package com.gamebros.purepazaak.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.gamebros.purepazaak.Match;
import com.gamebros.purepazaak.event.ContextualEventInterface;
import com.gamebros.purepazaak.listener.ActionListenerInterface;
import com.gamebros.purepazaak.view.ButtonView;

public class UIController
{
  protected GameContainer container;

  protected Match match;

  protected ButtonView endTurnButton;

  protected ButtonView standButton;

  public UIController(GameContainer container, Match match) {
    this.container = container;
    this.match = match;

    this.init();
  }

  protected void init() {
    this.endTurnButton = new ButtonView("End Turn", 100, 410);
    this.standButton = new ButtonView("Stand", 210, 410);

    this.endTurnButton.addListener(
        new ActionListenerInterface() {
          public void handle(ContextualEventInterface event) {
            endTurn();
          }
        }
    );

    this.standButton.addListener(
        new ActionListenerInterface() {
          public void handle(ContextualEventInterface event) {
            stand();
          }
        }
    );

    this.container.getInput().addMouseListener(this.endTurnButton);
    this.container.getInput().addMouseListener(this.standButton);
  }

  public void endTurn() {
    this.match.getCurrentSet().endTurn();
  }

  public void stand() {
    this.match.getCurrentSet().stand();
  }

  public void render(Graphics graphics) {
    this.endTurnButton.render(graphics);
    this.standButton.render(graphics);
  }
}
