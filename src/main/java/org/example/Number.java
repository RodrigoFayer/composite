package org.example;

public class Number extends Widget{
    private float value;

    public Number(String name, float value) {
        super(name);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String draw() {
        return "Name: " + this.getName() + ",\nValue: " + this.getValue();
    }
}
