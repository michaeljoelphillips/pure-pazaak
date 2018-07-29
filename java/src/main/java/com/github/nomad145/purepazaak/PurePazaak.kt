package com.github.nomad145.purepazaak;

import com.github.nomad145.purepazaak.core.PurePazaak;
import playn.java.JavaPlatform;
import playn.java.LWJGLPlatform;

fun main(args: Array<String>) {
  val config = JavaPlatform.Config()
  val platform = LWJGLPlatform(config)

  PurePazaak(platform, 60)

  platform.start()
}
