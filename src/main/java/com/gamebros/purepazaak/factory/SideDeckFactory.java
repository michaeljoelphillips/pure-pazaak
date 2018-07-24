package com.github.nomad145.purepazaak.factory;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

import com.github.nomad145.purepazaak.entity.FlipCard;
import com.github.nomad145.purepazaak.entity.MinusCard;
import com.github.nomad145.purepazaak.entity.PlusCard;
import com.github.nomad145.purepazaak.entity.MainCard;
import com.github.nomad145.purepazaak.entity.CardInterface;
import com.github.nomad145.purepazaak.entity.SideDeck;

public class SideDeckFactory {
  public SideDeck build() {
    ArrayList<CardInterface> cards = new ArrayList<CardInterface>();

    while (cards.size() < 10) {
      int value = ThreadLocalRandom.current().nextInt(-6, 6);
      float chance = (new Random()).nextFloat();

      if (chance <= 0.10f) {
        cards.add(new FlipCard(value));
      } else {
        if (value < 0) {
          cards.add(new MinusCard(value));
        }

        if (value > 0) {
          cards.add(new PlusCard(value));
        }
      }
    }

    return new SideDeck(cards);
  }
}
