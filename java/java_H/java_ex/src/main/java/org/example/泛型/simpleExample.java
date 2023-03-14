package org.example.泛型;

/**
 * @author :wjj
 * @date : 2023/3/12
 * @Description :
 */
public class simpleExample {

    public static void main(String[] args) {
        point<String> var = new point<String>();
        var.setVar("hello 泛型");
        System.out.println("value:"+var.getVar()+"\t\t"+"length:"+var.getVar().length());
    }

}

class point<T>{
    private T var;
//    get方法
    public T getVar(){
        return var;
    }
    public void setVar(T var){
        this.var = var;
    }
}
