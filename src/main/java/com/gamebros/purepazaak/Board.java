package com.gamebros.purepazaak;

import java.util.ArrayList;

import com.gamebros.purepazaak.entity.CardInterface;

public class Board {
  protected ArrayList<CardInterface> cards = new ArrayList<CardInterface>();

  public void addCard(CardInterface card) {
    this.cards.add(card);
  }

  public int getTotal() {
    return this
      .cards
      .stream()
      .mapToInt(CardInterface::getValue)
      .sum();
  }

  public ArrayList<CardInterface> getCards() {
    return this.cards;
  }
}
