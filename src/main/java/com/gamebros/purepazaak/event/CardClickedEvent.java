package com.gamebros.purepazaak.event;

import java.util.Optional;

import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.event.ContextualEventInterface;

public class CardClickedEvent implements ContextualEventInterface {
  protected Card clickedCard;

  public CardClickedEvent(Card clickedCard) {
    this.clickedCard = clickedCard;
  }

  public String getEventName() {
    return "card.clicked";
  }

  public Optional<Object> get() {
    return Optional.of(this.clickedCard);
  }
}
