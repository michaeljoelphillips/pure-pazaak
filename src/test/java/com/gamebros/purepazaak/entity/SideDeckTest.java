package com.gamebros.purepazaak;

import com.gamebros.purepazaak.entity.MainCard;
import com.gamebros.purepazaak.entity.CardInterface;
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
