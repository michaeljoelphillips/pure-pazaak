package com.gamebros.purepazaak;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import com.gamebros.purepazaak.entity.Card;

public class MainDeck {
  protected LinkedList<Card> cards;

  public MainDeck() {
    this.cards = new LinkedList<Card>();

    // Create a deck of 40 cards numbered 1 through 10.
    for (int x = 0; x <= 4; x++) {
      for (int i = 1; i < 10; i++) {
        this.cards.add(new Card(i));
      }
    }

    Collections.shuffle(this.cards);
  }

  public Card draw() throws NoSuchElementException {
    Card card = this.cards.remove();

    return card;
  }
}
