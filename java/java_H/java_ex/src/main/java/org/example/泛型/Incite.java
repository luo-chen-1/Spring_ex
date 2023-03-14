package org.example.泛型;

/**
 * @author :wjj
 * @date : 2023/3/12
 * @Description :
 */
public class Incite {

    //泛型没有引入之前
//    private static int add(int a, int b) {
//        System.out.println(a + "+" + b + "=" + (a + b));
//        return a + b;
//    }
//
//    private static float add(float a, float b) {
//        System.out.println(a + "+" + b + "=" + (a + b));
//        return a + b;
//    }
//
//    private static double add(double a, double b) {
//        System.out.println(a + "+" + b + "=" + (a + b));
//        return a + b;
//    }

    //泛型引入之后
    private static <T extends Number>double add(T a,T b){
        System.out.println("a"+"+"+"b"+"="+(a.doubleValue()+b.doubleValue()));
        return a.doubleValue()+b.doubleValue();
    }

    public static void main(String[] args) {
        Incite incite = new Incite();
       add(10,20);
       add(10.0,20.0);
    }
}
