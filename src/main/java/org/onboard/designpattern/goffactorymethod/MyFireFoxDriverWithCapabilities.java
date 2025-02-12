package org.onboard.designpattern.goffactorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MyFireFoxDriverWithCapabilities implements MyWebDriver {
    @Override
    public WebDriver createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        return new FirefoxDriver(options);
    }
}
