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

  public MatchView(Match match) {
    this.match = match;
  }

  public void render(Graphics graphics) throws SlickException {
    MatchSet set = match.getCurrentSet();

    this.playerOneBoard.setCards(set.getBoard(PlayerEnum.PLAYERONE).getCards());
    this.playerTwoBoard.setCards(set.getBoard(PlayerEnum.PLAYERTWO).getCards());

    playerOneBoard.render(graphics);
    playerTwoBoard.render(graphics);

    graphics.drawString(
        String.valueOf(
          this.match
            .getCurrentSet()
            .getBoard(PlayerEnum.PLAYERONE)
            .getTotal()
        ),
        180,
        20
    );

    graphics.drawString(
        String.valueOf(
          this.match
            .getCurrentSet()
            .getBoard(PlayerEnum.PLAYERTWO)
            .getTotal()
        ),
        580,
        20
    );
  }
}
