package com.gamebros.purepazaak.listener;

import com.gamebros.purepazaak.event.CardClickedEvent;
import com.gamebros.purepazaak.event.EventInterface;

// @TODO: A subscriber based relationship might work really well here.
// @FIXME: I think this might need to use generics.
public interface ActionListenerInterface {
  public void handle(CardClickedEvent event);
}
