package com.github.nomad145.purepazaak;

import com.github.nomad145.purepazaak.Board;
import com.github.nomad145.purepazaak.MainDeck;
import com.github.nomad145.purepazaak.entity.CardInterface;
import com.github.nomad145.purepazaak.entity.MainCard;
import com.github.nomad145.purepazaak.enumerable.PlayerEnum;
import com.github.nomad145.purepazaak.enumerable.WinnerEnum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MatchSetTest {
  protected MatchSet matchSet;

  @Before
  public void setUp() {
    this.matchSet = new MatchSet(new MainDeck(), PlayerEnum.PLAYERONE);
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
    Board playerOneBoard = this.matchSet.getPlayerOneBoard();
    Board playerTwoBoard = this.matchSet.getPlayerTwoBoard();

    assertNotSame(playerOneBoard, playerTwoBoard);
  }

  @Test
  public void testGetCurrentPlayer() {
    assertEquals(PlayerEnum.PLAYERONE, this.matchSet.getCurrentPlayer());
  }

  @Test
  public void testPlayerOneWins() {
    this.matchSet
      .getCurrentBoard()
      .addCard(new MainCard(10));

    this.matchSet.stand();

    this.matchSet.stand();

    assertEquals(WinnerEnum.PLAYERONE, this.matchSet.getWinner());
  }

  @Test
  public void testPlayerTwoWins() {
    this.matchSet.stand();

    this.matchSet
      .getCurrentBoard()
      .addCard(new MainCard(10));

    this.matchSet.stand();

    assertEquals(WinnerEnum.PLAYERTWO, this.matchSet.getWinner());
  }

  @Test
  public void testPlayerOneBusts() {
    this.matchSet
      .getCurrentBoard()
      .addCard(new MainCard(21));

    this.matchSet.stand();

    this.matchSet.stand();

    assertEquals(WinnerEnum.PLAYERTWO, this.matchSet.getWinner());
  }

  @Test
  public void testPlayerTwoBusts() {
    this.matchSet.stand();

    this.matchSet
      .getCurrentBoard()
      .addCard(new MainCard(21));

    this.matchSet.stand();

    assertEquals(WinnerEnum.PLAYERONE, this.matchSet.getWinner());
  }
}
