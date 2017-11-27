package com.gamebros.purepazaak;

import com.gamebros.purepazaak.entity.Card;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CardTest extends TestCase {
  public CardTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(CardTest.class);
  }

  /**
   * Test Value Getter.
   */
  public void testGetValue() {
    Card subject = new Card(4);

    assertEquals(4, subject.getValue());
  }
}

