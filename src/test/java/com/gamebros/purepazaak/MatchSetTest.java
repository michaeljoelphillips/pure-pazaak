package com.gamebros.purepazaak;

import com.gamebros.purepazaak.Board;
import com.gamebros.purepazaak.MainDeck;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.enumerable.WinnerEnum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MatchSetTest {
  protected MatchSet matchSet;

  @Before
  public void setUp() {
    this.matchSet = new MatchSet(new MainDeck());
  }

  @Test
  public void testEndTurnChangesCurrentPlayer() {
    this.matchSet.endTurn();
    assertEquals(PlayerEnum.PLAYERTWO, this.matchSet.getCurrentPlayer());

    this.matchSet.endTurn();
    assertEquals(PlayerEnum.PLAYERONE, this.matchSet.getCurrentPlayer());
  }

  @Test
  public void testGetBoard() {
    Board playerOneBoard = this.matchSet.getBoard(PlayerEnum.PLAYERONE);
    Board playerTwoBoard = this.matchSet.getBoard(PlayerEnum.PLAYERTWO);

    assertNotSame(playerOneBoard, playerTwoBoard);
  }

  @Test
  public void testGetCurrentPlayer() {
    assertEquals(PlayerEnum.PLAYERONE, this.matchSet.getCurrentPlayer());
  }

  @Test
  public void testPlayerOneWins() {
    this.matchSet
      .getBoard(this.matchSet.getCurrentPlayer())
      .addCard(new Card(10));

    this.matchSet.stand();

    this.matchSet.stand();

    assertEquals(WinnerEnum.PLAYERONE, this.matchSet.getWinner());
  }

  @Test
  public void testPlayerTwoWins() {
    this.matchSet.stand();

    this.matchSet
      .getBoard(this.matchSet.getCurrentPlayer())
      .addCard(new Card(10));

    this.matchSet.stand();

    assertEquals(WinnerEnum.PLAYERTWO, this.matchSet.getWinner());
  }

  @Test
  public void testPlayerOneBusts() {
    this.matchSet
      .getBoard(this.matchSet.getCurrentPlayer())
      .addCard(new Card(21));

    this.matchSet.stand();

    this.matchSet.stand();

    assertEquals(WinnerEnum.PLAYERTWO, this.matchSet.getWinner());
  }

  @Test
  public void testPlayerTwoBusts() {
    this.matchSet.stand();

    this.matchSet
      .getBoard(this.matchSet.getCurrentPlayer())
      .addCard(new Card(21));

    this.matchSet.stand();

    assertEquals(WinnerEnum.PLAYERONE, this.matchSet.getWinner());
  }
}
