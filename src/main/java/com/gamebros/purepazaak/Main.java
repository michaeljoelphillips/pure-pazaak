package com.gamebros.purepazaak;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
  public static void main(String[] args) throws SlickException {
    AppGameContainer app = new AppGameContainer(new HelloWorld());
    app.setDisplayMode(800, 600, false);
    app.setForceExit(false);
    app.start();
  }
}
