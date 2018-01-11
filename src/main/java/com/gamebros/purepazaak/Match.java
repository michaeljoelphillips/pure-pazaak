package com.gamebros.purepazaak;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.entity.Player;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.enumerable.WinnerEnum;

public class Match {
  protected Player playerOne;

  protected Player playerTwo;

  protected ArrayList<Card> playerOneDeck;

  protected ArrayList<Card> playerTwoDeck;

  protected ArrayList<MatchSet> sets = new ArrayList<MatchSet>();

  protected MatchSet currentSet;

  public Match(Player playerOne, Player playerTwo) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;

    this.playerOneDeck = playerOne.getSideDeck().drawRandomCards();
    this.playerTwoDeck = playerTwo.getSideDeck().drawRandomCards();
  }

  public void newSet() {
    MatchSet set = new MatchSet(new MainDeck());

    this.sets.add(set);
    this.currentSet = set;
  }

  public ArrayList<MatchSet> getMatchSets() {
    return this.sets;
  }

  public MatchSet getCurrentSet() {
    return this.currentSet;
  }

  public Player getWinner() {
    if (this.sets.size() < 3) {
      return null;
    }

    ArrayList<MatchSet> playerOne = this.sets
        .stream()
        .filter(set -> set.getWinner() == WinnerEnum.PLAYERONE)
        .collect(Collectors.toCollection(ArrayList<MatchSet>::new));

    ArrayList<MatchSet> playerTwo = this.sets
        .stream()
        .filter(set -> set.getWinner() == WinnerEnum.PLAYERTWO)
        .collect(Collectors.toCollection(ArrayList<MatchSet>::new));

    if (playerOne.size() == 3) {
      return this.playerOne;
    }

    if (playerTwo.size() == 3) {
      return this.playerTwo;
    }

    return null;
  }

  public ArrayList<Card> getPlayerDeck(PlayerEnum player) {
    return player == PlayerEnum.PLAYERONE
      ? this.playerOneDeck
      : this.playerTwoDeck;
  }
}
