package org.onboard.designpattern.simplefactory;

public class BrowserFactory {

    public static MyWebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            return new MyChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            return new MyFireFoxDriver();
        } else throw new IllegalArgumentException("Please enter the correct browser");
    }
}
