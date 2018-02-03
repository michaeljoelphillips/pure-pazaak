package com.gamebros.purepazaak.entity;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class InventoryTest {
  protected Inventory inventory;

  @Before
  public void setUp() {
    inventory = new Inventory();
  }

  @Test
  public void testSetCards() {
    ArrayList<Card> cards = new ArrayList<Card>();

    cards.add(new Card(1));
    cards.add(new Card(2));

    inventory.setCards(cards);

    assertSame(cards, inventory.getCards());
  }

  @Test
  public void testAddCard() {
    Card card = new Card(4);

    inventory.addCard(card);

    assertTrue(inventory.getCards().contains(card));
  }

  @Test
  public void testRemoveCard() {
    ArrayList<Card> cards = new ArrayList<Card>();

    Card card = new Card(4);

    cards.add(new Card(2));
    cards.add(new Card(3));
    cards.add(card);

    inventory.setCards(cards);

    inventory.removeCard(card);

    assertFalse(inventory.getCards().contains(card));
  }
}
