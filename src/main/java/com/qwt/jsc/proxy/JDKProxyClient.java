package com.qwt.jsc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Wentao Qian on 11/9/2017.
 */
public class JDKProxyClient {
    public static void main(String args[]) {
        //    我们要代理的真实对象
        Subject realSubject = new RealSubject();

        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        //在Proxy.java里debug newProxyInstance这个方法，可以发现，
        //最终return cons.newInstance(new Object[]{h});
        //再进到newInstance，发现public T newInstance(Object ... initargs)
        //最终返回T类型(泛型)，那这个T就对应了上面的cons类型，final Constructor<?> cons = cl.getConstructor(constructorParams);
        //再从这行往上看，Class<?> cl = getProxyClass0(loader, intfs);
        //再看getProxyClass0，return proxyClassCache.get(loader, interfaces)，注意这里的interfaces
        //再往下走，public V get(K key, P parameter)
        //发现这个方法用到了key和parameter，Object subKey = Objects.requireNonNull(subKeyFactory.apply(key, parameter));
        //再看这个subKeyFactory.apply(key, parameter)方法，往下的逻辑基本上是根据parameter数组来决定返回值的
        //而这个parameter又是interface数组，即从一开始newProxyInstance的时候传进去的realSubject.getClass().getInterfaces()
        //debug过程比较长，但是但是结论基本上是穿进去的interface是什么类型，那么我们就可以cast成什么类型，所以在我们这个
        //例子中，最后Proxy.newProxyInstance需要cast成Subject
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);

        System.out.println(subject.getClass().getName());
        subject.rent();//当这个方法被调用的时候，并不是直接调用被代理对象，
        // 而是通过触发handler(DynamicProxy implements InvocationHandler）的invoke方法
        //这正式proxy的定义，a proxy is a wrapper or agent object that is being called by the client
        // to access the real serving object behind the scenes---wiki
        subject.hello("world");
    }
}
