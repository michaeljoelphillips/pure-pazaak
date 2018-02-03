package com.gamebros.purepazaak.view;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.gamebros.purepazaak.Match;
import com.gamebros.purepazaak.MatchSet;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.ui.CardGrid;
import com.gamebros.purepazaak.valueobject.Area;

public class MatchSetView {
  protected MatchSet matchSet;

  protected CardGrid playerOneBoard;

  protected CardGrid playerTwoBoard;

  public MatchSetView(MatchSet matchSet) {
    this.matchSet = matchSet;

    this.playerOneBoard = new CardGrid(new Area(20, 60, 380, 330));
    this.playerTwoBoard = new CardGrid(new Area(400, 60, 380, 330));
  }

  public void render(Graphics graphics) throws SlickException {
    this.playerOneBoard.setCards(
        this.matchSet
          .getPlayerOneBoard()
          .getCards()
    );

    this.playerTwoBoard.setCards(
        this.matchSet
          .getPlayerTwoBoard()
          .getCards()
    );

    playerOneBoard.render(graphics);
    playerTwoBoard.render(graphics);

    graphics.drawString(
        String.valueOf(
          this.matchSet
            .getPlayerOneBoard()
            .getTotal()
        ),
        180,
        20
    );

    graphics.drawString(
        String.valueOf(
          this.matchSet
            .getPlayerTwoBoard()
            .getTotal()
        ),
        580,
        20
    );
  }
}
