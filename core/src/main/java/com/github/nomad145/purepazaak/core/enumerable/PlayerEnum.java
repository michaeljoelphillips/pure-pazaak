package com.github.nomad145.purepazaak.core.enumerable;

public enum PlayerEnum {
  PLAYERONE {
    public PlayerEnum next() {
      return PLAYERTWO;
    }
  },
  PLAYERTWO {
    public PlayerEnum next() {
      return PLAYERONE;
    }
  };

  public abstract PlayerEnum next();
}
