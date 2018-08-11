package com.github.nomad145.purepazaak.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.github.nomad145.purepazaak.core.card.CardInterface;
import com.github.nomad145.purepazaak.core.entity.Player;
import com.github.nomad145.purepazaak.core.enumerable.PlayerEnum;
import com.github.nomad145.purepazaak.core.enumerable.WinnerEnum;

public class Match {
  protected Player playerOne;

  protected Player playerTwo;

  protected ArrayList<CardInterface> playerOneDeck;

  protected ArrayList<CardInterface> playerTwoDeck;

  protected ArrayList<MatchSet> matchSets = new ArrayList<MatchSet>();

  protected MatchSet currentSet;

  public Match(Player playerOne, Player playerTwo) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;

    this.playerOneDeck = playerOne.getSideDeck().drawRandomCards();
    this.playerTwoDeck = playerTwo.getSideDeck().drawRandomCards();
  }

  public MatchSet createNewSet() {
    MainDeck newMainDeck = new MainDeck();

    PlayerEnum firstPlayer = this.decideNextPlayer();
    MatchSet newMatchSet = new MatchSet(newMainDeck, firstPlayer);

    this.matchSets.add(newMatchSet);
    this.currentSet = newMatchSet;

    return this.currentSet;
  }

  private PlayerEnum decideNextPlayer() {
    if (this.matchSets.size() == 0) {
      return this.drawForFirstPlayer();
    }

    WinnerEnum winner = this.currentSet.getWinner();
    PlayerEnum nextPlayer = null;

    switch (winner) {
      case PLAYERONE:
        nextPlayer = PlayerEnum.PLAYERONE;

        break;
      case PLAYERTWO:
        nextPlayer = PlayerEnum.PLAYERTWO;

        break;
      case NONE:
        nextPlayer = this.drawForFirstPlayer();

        break;
      case TIE:
      default:
        nextPlayer = this.currentSet.getFirstPlayer().next();

        break;
    }

    return nextPlayer;
  }

  private PlayerEnum drawForFirstPlayer() {
    MainDeck deck = new MainDeck();

    int playerOneDraw = deck.draw().getValue();
    int playerTwoDraw = deck.draw().getValue();

    if (playerOneDraw > playerTwoDraw) {
      return PlayerEnum.PLAYERONE;
    }

    if (playerTwoDraw > playerOneDraw) {
      return PlayerEnum.PLAYERTWO;
    }

    // If card values are tied, draw again.
    return this.drawForFirstPlayer();
  }

  public ArrayList<MatchSet> getMatchSets() {
    return this.matchSets;
  }

  public MatchSet getCurrentSet() {
    return this.currentSet;
  }

  public Player getWinner() {
    if (this.matchSets.size() < 3) {
      return null;
    }

    ArrayList<MatchSet> playerOne = this.matchSets
        .stream()
        .filter(matchSet -> matchSet.getWinner() == WinnerEnum.PLAYERONE)
        .collect(Collectors.toCollection(ArrayList<MatchSet>::new));

    ArrayList<MatchSet> playerTwo = this.matchSets
        .stream()
        .filter(matchSet -> matchSet.getWinner() == WinnerEnum.PLAYERTWO)
        .collect(Collectors.toCollection(ArrayList<MatchSet>::new));

    if (playerOne.size() == 3) {
      return this.playerOne;
    }

    if (playerTwo.size() == 3) {
      return this.playerTwo;
    }

    return null;
  }

  public ArrayList<CardInterface> getPlayerOneDeck() {
    return this.playerOneDeck;
  }

  public ArrayList<CardInterface> getPlayerTwoDeck() {
    return this.playerTwoDeck;
  }

  public ArrayList<CardInterface> getCurrentPlayerDeck() {
    MatchSet currentSet = this.getCurrentSet();
    PlayerEnum currentPlayer = currentSet.getCurrentPlayer();

    return currentPlayer == PlayerEnum.PLAYERONE
      ? this.playerOneDeck
      : this.playerTwoDeck;
  }
}
