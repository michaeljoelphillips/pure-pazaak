package com.github.nomad145.purepazaak.view;

import java.util.LinkedList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import com.github.nomad145.purepazaak.event.CardClickedEvent;
import com.github.nomad145.purepazaak.event.ContextualEventInterface;
import com.github.nomad145.purepazaak.listener.ActionListenerInterface;
import com.github.nomad145.purepazaak.view.ClickableViewInterface;

public abstract class AbstractView implements MouseListener, ClickableViewInterface {
  protected boolean acceptsInput = false;

  protected LinkedList<ActionListenerInterface> listeners = new LinkedList<ActionListenerInterface>();

  public void addListener(ActionListenerInterface listener) {
    this.listeners.add(listener);
  }

  protected void notifyListeners(ContextualEventInterface event) {
    this.listeners.stream().forEach(listener -> listener.handle(event));
  }

  public void mouseClicked(int button, int x, int y, int count) {
    return;
  }

  public void mouseDragged(int oldx, int oldy, int x, int y) {
    return;
  }

  public void mouseMoved(int oldx, int oldy, int x, int y) {
    return;
  }

  public void mousePressed(int button, int x, int y) {
    return;
  }

  public void mouseWheelMoved(int change) {
    return;
  }

  public void mouseReleased(int button, int x, int y) {
  }

  public void inputEnded() {
    return;
  }

  public void inputStarted() {
    return;
  }

  public boolean isAcceptingInput() {
    return this.acceptsInput;
  }

  public void setInput(Input input) {
    return;
  }
}
