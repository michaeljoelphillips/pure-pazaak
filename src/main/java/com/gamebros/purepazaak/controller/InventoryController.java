package com.gamebros.purepazaak.controller;

import com.gamebros.purepazaak.entity.Inventory;
import com.gamebros.purepazaak.view.InventoryView;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.Input;

public class InventoryController implements MouseListener {
  protected Inventory inventory;

  protected InventoryView view;

  public InventoryController(Inventory inventory) throws SlickException {
    this.inventory = inventory;
    this.view = new InventoryView(inventory);
  }

  public void render(Graphics graphics) {
    this.view.render(graphics);
  }

  public void mouseClicked(int button, int x, int y, int count) {
    System.out.println("Clicked");

    // Resolve the card.
    // Move it from the inventory to the side deck.
    // Update the view.
  }

  public void mouseDragged(int oldx, int oldy, int x, int y) {
  }

  public void mouseMoved(int oldx, int oldy, int x, int y) {
  }

  public void mousePressed(int button, int x, int y) {
  }

  public void mouseWheelMoved(int change) {
  }

  public void mouseReleased(int button, int x, int y) {
  }

  public void inputEnded() {
  }

  public void inputStarted() {
  }

  public boolean isAcceptingInput() {
    return true;
  }

  public void setInput(Input input) {
  }
}
