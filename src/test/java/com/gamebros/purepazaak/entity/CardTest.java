package com.gamebros.purepazaak;

import com.gamebros.purepazaak.entity.Card;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test a Card.
 */
public class CardTest extends TestCase {
  /**
   * {@inheritdoc}
   */
  public CardTest(String testName) {
    super(testName);
  }

  /**
   * {@inheritdoc}
   */
  public static Test suite() {
    return new TestSuite(CardTest.class);
  }

  /**
   * Test Value Getter.
   */
  public void testGetValue() {
    Card positive = new Card(4);
    Card negative = new Card(-6);

    assertEquals(4, positive.getValue());
    assertEquals(-6, negative.getValue());
  }
}

