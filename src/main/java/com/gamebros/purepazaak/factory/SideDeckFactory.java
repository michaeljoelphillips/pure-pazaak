package com.gamebros.purepazaak.factory;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.gamebros.purepazaak.entity.MainCard;
import com.gamebros.purepazaak.entity.CardInterface;
import com.gamebros.purepazaak.entity.SideDeck;

public class SideDeckFactory {
  public SideDeck build() {
    ArrayList<CardInterface> cards = new ArrayList<CardInterface>();

    while (cards.size() < 10) {
      int value = ThreadLocalRandom.current().nextInt(1, 6);

      cards.add(new MainCard(value));
    }

    return new SideDeck(cards);
  }
}
