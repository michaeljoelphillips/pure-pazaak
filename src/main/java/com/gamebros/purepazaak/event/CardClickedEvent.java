package com.github.nomad145.purepazaak.event;

import java.util.Optional;

import com.github.nomad145.purepazaak.entity.CardInterface;
import com.github.nomad145.purepazaak.event.ContextualEventInterface;

public class CardClickedEvent implements ContextualEventInterface {
  protected CardInterface clickedCard;

  public CardClickedEvent(CardInterface clickedCard) {
    this.clickedCard = clickedCard;
  }

  public String getEventName() {
    return "card.clicked";
  }

  public Optional<Object> get() {
    return Optional.of(this.clickedCard);
  }
}
