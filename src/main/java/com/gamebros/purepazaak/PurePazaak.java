package com.gamebros.purepazaak;

import com.gamebros.purepazaak.ui.component.CardComponent;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.Image;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class PurePazaak implements Game {
  protected CardComponent testCard;

  protected CardComponent testCard2;

  public String getTitle() {
    return "Pure Pazaak";
  }

  public boolean closeRequested() {
    return false;
  }

  public void render(GameContainer container, Graphics graphics) throws SlickException {
    graphics.drawString("Pure Pazaak", 50, 50);

    testCard.render(container, graphics);
    testCard2.render(container, graphics);
  }

  public void update(GameContainer container, int delta) {
    return;
  }

  public void init(GameContainer container) throws SlickException {
    testCard = new CardComponent(container, new Image("textures/card.png"));
    testCard.setLocation(300, 300);

    testCard2 = new CardComponent(container, new Image("textures/card.png"));
    testCard2.setLocation(200, 300);

    return;
  }
}
