package org.wjj.ioc.ex4;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class Pen {
//    笔的名称
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pen" +
                "style='" + name + '\''
                ;
    }
}
