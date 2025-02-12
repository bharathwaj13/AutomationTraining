package org.onboard.designpattern.decorator;

public class WeatherWidget extends WidgetDecorator{

    private int widgetRank=5;

    public WeatherWidget(WebPage page) {
        super(page);
    }

    @Override
    public int getRank() {
        return super.getRank() + widgetRank;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Weather Widget";
    }
}
