package com.github.nomad145.purepazaak.entity;

import java.util.ArrayList;

public class Inventory {
  protected ArrayList<CardInterface> cards;

  public Inventory() {
    cards = new ArrayList<CardInterface>();
  }

  public Inventory(ArrayList<CardInterface> cards) {
    this.cards = cards;
  }

  public ArrayList<CardInterface> getCards() {
    return cards;
  }

  public Inventory setCards(ArrayList<CardInterface> cards) {
    this.cards = cards;

    return this;
  }

  public Inventory addCard(CardInterface card) {
    cards.add(card);

    return this;
  }

  public Inventory removeCard(CardInterface card) {
    cards.remove(card);

    return this;
  }
}
