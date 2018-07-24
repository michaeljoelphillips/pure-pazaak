package com.github.nomad145.purepazaak.java;

import playn.java.LWJGLPlatform;

import com.github.nomad145.purepazaak.core.PurePazaak;

public class PurePazaakJava {

  public static void main (String[] args) {
    LWJGLPlatform.Config config = new LWJGLPlatform.Config();
    // use config to customize the Java platform, if needed
    LWJGLPlatform plat = new LWJGLPlatform(config);
    new PurePazaak(plat);
    plat.start();
  }
}
