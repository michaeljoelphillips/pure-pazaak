package com.github.nomad145.purepazaak.core;

import playn.core.Image;
import playn.core.Platform;
import playn.scene.ImageLayer;
import playn.scene.SceneGame;

class PurePazaak(var platform: Platform, var frameRate: Int) : SceneGame(platform, frameRate) {
  init {
    setBackground()
  }

  private fun setBackground() {
    val backgroundImage = platform.assets().getImage("images/background.png")
    val backgroundLayer = ImageLayer(backgroundImage)

    backgroundLayer.setSize(platform.graphics().viewSize)

    rootLayer.add(backgroundLayer)
  }
}
