package com.gamebros.purepazaak;

import com.gamebros.purepazaak.entity.ReversableCard;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReversableCardTest {
  @Test
  public void testInvertValue() {
    ReversableCard card = new ReversableCard(4);

    card.reverseValue();
    assertEquals(-4, card.getValue());
  }
}
