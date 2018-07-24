package com.github.nomad145.purepazaak.view;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.github.nomad145.purepazaak.Match;
import com.github.nomad145.purepazaak.MatchSet;
import com.github.nomad145.purepazaak.entity.CardInterface;
import com.github.nomad145.purepazaak.enumerable.PlayerEnum;
import com.github.nomad145.purepazaak.ui.CardGrid;

public class MatchSetView {
  protected MatchSet matchSet;

  protected CardGrid playerOneBoard = new CardGrid(
      140,
      160,
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
        180
    );

    graphics.drawString(
        String.valueOf(
          this.matchSet
            .getPlayerTwoBoard()
            .getTotal()
        ),
        1440,
        180
    );
  }
}
