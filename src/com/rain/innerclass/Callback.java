package com.rain.innerclass;

import java.util.stream.IntStream;

public class Callback {
    
    public static void main(String[] args) {
        new Student().add(1, 2, 3, 4, 5, 6, 7, 8, 9);
        new Graph().add(1123, 4342, 543543, 543523, 32546);
    }
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    private static class Caculator {
        public void add(Job job, int...params) {
            IntStream stream = IntStream.of(params);            
            int result = stream.reduce(0, Callback::add);
            job.fillBack(result);
        }
    }
    
    public static class Student {
        private String name;
        public void fillBack(int result) {
            System.out.println("当前的计算结果是:" + result);
        }
        public void add(int...is) {
            new Caculator().add((result) -> {
                Student.this.fillBack(result);
            }, is);
        }
        @Override
        public String toString() {
            return "同学的名字叫:" + this.name;
        }
    }
    
    public static class Graph {
        private String name;
        public void fillBack(int result) {
            System.out.println("奶奶今天的盈利是:" + result);
        }
        public void add(int...is) {
            new Caculator().add((result) -> {
                Graph.this.fillBack(result);
            }, is);
        }
        @Override
        public String toString() {
            return "奶奶的名字是:" + this.name;
        }
    }
    
    private static interface Job {
        public void fillBack(int result);
    }
}