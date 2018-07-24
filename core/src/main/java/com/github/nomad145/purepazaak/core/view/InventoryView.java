package com.github.nomad145.purepazaak.view;

import com.github.nomad145.purepazaak.entity.Inventory;
import com.github.nomad145.purepazaak.ui.CardGrid;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class InventoryView {
  protected Inventory inventory;

  protected CardGrid grid;

  public InventoryView(Inventory inventory) throws SlickException {
    this.inventory = inventory;
    this.grid = new CardGrid(inventory.getCards(), 0, 0, 800, 600);
  }

  public void render(Graphics graphics) {
    this.grid.render(graphics);
  }
}
