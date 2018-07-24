package com.github.nomad145.purepazaak.core.event;

import java.util.Optional;

import com.github.nomad145.purepazaak.core.entity.CardInterface;
import com.github.nomad145.purepazaak.core.event.ContextualEventInterface;

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
