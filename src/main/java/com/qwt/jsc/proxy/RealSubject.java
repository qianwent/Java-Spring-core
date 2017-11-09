package com.qwt.jsc.proxy;

/**
 * Created by Wentao Qian on 11/9/2017.
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
