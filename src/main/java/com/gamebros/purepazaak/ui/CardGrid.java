package com.github.nomad145.purepazaak.ui;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.github.nomad145.purepazaak.entity.CardInterface;
import com.github.nomad145.purepazaak.view.CardView;

public class CardGrid {
  private static int horizontalSpace = 10;

  private static int verticalSpace = 10;

  protected int x;

  protected int y;

  protected int width;

  protected int height;

  protected ArrayList<CardView> cards = new ArrayList<CardView>();

  public CardGrid(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public CardGrid(ArrayList<CardInterface> cards, int x, int y, int width, int height) throws SlickException {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

    for (CardInterface card : cards) {
      this.addCard(new CardView(card));
    }
  }

  public void addCard(CardView card) {
    if ((this.x + this.width) - this.getLastX() > CardView.WIDTH) {
      card.place(
          this.getLastX() + horizontalSpace,
          this.getLastY()
      );
    } else {
      card.place(
          this.x + horizontalSpace,
          this.getLastY() + CardView.HEIGHT + verticalSpace
      );
    }

    this.cards.add(card);
  }

  public void setCards(ArrayList<CardInterface> cards) throws SlickException {
    // Add new cards.
    // Remove missing cards.

    ArrayList<CardInterface> currentCards = this.cards
        .stream()
        .map(view -> view.getCard())
        .collect(Collectors.toCollection(ArrayList<CardInterface>::new));

    // Removed Cards
    ArrayList<CardInterface> removedCards = (ArrayList<CardInterface>)currentCards.clone();
    removedCards.removeAll(cards);

    // New Cards
    ArrayList<CardInterface> newCards = (ArrayList<CardInterface>)cards.clone();
    newCards.removeAll(currentCards);

    ArrayList<CardView> removedViews = this.cards
        .stream()
        .filter(cardView -> removedCards.contains(cardView.getCard()))
        .collect(Collectors.toCollection(ArrayList<CardView>::new));

    // System.out.println("Total Removed Cards: " + removedCards.size());
    // System.out.println("Total Removed Views: " + removedViews.size());

    this.cards.removeAll(removedViews);

    for (CardInterface card : newCards) {
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

    return this.x;
  }

  protected int getLastY() {
    if (this.cards.size() > 0) {
      CardView card = this.cards.get(this.cards.size() - 1);

      return card.getY();
    }

    return this.y;
  }

  public ArrayList<CardView> getCards() {
    return this.cards;
  }

  public void render(Graphics graphics) {
    for (CardView card : this.cards) {
      card.render(graphics);
    }
  }

  public Optional<CardInterface> getClickedCard(int x, int y) {
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
