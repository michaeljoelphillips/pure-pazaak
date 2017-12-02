package com.gamebros.purepazaak;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 * The Main Class for Pure Pazaak.
 */
public class Main {
  /**
   * The entrypoint for our application.
   *
   * @param String[] args
   * @throws SlickException
   * @return void
   */
  public static void main(String[] args) throws SlickException {
    AppGameContainer app = new AppGameContainer(new PurePazaak());
    app.setDisplayMode(800, 600, false);
    app.setForceExit(false);
    app.start();
  }
}
