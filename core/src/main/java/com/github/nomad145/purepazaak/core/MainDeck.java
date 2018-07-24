package com.github.nomad145.purepazaak.core;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import com.github.nomad145.purepazaak.core.entity.CardInterface;
import com.github.nomad145.purepazaak.core.entity.MainCard;

public class MainDeck {
  protected LinkedList<CardInterface> cards;

  public MainDeck() {
    this.cards = new LinkedList<CardInterface>();

    // Create a deck of 40 cards numbered 1 through 10.
    for (int x = 0; x <= 4; x++) {
      for (int i = 1; i < 10; i++) {
        this.cards.add(new MainCard(i));
      }
    }

    Collections.shuffle(this.cards);
  }

  public CardInterface draw() throws NoSuchElementException {
    CardInterface card = this.cards.remove();

    return card;
  }
}
