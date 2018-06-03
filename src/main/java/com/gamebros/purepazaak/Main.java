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
    app.setDisplayMode(1920, 1080, true);
    app.setForceExit(false);
    app.start();
  }
}
