package com.github.nomad145.purepazaak;

import com.github.nomad145.purepazaak.core.PurePazaak;
import playn.java.JavaPlatform;
import playn.java.LWJGLPlatform;

fun main(args: Array<String>) {
  val platform = LWJGLPlatform(buildConfig())

  PurePazaak(platform, 60)

  platform.start()
}

fun buildConfig(): JavaPlatform.Config {
  var config = JavaPlatform.Config()

  config.width = 1920
  config.height = 1080

  return config
}
