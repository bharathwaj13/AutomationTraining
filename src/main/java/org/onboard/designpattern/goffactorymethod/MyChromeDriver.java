package org.onboard.designpattern.goffactorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyChromeDriver implements MyWebDriver {
    @Override
    public WebDriver createDriver() {
        return new ChromeDriver();
    }
}
