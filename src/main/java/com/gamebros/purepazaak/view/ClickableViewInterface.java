package com.github.nomad145.purepazaak.view;

import com.github.nomad145.purepazaak.listener.ActionListenerInterface;
import com.github.nomad145.purepazaak.view.ViewInterface;

public interface ClickableViewInterface extends ViewInterface {
  public void addListener(ActionListenerInterface listener);
}
