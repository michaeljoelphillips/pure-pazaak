package com.gamebros.purepazaak;

import java.util.ArrayList;
import java.util.HashSet;

import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.entity.Player;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.enumerable.WinnerEnum;

public class MatchSet {
  protected Board playerOneBoard = new Board();

  protected Board playerTwoBoard = new Board();

  protected MainDeck mainDeck;

  protected WinnerEnum winner = WinnerEnum.NONE;

  protected PlayerEnum currentPlayer;

  protected PlayerEnum firstPlayer;

  protected HashSet<PlayerEnum> playersStood = new HashSet<PlayerEnum>();

  public MatchSet(MainDeck mainDeck, PlayerEnum player) {
    this.mainDeck = mainDeck;
    this.setFirstPlayer(player);

    this.draw();
  }

  public WinnerEnum getWinner() {
    return this.winner;
  }

  public Board getPlayerOneBoard() {
    return this.playerOneBoard;
  }

  public Board getPlayerTwoBoard() {
    return this.playerTwoBoard;
  }

  public Board getCurrentBoard() {
    return this.currentPlayer == PlayerEnum.PLAYERONE
      ? this.playerOneBoard
      : this.playerTwoBoard;
  }

  protected void resolveWinner() {
    int playerOneScore = this.playerOneBoard.getTotal();
    int playerTwoScore = this.playerTwoBoard.getTotal();

    if (playerOneScore == playerTwoScore) {
      this.winner = WinnerEnum.TIE;

      return;
    }

    if (playerOneScore > playerTwoScore
        && playerOneScore <= 20
        || playerTwoScore > 20
    ) {
      this.winner = WinnerEnum.PLAYERONE;

      return;
    }

    if (playerTwoScore > playerOneScore
        && playerTwoScore <= 20
        || playerOneScore > 20
    ) {
      this.winner = WinnerEnum.PLAYERTWO;

      return;
    }
  }

  protected boolean bothPlayersStand() {
    return this.playersStood.size() == 2;
  }

  public boolean hasPlayerStood(PlayerEnum player) {
    return this.playersStood.contains(player);
  }

  public PlayerEnum getCurrentPlayer() {
    return this.currentPlayer;
  }

  protected void draw() {
    Card card = this.mainDeck.draw();

    this.getCurrentBoard().addCard(card);
  }

  public void stand() {
    this.playersStood.add(this.currentPlayer);

    this.endTurn();
  }

  public void endTurn() {
    if (this.bothPlayersStand()) {
      this.resolveWinner();

      return;
    }

    this.nextTurn();
  }

  protected void nextTurn() {
    int currentPlayerScore = this.getCurrentBoard().getTotal();

    if (currentPlayerScore > 20) {
      this.stand();

      return;
    }

    PlayerEnum nextPlayer = this.currentPlayer.next();

    if (!this.hasPlayerStood(nextPlayer)) {
      this.currentPlayer = nextPlayer;
    }

    this.draw();
  }

  public PlayerEnum getFirstPlayer() {
    return this.firstPlayer;
  }

  private void setFirstPlayer(PlayerEnum player) {
    this.currentPlayer = player;
    this.firstPlayer = player;
  }
}
