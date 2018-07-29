package com.github.nomad145.purepazaak.core.factory;

import com.github.nomad145.purepazaak.core.card.CardInterface;
import com.github.nomad145.purepazaak.core.card.MainCard;
import com.github.nomad145.purepazaak.core.card.FlipCard;
import com.github.nomad145.purepazaak.core.entity.MinusCard;
import com.github.nomad145.purepazaak.core.entity.PlusCard;
import com.github.nomad145.purepazaak.core.entity.SideDeck;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

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
