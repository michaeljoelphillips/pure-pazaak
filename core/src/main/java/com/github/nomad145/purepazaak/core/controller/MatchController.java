package com.github.nomad145.purepazaak.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.github.nomad145.purepazaak.Match;
import com.github.nomad145.purepazaak.MatchSet;
import com.github.nomad145.purepazaak.entity.CardInterface;
import com.github.nomad145.purepazaak.enumerable.PlayerEnum;
import com.github.nomad145.purepazaak.enumerable.WinnerEnum;
import com.github.nomad145.purepazaak.view.DeckView;
import com.github.nomad145.purepazaak.view.MatchSetView;
import com.github.nomad145.purepazaak.view.PlayerTwoDeckView;

public class MatchController {
  protected Match match;

  protected MatchSetView matchSetView;

  protected DeckView playerTwoDeckView;

  public MatchController(Match match) {
    this.match = match;
    this.init();
  }

  public void update() {
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
    this.createPlayerTwoDeckView();
  }

  private void startNewSet() {
    MatchSet matchSet = this.match.createNewSet();

    this.matchSetView = new MatchSetView(matchSet);
  }

  private void createPlayerTwoDeckView() {
    ArrayList<CardInterface> playerTwoDeck = this.match.getPlayerTwoDeck();

    this.playerTwoDeckView = new PlayerTwoDeckView(playerTwoDeck);
  }
}
