package com.gamebros.purepazaak.view;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.gamebros.purepazaak.Match;
import com.gamebros.purepazaak.MatchSet;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.ui.CardGrid;

public class MatchSetView {
  protected MatchSet matchSet;

  protected CardGrid playerOneBoard = new CardGrid(
      190,
      235,
      580,
      570
  );

  protected CardGrid playerTwoBoard = new CardGrid(
      1160,
      235,
      580,
      570
  );

  public MatchSetView(MatchSet matchSet) {
    this.matchSet = matchSet;
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
        480,
        200
    );

    graphics.drawString(
        String.valueOf(
          this.matchSet
            .getPlayerTwoBoard()
            .getTotal()
        ),
        1440,
        200
    );
  }
}
