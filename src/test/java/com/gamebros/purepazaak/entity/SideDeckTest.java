package com.gamebros.purepazaak;

import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.entity.SideDeck;
import com.gamebros.purepazaak.exception.CardNotFoundException;
import com.gamebros.purepazaak.exception.SideDeckFullException;
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
    ArrayList<Card> cards = new ArrayList<Card>();

    for (int i = 0; i < 15; i++) {
      cards.add(new Card(i));
    }

    exception.expect(IllegalArgumentException.class);

    new SideDeck(cards);
  }

  @Test
  public void testAddCard() throws SideDeckFullException {
    SideDeck deck = new SideDeck();

    deck.addCard(new Card(4));

    assertEquals(1, deck.getCards().size());
  }

  @Test
  public void testSideDeckFull() throws SideDeckFullException {
    SideDeck deck = new SideDeck();

    exception.expect(SideDeckFullException.class);

    for (int i = 1; i <= 11; i++) {
      deck.addCard(new Card(i));
    }
  }

  @Test
  public void testRemoveCard() throws CardNotFoundException {
    SideDeck deck = new SideDeck();

    exception.expect(CardNotFoundException.class);

    deck.removeCard(new Card(1));
  }

  @Test
  public void testGetRandomCards() throws SideDeckFullException {
    SideDeck deck = new SideDeck();

    for (int i = 1; i <= 10; i++) {
      deck.addCard(new Card(i));
    }

    ArrayList<Card> playableDeck = deck.getRandomCards();

    assertEquals(4, playableDeck.size());
  }
}
