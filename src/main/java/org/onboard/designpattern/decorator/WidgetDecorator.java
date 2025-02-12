package org.onboard.designpattern.decorator;

public abstract class WidgetDecorator implements WebPage {

    WebPage page;

    public WidgetDecorator(WebPage page) {
        this.page = page;
    }

    @Override
    public int getRank() {
        return page.getRank();
    }

    @Override
    public String getDescription() {
        return page.getDescription();
    }
}
