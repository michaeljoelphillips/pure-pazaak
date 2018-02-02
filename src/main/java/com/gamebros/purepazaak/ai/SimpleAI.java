package com.gamebros.purepazaak.ai;

import java.util.ArrayList;
import java.util.Optional;

import com.gamebros.purepazaak.Board;
import com.gamebros.purepazaak.Match;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.enumerable.PlayerEnum;

public class SimpleAI {
  protected Match match;

  public SimpleAI(Match match) {
    this.match = match;
  }

  public void update() {
    // Stand if value equals 20
    // Play a card from the side deck if it would make the value equal 20
    // Play a card from the side deck to get as close to 20 as possible
    // Stand as close to 20 as possible
    // If the other play has stood, beat their score.

    if (!this.isAiTurn()) {
      return;
    }

    int currentValue = this.getCurrentValue();
    int opponentValue = this.getOpponentValue();
    ArrayList<Card> sideDeck = this.getSideDeck();

    if (currentValue == 20) {
      this.stand();

      return;
    }

    if (this.opponentHasStood()) {
      if (currentValue > opponentValue) {
        this.stand();

        return;
      }

      if (opponentValue >= 15 && opponentValue <= 20) {
        Optional<Card> card = sideDeck
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
      Optional<Card> card = sideDeck
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
      .getBoard(PlayerEnum.PLAYERTWO)
      .getTotal();
  }

  protected int getOpponentValue() {
    return this.match
      .getCurrentSet()
      .getBoard(PlayerEnum.PLAYERONE)
      .getTotal();
  }

  protected ArrayList<Card> getSideDeck() {
    return this.match.getCurrentPlayerDeck();
  }

  protected void stand() {
    System.out.println("AI stood at " + Integer.toString(this.getCurrentValue()));
    this.match.getCurrentSet().stand();
  }

  protected void endTurn() {
    System.out.println("AI ended turn at " + Integer.toString(this.getCurrentValue()));
    this.match.getCurrentSet().endTurn();
  }

  protected void playCard(Card card) {
    System.out.println("AI played card valued at " + Integer.toString(card.getValue()));
    this.getSideDeck().remove(card);
    this.getBoard().addCard(card);
  }

  protected Board getBoard() {
    return this.match.getCurrentSet().getBoard(PlayerEnum.PLAYERTWO);
  }

  protected boolean opponentHasStood() {
    return this.match
      .getCurrentSet()
      .hasStood(PlayerEnum.PLAYERONE);
  }
}
