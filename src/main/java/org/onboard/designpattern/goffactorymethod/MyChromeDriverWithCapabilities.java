package org.onboard.designpattern.goffactorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyChromeDriverWithCapabilities implements MyWebDriver {
    @Override
    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }
}
