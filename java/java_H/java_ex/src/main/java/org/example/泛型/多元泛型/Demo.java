package org.example.泛型.多元泛型;

/**
 * @author :wjj
 * @date : 2023/3/12
 * @Description :
 */
public class Demo {

    public static void main(String[] args) {
        XY<String, Integer> xy = new XY<>();
        String name = "小新";
        int age = 5;
        xy.setT1(name);
        xy.setT2(age);
        System.out.println("name"+xy.getT1()+"\t"+"age"+xy.getT2());
    }

}

class XY<T1,T2>{
    private T1 t1;
    private T2 t2;

    public T1 getT1() {
        return t1;
    }

    public void setT1(T1 t1) {
        this.t1 = t1;
    }

    public T2 getT2() {
        return t2;
    }

    public void setT2(T2 t2) {
        this.t2 = t2;
    }
}
