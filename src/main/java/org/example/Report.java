package org.example;

public class Report {
    private Widget widget;

    public String draw() {
        if (this.widget == null) {
            throw new NullPointerException("Report without widgets");
        }
        return widget.draw();
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }
}
