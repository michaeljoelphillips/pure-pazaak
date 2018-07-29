package com.github.nomad145.purepazaak.core.entity;

import com.github.nomad145.purepazaak.core.card.MainCard;
import com.github.nomad145.purepazaak.core.card.CardInterface;
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
    CardInterface positive = new MainCard(4);
    CardInterface negative = new MainCard(-6);

    assertEquals(4, positive.getValue());
    assertEquals(-6, negative.getValue());
  }
}

