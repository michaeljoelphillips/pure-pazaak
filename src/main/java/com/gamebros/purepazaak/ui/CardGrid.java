package com.gamebros.purepazaak.ui;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.valueobject.Area;
import com.gamebros.purepazaak.view.CardView;

public class CardGrid {
  private static int horizontalSpace = 10;

  private static int verticalSpace = 10;

  protected Area area;

  protected ArrayList<CardView> cards = new ArrayList<CardView>();

  public CardGrid(Area area) {
    this.area = area;
  }

  public CardGrid(ArrayList<Card> cards, Area area) throws SlickException {
    this.area = area;

    for (Card card : cards) {
      this.addCard(new CardView(card));
    }
  }

  public void addCard(CardView card) {
    if ((this.area.x + this.area.width) - this.getLastX() > CardView.WIDTH) {
      card.place(
          this.getLastX() + horizontalSpace,
          this.getLastY()
      );
    } else {
      card.place(
          this.area.x + horizontalSpace,
          this.getLastY() + CardView.HEIGHT + verticalSpace
      );
    }

    this.cards.add(card);
  }

  public void setCards(ArrayList<Card> cards) throws SlickException {
    // Add new cards.
    // Remove missing cards.

    ArrayList<Card> currentCards = this.cards
        .stream()
        .map(view -> view.getCard())
        .collect(Collectors.toCollection(ArrayList<Card>::new));

    // Removed Cards
    ArrayList<Card> removedCards = (ArrayList<Card>)currentCards.clone();
    removedCards.removeAll(cards);

    // New Cards
    ArrayList<Card> newCards = (ArrayList<Card>)cards.clone();
    newCards.removeAll(currentCards);

    ArrayList<CardView> removedViews = this.cards
        .stream()
        .filter(cardView -> removedCards.contains(cardView.getCard()))
        .collect(Collectors.toCollection(ArrayList<CardView>::new));

    // System.out.println("Total Removed Cards: " + removedCards.size());
    // System.out.println("Total Removed Views: " + removedViews.size());

    this.cards.removeAll(removedViews);

    for (Card card : newCards) {
      if (!currentCards.contains(card)) {
        this.addCard(new CardView(card));
      }
    }
  }

  protected int getLastX() {
    if (this.cards.size() > 0) {
      CardView card = this.cards.get(this.cards.size() - 1);

      return card.getX() + CardView.WIDTH;
    }

    return this.area.x;
  }

  protected int getLastY() {
    if (this.cards.size() > 0) {
      CardView card = this.cards.get(this.cards.size() - 1);

      return card.getY();
    }

    return this.area.y;
  }

  public ArrayList<CardView> getCards() {
    return this.cards;
  }

  public void render(Graphics graphics) {
    for (CardView card : this.cards) {
      card.render(graphics);
    }
  }

  public Optional<Card> getClickedCard(int x, int y) {
    Optional<CardView> clickedView = this.cards
        .stream()
        .filter(view -> view.wasClicked(x, y))
        .findFirst();

    if (clickedView.isPresent()) {
      return Optional.of(clickedView.get().getCard());
    }

    return Optional.empty();
  }
}
