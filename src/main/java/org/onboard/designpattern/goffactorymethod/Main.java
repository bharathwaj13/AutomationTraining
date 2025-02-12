package org.onboard.designpattern.goffactorymethod;

import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        BrowserFactory browserFactory=new ChromeFactory();
        MyWebDriver driverFactory = browserFactory.getFactory(true);
        WebDriver driver = driverFactory.createDriver();
    }
}
