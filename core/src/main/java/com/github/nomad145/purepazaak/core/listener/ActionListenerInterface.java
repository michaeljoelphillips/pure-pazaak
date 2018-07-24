package com.github.nomad145.purepazaak.core.listener;

import com.github.nomad145.purepazaak.core.event.ContextualEventInterface;

// @TODO: A subscriber based relationship might work really well here.
public interface ActionListenerInterface {
  // @TODO: This is a very rigid contract.
  public void handle(ContextualEventInterface event);
}
