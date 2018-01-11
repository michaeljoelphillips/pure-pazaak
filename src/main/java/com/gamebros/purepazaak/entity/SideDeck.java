package com.gamebros.purepazaak.entity;

import com.gamebros.purepazaak.exception.CardNotFoundException;
import com.gamebros.purepazaak.exception.SideDeckFullException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SideDeck {
  protected ArrayList<Card> cards;

  public SideDeck() {
    this.cards = new ArrayList<Card>();
  }

  public SideDeck(ArrayList<Card> cards) throws IllegalArgumentException {
    this.setCards(cards);
  }

  public ArrayList<Card> drawRandomCards() {
    ArrayList<Card> result = new ArrayList<Card>(4);
    ArrayList<Card> clone = new ArrayList<Card>(this.cards);

    while (result.size() < 4) {
      int index = ThreadLocalRandom.current().nextInt(0, clone.size());

      result.add(clone.get(index));

      clone.remove(index);
    }

    return result;
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  public SideDeck setCards(ArrayList<Card> cards) throws IllegalArgumentException {
    if (cards.size() > 10) {
      throw new IllegalArgumentException(String.format(
          "A Side Deck may only contain 10 cards.  %d received.",
          cards.size()
      ));
    }

    this.cards = cards;

    return this;
  }

  public SideDeck addCard(Card card) throws SideDeckFullException {
    if (cards.size() == 10) {
      throw new SideDeckFullException();
    }

    cards.add(card);

    return this;
  }

  public SideDeck removeCard(Card card) throws CardNotFoundException {
    if (!cards.contains(card)) {
      throw new CardNotFoundException();
    }

    cards.remove(card);

    return this;
  }
}
