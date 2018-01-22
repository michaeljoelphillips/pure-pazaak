package com.gamebros.purepazaak;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.gamebros.purepazaak.controller.DeckController;
import com.gamebros.purepazaak.controller.InventoryController;
import com.gamebros.purepazaak.controller.MatchController;
import com.gamebros.purepazaak.controller.UIController;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.entity.Inventory;
import com.gamebros.purepazaak.entity.Player;
import com.gamebros.purepazaak.entity.SideDeck;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.factory.SideDeckFactory;
import com.gamebros.purepazaak.view.InventoryView;

public class PurePazaak implements Game {
  protected MatchController matchController;

  protected DeckController deckController;

  protected UIController uiController;

  protected int time = 0;

  public String getTitle() {
    return "Pure Pazaak";
  }

  public boolean closeRequested() {
    return false;
  }

  public void render(GameContainer container, Graphics graphics) throws SlickException {
    this.matchController.render(graphics);
    this.deckController.render(graphics);
    this.uiController.render(graphics);
  }

  public void update(GameContainer container, int delta) {
    this.time += delta;

    if (this.time >= 1000) {
      this.matchController.update();

      this.time = 0;
    }
  }

  public void init(GameContainer container) throws SlickException {
    SideDeckFactory factory = new SideDeckFactory();

    Player playerOne = new Player(factory.build());
    Player playerTwo = new Player(factory.build());

    Match match = new Match(playerOne, playerTwo);

    this.matchController = new MatchController(match);
    this.deckController = new DeckController(
        container,
        match.getPlayerDeck(PlayerEnum.PLAYERONE),
        match
    );
    this.uiController = new UIController(container, match);

    return;
  }
}
