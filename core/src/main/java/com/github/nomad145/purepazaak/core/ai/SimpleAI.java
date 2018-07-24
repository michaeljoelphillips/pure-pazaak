package com.github.nomad145.purepazaak.ai;

import java.util.ArrayList;
import java.util.Optional;

import com.github.nomad145.purepazaak.Board;
import com.github.nomad145.purepazaak.Match;
import com.github.nomad145.purepazaak.entity.CardInterface;
import com.github.nomad145.purepazaak.enumerable.PlayerEnum;

public class SimpleAI {
  protected Match match;

  public SimpleAI(Match match) {
    this.match = match;
  }

  public void update() {
    if (!this.isAiTurn()) {
      return;
    }

    int currentValue = this.getCurrentValue();
    int opponentValue = this.getOpponentValue();
    ArrayList<CardInterface> sideDeck = this.getSideDeck();

    if (currentValue == 20) {
      this.stand();

      return;
    }

    if (this.hasPlayerStood()) {
      if (currentValue > opponentValue && currentValue <= 20) {
        this.stand();

        return;
      }

      if (opponentValue >= 15 && opponentValue <= 20) {
        Optional<CardInterface> card = sideDeck
            .stream()
            .filter(
                c -> c.getValue() + currentValue >= opponentValue
                && c.getValue() + currentValue <= 20
            )
            .findFirst();

        if (card.isPresent()) {
          this.playCard(card.get());
          this.stand();

          return;
        }
      }

      if (currentValue == opponentValue) {
        this.stand();

        return;
      }
    }

    if (currentValue >= 14 && sideDeck.size() > 0) {
      Optional<CardInterface> card = sideDeck
          .stream()
          .filter(c -> c.getValue() + currentValue == 20)
          .findFirst();

      if (card.isPresent()) {
        this.playCard(card.get());

        return;
      }
    }

    this.endTurn();
  }

  protected boolean isAiTurn() {
    return this.match
      .getCurrentSet()
      .getCurrentPlayer() == PlayerEnum.PLAYERTWO;
  }

  protected int getCurrentValue() {
    return this.match
      .getCurrentSet()
      .getPlayerTwoBoard()
      .getTotal();
  }

  protected int getOpponentValue() {
    return this.match
      .getCurrentSet()
      .getPlayerOneBoard()
      .getTotal();
  }

  protected ArrayList<CardInterface> getSideDeck() {
    return this.match.getCurrentPlayerDeck();
  }

  protected void stand() {
    this.match.getCurrentSet().stand();
  }

  protected void endTurn() {
    this.match.getCurrentSet().endTurn();
  }

  protected void playCard(CardInterface card) {
    this.getSideDeck().remove(card);
    this.getBoard().addCard(card);
  }

  protected Board getBoard() {
    return this.match.getCurrentSet().getPlayerTwoBoard();
  }

  protected boolean hasPlayerStood() {
    return this.match
      .getCurrentSet()
      .hasPlayerStood(PlayerEnum.PLAYERONE);
  }
}
