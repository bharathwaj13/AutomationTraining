package org.onboard.designpattern.decorator;

public class ChatWidget extends WidgetDecorator{

    private int widgetRank=6;

    public ChatWidget(WebPage page) {
        super(page);
    }

    @Override
    public int getRank() {
        return super.getRank() + widgetRank;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Chat Widget";
    }
}
