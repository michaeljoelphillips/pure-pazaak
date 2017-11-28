package com.gamebros.purepazaak;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class HelloWorld implements Game {
  public String getTitle() {
    return "Pure Pazaak";
  }

  public boolean closeRequested() {
    return false;
  }

  public void render(GameContainer container, Graphics graphics) throws SlickException {
    graphics.drawString("Pure Pazaak", 50, 50);
  }

  public void update(GameContainer container, int delta) {
    return;
  }

  public void init(GameContainer container) {
    return;
  }
}
