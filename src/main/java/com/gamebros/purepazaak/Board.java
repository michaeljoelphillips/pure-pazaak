package com.gamebros.purepazaak;

import java.util.ArrayList;

import com.gamebros.purepazaak.entity.Card;

public class Board {
  protected ArrayList<Card> cards = new ArrayList<Card>();

  public void addCard(Card card) {
    this.cards.add(card);
  }

  public int getTotal() {
    return this
      .cards
      .stream()
      .mapToInt(Card::getValue)
      .sum();
  }

  public ArrayList<Card> getCards() {
    return this.cards;
  }
}
