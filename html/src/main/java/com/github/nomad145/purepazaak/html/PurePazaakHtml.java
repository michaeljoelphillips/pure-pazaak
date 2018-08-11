package com.github.nomad145.purepazaak.html;

import com.google.gwt.core.client.EntryPoint;
import playn.html.HtmlPlatform;
import com.github.nomad145.purepazaak.core.PurePazaak;

public class PurePazaakHtml implements EntryPoint {

  @Override public void onModuleLoad () {
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    // use config to customize the HTML platform, if needed
    HtmlPlatform plat = new HtmlPlatform(config);
    plat.assets().setPathPrefix("pure-pazaak/");
    new PurePazaak(plat);
    plat.start();
  }
}
