package com.gamebros.purepazaak.controller;

import java.util.Optional;

import org.newdawn.slick.Graphics;

import com.gamebros.purepazaak.Match;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.enumerable.WinnerEnum;
import com.gamebros.purepazaak.view.ButtonView;
import com.gamebros.purepazaak.view.DeckView;
import com.gamebros.purepazaak.view.MatchView;

public class MatchController extends AbstractController {
  protected Match match;

  protected MatchView matchView;

  protected DeckView playerOneDeckView;

  protected DeckView playerTwoDeckView;

  protected ButtonView endTurnButton;

  protected ButtonView standButton;

  public MatchController(Match match) {
    this.match = match;
    this.match.newSet();

    this.init();
  }

  public void update() {
    if (this.match.getCurrentSet().getCurrentPlayer() == PlayerEnum.PLAYERTWO) {
      this.match.getCurrentSet().endTurn();
    }

    if (this.match.getCurrentSet().getWinner() != WinnerEnum.NONE) {
      this.match.newSet();

      this.matchView = new MatchView(this.match);
    }
  }

  public void render(Graphics graphics) {
    try {
      this.matchView.render(graphics);
      this.playerOneDeckView.render(graphics);
      this.playerTwoDeckView.render(graphics);
      this.endTurnButton.render(graphics);
      this.standButton.render(graphics);
    } catch (Exception e) {
      return;
    }
  }

  public void mouseReleased(int button, int x, int y) {
    Optional<Card> clickedCard = this.playerOneDeckView.getClickedCard(x, y);

    if (clickedCard.isPresent()) {
      this.match
        .getCurrentSet()
        .getBoard(PlayerEnum.PLAYERONE)
        .addCard(clickedCard.get());

      this.match.getPlayerDeck(PlayerEnum.PLAYERONE).remove(clickedCard.get());
    }

    if (this.endTurnButton.isClicked(x, y)) {
      this.match.getCurrentSet().endTurn();
    }

    if (this.standButton.isClicked(x, y)) {
      this.match.getCurrentSet().stand();
    }
  }

  private void init() {
    this.matchView = new MatchView(this.match);

    this.playerOneDeckView = new DeckView(
        this.match.getPlayerDeck(PlayerEnum.PLAYERONE),
        20,
        480,
        380,
        100
    );

    this.playerTwoDeckView = new DeckView(
        this.match.getPlayerDeck(PlayerEnum.PLAYERTWO),
        400,
        480,
        380,
        100
    );


    this.endTurnButton = new ButtonView("End Turn", 100, 410);
    this.standButton = new ButtonView("Stand", 210, 410);
  }
}
