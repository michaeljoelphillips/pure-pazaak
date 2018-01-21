package com.gamebros.purepazaak.event;

import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.event.EventInterface;

public class CardClickedEvent implements EventInterface {
  protected Card clickedCard;

  public CardClickedEvent(Card clickedCard) {
    this.clickedCard = clickedCard;
  }

  public String getEventName() {
    return "card.clicked";
  }

  public Card getCard() {
    return this.clickedCard;
  }
}
