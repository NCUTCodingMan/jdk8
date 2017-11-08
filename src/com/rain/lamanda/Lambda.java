package com.rain.lamanda;

import java.util.Arrays;
import java.util.List;

public class Lambda {
    
    public void print(Default obj) {
        obj.abstractMethod();
    }
    
    /**
     * 函数式接口
     * 1.仅仅包含一个抽象方法的接口
     * 2.1.8之后,接口中可以声明默认方法与静态方法(与1.7的区别)
     * 3.函数式接口可以使用函数表达式取代匿名内部类
     * @author Administrator
     */
    @FunctionalInterface
    private static interface Default {
        public default void defaultMethod(String s) {
            System.out.println("default method of interface");
        }
        @SuppressWarnings("unused")
        public static void staticMethod(String s) {
            System.out.println("static method of interface");
        }
        public abstract void abstractMethod();
    }
    
    /**
     * 接口的实现类可以改写接口中声明的默认方法
     * @author Administrator
     */
    private static class DefaultImpl implements Default {
        @Override
        public void defaultMethod(String s) {
            Default.super.defaultMethod(s);
            System.out.println("override default method of interface");
        }        
        @Override
        public void abstractMethod() {
            System.out.println("method implements by ..");
        }
    }
    
    public static void main(String[] args) {
        new Lambda().print(() -> {
            System.out.println("函数式接口,Lamanda表达式");
        });
        
        new Lambda().print(new DefaultImpl()::abstractMethod);
        
        new Thread(() -> {
            System.out.println("实现Runnable的run()");
        }).start();
        
        // Collection实现了Iterable
        List<String> strs = Arrays.asList("One", "Three", "Four");
        strs.forEach(n -> {System.out.println(n);});
    }
}