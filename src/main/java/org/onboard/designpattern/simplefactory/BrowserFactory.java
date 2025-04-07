package org.onboard.designpattern.simplefactory;

/**
 * Factory pattern Task:
 *
 * SubTask-1
 *
 * Using factory pattern, write code to initialise it to your custom chrome, firefox or IE browser implementations.
 *
 * Note: do not just say new ChromeDriver.  Have a class something like myChromeDriver and
 *
 * just do initialize the actual chrome driver in this calss.
 *
 * similary for other browser classes .
 *
 */

public class BrowserFactory {

    public static MyWebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            return new MyChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            return new MyFireFoxDriver();
        } else throw new IllegalArgumentException("Please enter the correct browser");
    }
}
