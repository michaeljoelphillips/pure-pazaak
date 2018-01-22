package com.gamebros.purepazaak.controller;

import java.util.Optional;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.gamebros.purepazaak.Match;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.enumerable.WinnerEnum;
import com.gamebros.purepazaak.view.DeckView;
import com.gamebros.purepazaak.view.MatchSetView;

public class MatchController {
  protected Match match;

  protected MatchSetView matchSetView;

  protected DeckView playerTwoDeckView;

  public MatchController(Match match) {
    this.match = match;
    this.init();
  }

  public void update() {
    if (this.match.getCurrentSet().getCurrentPlayer() == PlayerEnum.PLAYERTWO) {
      this.match.getCurrentSet().endTurn();
    }

    if (this.match.getCurrentSet().getWinner() != WinnerEnum.NONE) {
      this.startNewSet();
    }
  }

  public void render(Graphics graphics) {
    try {
      this.matchSetView.render(graphics);
      this.playerTwoDeckView.render(graphics);
    } catch (Exception e) {
      return;
    }
  }

  private void init() {
    this.startNewSet();
    this.createPlayerTwoDeck();
  }

  private void startNewSet() {
    this.matchSetView = new MatchSetView(this.match.newSet());
  }

  private void createPlayerTwoDeck() {
    this.playerTwoDeckView = new DeckView(
        this.match.getPlayerDeck(PlayerEnum.PLAYERTWO),
        400,
        480,
        380,
        100
    );
  }
}
