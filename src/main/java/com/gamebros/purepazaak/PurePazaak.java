package com.gamebros.purepazaak;

import com.gamebros.purepazaak.view.InventoryView;
import com.gamebros.purepazaak.entity.Inventory;
import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.ui.component.CardComponent;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.Image;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class PurePazaak implements Game {
  protected CardComponent testCard;

  protected CardComponent testCard2;

  protected Inventory inventory;

  protected InventoryView view;

  protected int time;

  public String getTitle() {
    return "Pure Pazaak";
  }

  public boolean closeRequested() {
    return false;
  }

  public void render(GameContainer container, Graphics graphics) throws SlickException {
    graphics.drawString("Pure Pazaak", 50, 50);

    view.render();
  }

  public void update(GameContainer container, int delta) {
    if (this.time >= 10) {
      for (Card card : inventory.getCards()) {
        card.x = card.x + 1;
        card.y = card.y + 1;
      }

      this.time = 0;
    }

    this.time = this.time + delta;
  }

  public void init(GameContainer container) throws SlickException {
    inventory = new Inventory();

    inventory.addCard(new Card(4, 20, 25));
    inventory.addCard(new Card(4, 220, 25));

    view = new InventoryView(container.getGraphics(), inventory);

    return;
  }
}
