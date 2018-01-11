package com.gamebros.purepazaak.view;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.gamebros.purepazaak.Match;
import com.gamebros.purepazaak.MatchSet;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.ui.CardGrid;

public class MatchView {
  protected Match match;

  protected CardGrid playerOneBoard = new CardGrid(
      20,
      10,
      380,
      200
  );

  protected CardGrid playerTwoBoard = new CardGrid(
      400,
      10,
      380,
      200
  );

  public MatchView(Match match) {
    this.match = match;
  }

  public void render(Graphics graphics) throws SlickException {
    MatchSet set = match.getCurrentSet();

    this.playerOneBoard.setCards(set.getBoard(PlayerEnum.PLAYERONE).getCards());
    this.playerTwoBoard.setCards(set.getBoard(PlayerEnum.PLAYERTWO).getCards());

    playerOneBoard.render(graphics);
    playerTwoBoard.render(graphics);
  }
}
