package org.onboard.designpattern.goffactorymethod;

public class ChromeFactory extends BrowserFactory {
    @Override
    public MyWebDriver getFactory(boolean capabilities) {
        if (capabilities) return new MyChromeDriverWithCapabilities();
        return new MyChromeDriver();
    }
}
