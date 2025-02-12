package org.onboard.designpattern.simplefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFireFoxDriver implements MyWebDriver{
    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}
