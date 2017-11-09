package com.rain.functional;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Function 单目运算操作 
 * Predicate 检测某变量是否符合表达式 
 * BinaryOperator 双目运算符操作
 * @author Administrator
 */
public class FunctionalInterface {
    private static final int LOOP = 1024;

    public static void main(String[] args) {
        consumer();
        supplier();
    }

    /**
     * Predicate 单目运算符, 判断某元素是否满足表达式; 在判断对象是否为null时比较方便
     */
    public static void predicate() {
        // 采用匿名内部类的方式实现接口以及接口中的方法
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t == null;
            }
        };
        Arrays.asList(predicate).forEach(x -> System.out.println(x.test(1)));

        predicate = (x) -> {
            return x.equals(-x);
        };
        System.out.println(predicate.test(0));
    }

    /**
     * Function 函数接口, 单目运算, 处理元素
     */
    public static void function() {
        Function<Integer, Object> function = (x) -> {
            return Math.pow(Double.valueOf(x), x);
        };
        Arrays.asList(function.apply(1), function.apply(2), function.apply(3), function.apply(4))
                .forEach(System.out::println);
    }

    /**
     * 双目运算符 函数接口, 双目运算, 处理元素
     */
    public static void binaryOperation() {
        BinaryOperator<Integer> binaryOperator = (x, y) -> {
            return x * y;
        };
        Arrays.asList(binaryOperator.apply(1, 2), binaryOperator.apply(100, 200), binaryOperator.apply(51, 12))
                .forEach(System.out::println);
    }

    /**
     * 单目运算符 如逻辑非
     */
    public static void unaryOperation() {
        UnaryOperator<Integer> unaryOperator = (x) -> {
            return ~x;
        };
        Arrays.asList(unaryOperator.apply(1), unaryOperator.apply(2), unaryOperator.apply(3), unaryOperator.apply(4))
                .forEach(System.out::println);
    }

    /**
     * Consumer 对形参x进行各种各样的处理, 通过引用相关信息处理; 会影响原来的值
     */
    public static void consumer() {
        Consumer<Integer> consumer = (x) -> {
            // 可以对x进行相关处理, 最后可以进行输出
            for (int i = 0; i < LOOP; i++) {
                x += i;
            }
            System.out.println(x);
        };
        consumer.accept(1);
    }
    
    /**
     * 获取一个对象
     *  这块似乎可以与工厂方式结合, 暂时没有特别好的;例子
     */
    public static void supplier() {
        Supplier<Student> supplier = Student::getInstance;
        Arrays.asList(supplier.get(), supplier.get(), supplier.get(), supplier.get());
        Consumer<Boolean> consumer = System.out::println;
        consumer.accept(
                Arrays.deepEquals(Arrays.asList(supplier.get()).toArray(), Arrays.asList(supplier.get()).toArray()));
    }

    private static class Student {
        private static volatile Student student;

        private Student() {
        }

        public static Student getInstance() {
            if (student == null) {
                synchronized (Student.class) {
                    if (student == null) {
                        student = new Student();
                    }
                }
            }
            return student;
        }
    }
}