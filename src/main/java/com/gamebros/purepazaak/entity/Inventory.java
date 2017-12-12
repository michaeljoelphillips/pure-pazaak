package com.gamebros.purepazaak.entity;

import java.util.ArrayList;

public class Inventory {
  protected ArrayList<Card> cards;

  public Inventory() {
    cards = new ArrayList<Card>();
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  public Inventory setCards(ArrayList<Card> cards) {
    this.cards = cards;

    return this;
  }

  public Inventory addCard(Card card) {
    cards.add(card);

    return this;
  }

  public Inventory removeCard(Card card) {
    cards.remove(card);

    return this;
  }
}
