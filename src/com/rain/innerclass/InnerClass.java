package com.rain.innerclass;

/**
 * 1.基本语法
 * 2.关键字.new以及.this
 * 3.可见性问题
 * 4.内部类解决了什么问题
 *  使得多继承变得完整
 *  回调的安全性
 * 与闭包的关系
 * @author Administrator
 */
public class InnerClass {
    
    class Inner {
        public InnerClass f() {
            return InnerClass.this;
        }
    }
    
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        Inner inner = innerClass.new Inner();
        System.out.println(innerClass == inner.f());
    }
}