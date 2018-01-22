package com.gamebros.purepazaak.event;

import java.util.Optional;

import com.gamebros.purepazaak.event.EventInterface;

public class ButtonClickedEvent implements ContextualEventInterface {
  public String getEventName() {
    return "button.clicked";
  }

  public Optional<Object> get() {
    return Optional.empty();
  }
}
