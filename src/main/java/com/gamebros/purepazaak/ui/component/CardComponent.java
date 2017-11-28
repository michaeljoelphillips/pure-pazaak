package com.gamebros.purepazaak.ui.component;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public class CardComponent extends AbstractComponent {
  protected int xPosition;

  protected int yPosition;

  protected Rectangle card;

  protected Image texture;

  public CardComponent(GUIContext container, Image texture) {
    super(container);

    this.card = new Rectangle(xPosition, yPosition, 100, 140);
    this.texture = texture;
  }

  public int getHeight() {
    return (int) card.getHeight();
  }

  public int getWidth() {
    return (int) card.getWidth();
  }

  public int getX() {
    return (int) card.getX();
  }

  public int getY() {
    return (int) card.getY();
  }

  public void setLocation(int x, int y) {
    this.xPosition = x;
    this.yPosition = y;
  }

  public void render(GUIContext container, Graphics graphics) {
    // Update the card's location since we can't
    // override the AbstractComponent constructor.
    card.setLocation(xPosition, yPosition);

    graphics.texture(card, texture, true);
  }
}
