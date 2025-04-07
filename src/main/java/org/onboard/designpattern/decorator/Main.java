package org.onboard.designpattern.decorator;

/**
 *
 * I am building a webpage for my business.
 *
 * The page can have different formats like a mobile version and a desktop version etc. Each format has a ranking associated with it.
 *
 * You can add many a widgets to the page. Each widgets adds certain functionality to the page. The widgets are independent of each other and has a rank associated with each widget. When a widget is added to the page, the rank of the page is incremented by the rank of widget.
 *
 * Write code to represent this model and calculate the rank of any given page.
 */

public class Main {

    public static void main(String[] args) {


        WebPage mobilePage = new MobileWebPage();
        System.out.println(mobilePage.getDescription() + " - Rank: " + mobilePage.getRank());

        mobilePage = new WeatherWidget(mobilePage);
        mobilePage = new ChatWidget(mobilePage);
        System.out.println(mobilePage.getDescription() + " - Rank: " + mobilePage.getRank());
    }
}
