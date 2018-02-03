package com.gamebros.purepazaak.view;

import com.gamebros.purepazaak.listener.ActionListenerInterface;
import com.gamebros.purepazaak.view.ViewInterface;

public interface ClickableViewInterface extends ViewInterface {
  public void addListener(ActionListenerInterface listener);
}
