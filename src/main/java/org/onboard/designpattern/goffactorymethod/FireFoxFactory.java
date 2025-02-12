package org.onboard.designpattern.goffactorymethod;

public class FireFoxFactory extends BrowserFactory {
    @Override
    public MyWebDriver getFactory(boolean capabilities) {
        if (capabilities) return new MyFireFoxDriverWithCapabilities();
        return new MyFireFoxDriver();
    }
}
