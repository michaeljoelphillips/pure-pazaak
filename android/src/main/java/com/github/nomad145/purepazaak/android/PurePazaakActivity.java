package com.github.nomad145.purepazaak.android;

import playn.android.GameActivity;

import com.github.nomad145.purepazaak.core.PurePazaak;

public class PurePazaakActivity extends GameActivity {

  @Override public void main () {
    new PurePazaak(platform());
  }
}
