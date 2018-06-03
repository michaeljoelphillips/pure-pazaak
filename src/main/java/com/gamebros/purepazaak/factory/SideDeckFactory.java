package com.gamebros.purepazaak.factory;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

import com.gamebros.purepazaak.entity.FlipCard;
import com.gamebros.purepazaak.entity.MinusCard;
import com.gamebros.purepazaak.entity.PlusCard;
import com.gamebros.purepazaak.entity.MainCard;
import com.gamebros.purepazaak.entity.CardInterface;
import com.gamebros.purepazaak.entity.SideDeck;

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
