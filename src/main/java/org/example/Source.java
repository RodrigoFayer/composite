package org.example;

import java.util.ArrayList;
import java.util.List;

public class Source extends Widget{
    private List<Widget> widgets;

    public Source(String name) {
        super(name);
        this.widgets = new ArrayList<Widget>();
    }

    public void addWidget(Widget widget) {
        this.widgets.add(widget);
    }

    @Override
    public String draw() {
        String result = "------" + this.getName() + "------\n";
        for (Widget widget : this.widgets) {
            result += widget.draw();
            result += "\n";
        }
        result += "----" + "End " + this.getName() + "----";
        return result;
    }
}
