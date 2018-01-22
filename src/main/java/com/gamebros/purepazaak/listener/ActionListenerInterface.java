package com.gamebros.purepazaak.listener;

import com.gamebros.purepazaak.event.ContextualEventInterface;

// @TODO: A subscriber based relationship might work really well here.
public interface ActionListenerInterface {
  // @TODO: This is a very rigid contract.
  public void handle(ContextualEventInterface event);
}
