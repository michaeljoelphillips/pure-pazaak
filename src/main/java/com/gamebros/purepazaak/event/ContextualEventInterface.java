package com.gamebros.purepazaak.event;

import java.util.Optional;

import com.gamebros.purepazaak.event.EventInterface;

public interface ContextualEventInterface extends EventInterface {
  public Optional<Object> get();
}
