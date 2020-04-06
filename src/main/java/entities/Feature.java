package entities;

import utils.ColumnName;

public class Feature {

    @ColumnName("feature_color")
    public String color;

    public Feature() {
    }

    public Feature(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
