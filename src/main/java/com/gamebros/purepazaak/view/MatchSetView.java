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
      20,
      60,
      380,
      330
  );

  protected CardGrid playerTwoBoard = new CardGrid(
      400,
      60,
      380,
      330
  );

  public MatchSetView(MatchSet matchSet) {
    this.matchSet = matchSet;
  }

  public void render(Graphics graphics) throws SlickException {
    this.playerOneBoard.setCards(
        this.matchSet
          .getBoard(PlayerEnum.PLAYERONE)
          .getCards()
    );

    this.playerTwoBoard.setCards(
        this.matchSet
          .getBoard(PlayerEnum.PLAYERTWO)
          .getCards()
    );

    playerOneBoard.render(graphics);
    playerTwoBoard.render(graphics);

    graphics.drawString(
        String.valueOf(
          this.matchSet
            .getBoard(PlayerEnum.PLAYERONE)
            .getTotal()
        ),
        180,
        20
    );

    graphics.drawString(
        String.valueOf(
          this.matchSet
            .getBoard(PlayerEnum.PLAYERTWO)
            .getTotal()
        ),
        580,
        20
    );
  }
}
