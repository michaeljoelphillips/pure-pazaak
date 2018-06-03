package com.gamebros.purepazaak.entity;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.gamebros.purepazaak.entity.CardInterface;
import com.gamebros.purepazaak.entity.MainCard;

public class InventoryTest {
  protected Inventory inventory;

  @Before
  public void setUp() {
    inventory = new Inventory();
  }

  @Test
  public void testSetCards() {
    ArrayList<CardInterface> cards = new ArrayList<CardInterface>();

    cards.add(new MainCard(1));
    cards.add(new MainCard(2));

    inventory.setCards(cards);

    assertSame(cards, inventory.getCards());
  }

  @Test
  public void testAddCard() {
    CardInterface card = new MainCard(4);

    inventory.addCard(card);

    assertTrue(inventory.getCards().contains(card));
  }

  @Test
  public void testRemoveCard() {
    ArrayList<CardInterface> cards = new ArrayList<CardInterface>();

    CardInterface card = new MainCard(4);

    cards.add(new MainCard(2));
    cards.add(new MainCard(3));
    cards.add(card);

    inventory.setCards(cards);

    inventory.removeCard(card);

    assertFalse(inventory.getCards().contains(card));
  }
}
