package com.gamebros.purepazaak.entity;

import com.gamebros.purepazaak.entity.CardInterface;

/**
 * Card
 *
 * @todo Simplify this down to a single class.  The class should be able to
 * take +/- values.
 */
public class Card implements CardInterface {
  protected int value;

  /**
   * Card Constructor.
   *
   * @param int cardValue
   */
  public Card(int cardValue) {
    value = cardValue;
  }

  public int getValue() {
    return value;
  }
}
