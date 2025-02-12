package org.onboard.designpattern.decorator;

public class Main {

    public static void main(String[] args) {


        WebPage mobilePage = new MobileWebPage();
        System.out.println(mobilePage.getDescription() + " - Rank: " + mobilePage.getRank());

        mobilePage = new WeatherWidget(mobilePage);
        mobilePage = new ChatWidget(mobilePage);
        System.out.println(mobilePage.getDescription() + " - Rank: " + mobilePage.getRank());
    }
}
