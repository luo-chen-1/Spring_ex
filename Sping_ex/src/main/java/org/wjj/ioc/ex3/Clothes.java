package org.wjj.ioc.ex3;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class Clothes {

    private String style;
    private String color;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Clothes(){

    }

    public Clothes(String style, String color) {
        this.style = style;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "style='" + style + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
