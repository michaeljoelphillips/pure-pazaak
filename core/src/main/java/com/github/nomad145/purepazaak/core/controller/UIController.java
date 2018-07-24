package com.github.nomad145.purepazaak.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.github.nomad145.purepazaak.Match;
import com.github.nomad145.purepazaak.event.ContextualEventInterface;
import com.github.nomad145.purepazaak.listener.ActionListenerInterface;
import com.github.nomad145.purepazaak.view.ButtonView;

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
    this.endTurnButton = new ButtonView("End Turn", 910, 870);
    this.standButton = new ButtonView("Stand", 910, 910);

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
