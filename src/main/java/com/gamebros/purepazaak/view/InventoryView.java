package com.gamebros.purepazaak.view;

import com.gamebros.purepazaak.entity.Inventory;
import com.gamebros.purepazaak.entity.Card;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.Image;
import java.util.Iterator;
import org.newdawn.slick.SlickException;

public class InventoryView {
  protected static Image image;

  protected Graphics graphics;

  protected Inventory inventory;

  public InventoryView(
      Graphics graphics,
      Inventory inventory
  ) throws SlickException {
    this.graphics = graphics;
    this.inventory = inventory;

    this.image = new Image("textures/card.png");
  }

  public void render() {
    for (Card card : inventory.getCards()) {
      Rectangle rectangle = new Rectangle(card.x, card.y, 100, 140);

      this.graphics.texture(rectangle, this.image, true);
    }
  }
}
