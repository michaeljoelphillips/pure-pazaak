package com.gamebros.purepazaak;

import com.gamebros.purepazaak.entity.FlipCard;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FlipCardTest {
  @Test
  public void testFlip() {
    FlipCard subject = new FlipCard(6);

    subject.flip();
    assertEquals(-6, subject.getValue());

    subject.flip();
    assertEquals(6, subject.getValue());
  }
}
