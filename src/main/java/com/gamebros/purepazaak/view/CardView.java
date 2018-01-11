package com.gamebros.purepazaak.view;

import com.gamebros.purepazaak.entity.Card;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class CardView {
  public static int WIDTH = 80;

  public static int HEIGHT = 100;

  protected Card card;

  protected Image image;

  protected Rectangle rectangle;

  protected float x;

  protected float y;

  protected boolean placed;

  public CardView(Card card) throws SlickException {
    this.card = card;

    this.image = new Image("textures/card.png");
    this.rectangle = new Rectangle(0, 0, WIDTH, HEIGHT);
  }

  public void place(float x, float y) {
    this.placed = true;

    this.rectangle.setX(x);
    this.rectangle.setY(y);
  }

  public void render(Graphics graphics) {
    if (this.placed) {
      graphics.texture(this.rectangle, this.image, true);
    }
  }

  public int getX() {
    return (int) this.rectangle.getX();
  }

  public int getY() {
    return (int) this.rectangle.getY();
  }

  public Card getCard() {
    return this.card;
  }

  public boolean wasClicked(int x, int y) {
    return this.rectangle.contains((float) x, (float) y);
  }
}
