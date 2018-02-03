package com.gamebros.purepazaak.factory;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.entity.ReversableCard;
import com.gamebros.purepazaak.entity.SideDeck;

public class SideDeckFactory {
  public SideDeck build() {
    ArrayList<Card> cards = new ArrayList<Card>();

    while (cards.size() < 10) {
      int value = ThreadLocalRandom.current().nextInt(1, 6);

      cards.add(new ReversableCard(value));
    }

    return new SideDeck(cards);
  }
}
