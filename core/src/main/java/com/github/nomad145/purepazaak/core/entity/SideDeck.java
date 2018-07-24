package com.github.nomad145.purepazaak.entity;

import com.github.nomad145.purepazaak.exception.CardNotFoundException;
import com.github.nomad145.purepazaak.exception.SideDeckFullException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SideDeck {
  protected ArrayList<CardInterface> cards;

  public SideDeck() {
    this.cards = new ArrayList<CardInterface>();
  }

  public SideDeck(ArrayList<CardInterface> cards) throws IllegalArgumentException {
    this.setCards(cards);
  }

  public ArrayList<CardInterface> drawRandomCards() {
    ArrayList<CardInterface> result = new ArrayList<CardInterface>(4);
    ArrayList<CardInterface> clone = new ArrayList<CardInterface>(this.cards);

    while (result.size() < 4) {
      int index = ThreadLocalRandom.current().nextInt(0, clone.size());

      result.add(clone.get(index));

      clone.remove(index);
    }

    return result;
  }

  public ArrayList<CardInterface> getCards() {
    return cards;
  }

  public SideDeck setCards(ArrayList<CardInterface> cards) throws IllegalArgumentException {
    if (cards.size() > 10) {
      throw new IllegalArgumentException(String.format(
          "A Side Deck may only contain 10 cards.  %d received.",
          cards.size()
      ));
    }

    this.cards = cards;

    return this;
  }

  public SideDeck addCard(CardInterface card) throws SideDeckFullException {
    if (cards.size() == 10) {
      throw new SideDeckFullException();
    }

    cards.add(card);

    return this;
  }

  public SideDeck removeCard(CardInterface card) throws CardNotFoundException {
    if (!cards.contains(card)) {
      throw new CardNotFoundException();
    }

    cards.remove(card);

    return this;
  }
}
