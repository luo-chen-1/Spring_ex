package org.wjj.ioc.ex1;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class CatDaoImpl implements Cat{

    private String name;
    private String age;

    public CatDaoImpl(){

    }

    public CatDaoImpl(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
