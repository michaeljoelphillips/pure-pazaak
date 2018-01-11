package com.gamebros.purepazaak;

import com.gamebros.purepazaak.entity.Card;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;
import java.util.LinkedList;

public class MainDeck {
  protected LinkedList<Card> cards;

  public MainDeck() {
    this.cards = new LinkedList<Card>();

    // Create a deck of 40 cards numbered 1 through 10.
    for (int x = 0; x < 3; x++) {
      for (int i = 1; i < 10; i++) {
        this.cards.add(new Card(i));
      }
    }

    Collections.shuffle(this.cards);
  }

  public Card draw() {
    Card card = this.cards.poll();

    return card;
  }
}
