package com.gamebros.purepazaak.view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.geom.Rectangle;

import com.gamebros.purepazaak.event.ButtonClickedEvent;
import com.gamebros.purepazaak.view.AbstractView;

public class ButtonView extends AbstractView {
  protected static int WIDTH = 100;

  protected static int HEIGHT = 30;

  protected String label;

  protected int x;

  protected int y;

  protected Rectangle button;

  public ButtonView(String label, int x, int y) {
    this.label = label;
    this.x = x;
    this.y = y;

    this.button = new Rectangle(x, y, WIDTH, HEIGHT);
    this.acceptsInput = true;
  }

  public void render(Graphics graphics) {
    graphics.fill(this.button);

    Color oldColor = graphics.getColor();
    graphics.setColor(new Color(30, 144, 255));

    graphics.drawString(this.label, x + 10, y + 5);

    graphics.setColor(oldColor);
  }

  protected boolean isClicked(int x, int y) {
    return this.button.contains((float) x, (float) y);
  }

  public void mouseReleased(int button, int x, int y) {
    if (this.isClicked(x, y)) {
      this.notifyListeners(new ButtonClickedEvent());
    }
  }
}
