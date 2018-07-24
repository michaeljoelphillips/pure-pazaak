package com.github.nomad145.purepazaak.core.event;

import java.util.Optional;

import com.github.nomad145.purepazaak.core.event.EventInterface;

public interface ContextualEventInterface extends EventInterface {
  public Optional<Object> get();
}
