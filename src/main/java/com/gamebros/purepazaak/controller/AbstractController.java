package com.gamebros.purepazaak.controller;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.Input;
import org.newdawn.slick.Graphics;

public abstract class AbstractController implements MouseListener {
  protected boolean acceptsInput = true;

  public abstract void render(Graphics graphics);

  public void mouseClicked(int button, int x, int y, int count) {
    return;
  }

  public void mouseDragged(int oldx, int oldy, int x, int y) {
    return;
  }

  public void mouseMoved(int oldx, int oldy, int x, int y) {
    return;
  }

  public void mousePressed(int button, int x, int y) {
    return;
  }

  public void mouseWheelMoved(int change) {
    return;
  }

  public void mouseReleased(int button, int x, int y) {
  }

  public void inputEnded() {
    return;
  }

  public void inputStarted() {
    return;
  }

  public boolean isAcceptingInput() {
    return this.acceptsInput;
  }

  public void setInput(Input input) {
    return;
  }
}
