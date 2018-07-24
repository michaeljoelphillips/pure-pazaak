package com.github.nomad145.purepazaak.core;

import com.github.nomad145.purepazaak.core.entity.MainCard;
import com.github.nomad145.purepazaak.core.entity.CardInterface;
import com.github.nomad145.purepazaak.core.entity.SideDeck;
import com.github.nomad145.purepazaak.core.exception.CardNotFoundException;
import com.github.nomad145.purepazaak.core.exception.SideDeckFullException;
import java.util.ArrayList;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class SideDeckTest {
  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void testGreaterThanTenCards() {
    ArrayList<CardInterface> cards = new ArrayList<CardInterface>();

    for (int i = 0; i < 15; i++) {
      cards.add(new MainCard(i));
    }

    exception.expect(IllegalArgumentException.class);

    new SideDeck(cards);
  }

  @Test
  public void testAddCard() throws SideDeckFullException {
    SideDeck deck = new SideDeck();

    deck.addCard(new MainCard(4));

    assertEquals(1, deck.getCards().size());
  }

  @Test
  public void testSideDeckFull() throws SideDeckFullException {
    SideDeck deck = new SideDeck();

    exception.expect(SideDeckFullException.class);

    for (int i = 1; i <= 11; i++) {
      deck.addCard(new MainCard(i));
    }
  }

  @Test
  public void testRemoveCard() throws CardNotFoundException {
    SideDeck deck = new SideDeck();

    exception.expect(CardNotFoundException.class);

    deck.removeCard(new MainCard(1));
  }

  @Test
  public void testGetRandomCards() throws SideDeckFullException {
    SideDeck deck = new SideDeck();

    for (int i = 1; i <= 10; i++) {
      deck.addCard(new MainCard(i));
    }

    ArrayList<CardInterface> playableDeck = deck.drawRandomCards();

    assertEquals(4, playableDeck.size());
  }
}
