package org.onboard.designpattern.goffactorymethod;

/**
 *
 * SubTask-2
 * Now make it Fit to the GOF Factory Method pattern. As per the Gof Factory Method Pattern, the subclasses should decide which class to instantiate.
 *
 * So have another set of implementations for chrome, firefox, IE browsers.
 * This customization is different from previous by having some custom caabilities set in these classes.
 *
 * For example:  Have another class from chrome driver and this time call it "MyChromeDriverWithCapabilities".  Similar for other browsers
 *
 *
 * Declare factory classes, one which return normal chormdriver(MyChromeDriver) and other which return driver with pre-set capabilities("MyChromeDriverWithCapabilities")
 */

import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        BrowserFactory browserFactory=new ChromeFactory();
        MyWebDriver driverFactory = browserFactory.getFactory(true);
        WebDriver driver = driverFactory.createDriver();
    }
}
