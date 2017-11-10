package com.rain.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import util.Artist;

/**
 * 关于stream包提供的几个基础方法
 *  filter
 *  map
 *  max
 *  min
 *  get
 *  reduce
 *  collect
 * @author Administrator
 */
public class StreamAPI {
    
    public static void main(String[] args) {
        reduce();
        max();
        min();
    }
    
    /**
     * 迭代方式
     *  内迭代
     *  外迭代
     */
    public static void iterator() {
        List<Artist> artists = Arrays.asList(new Artist("S635", "Korea", Arrays.asList("rain", "bang", "black")),
                new Artist("SKT", "Korea", Arrays.asList("faker", "bang")));

        // 外部迭代, 通过迭代器获取集合中的每一个元素, 然后再执行相关操作;
        Iterator<Artist> iterator = artists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.getName().indexOf('S') != -1) {
                System.out.println(artist.getName() + "\t" + artist.getOrigin() + "\t" + artist.getMembers());
            }

        }

        // 内部迭代, 直接过滤集合中的元素
        artists.stream()
            .filter(x -> x.getName().indexOf('S') != -1)
            .forEach(artist -> System.out.println(artist.getName() + "\t" + artist.getOrigin() + "\t" + artist.getMembers()));;
    }
    
    // 生成集合元素
    public static void collect() {
        List<String> strs = Stream.of("1", "2", "3").collect(Collectors.toList());
        strs.forEach(System.out::println);
    }
    
    public static void map() {
        List<String> strs = Stream.of("1", "2", "3").collect(Collectors.toList());
        strs.stream().map(x -> x.toUpperCase());
        strs.forEach(System.out::println);
    }
    
    public static void reduce() {
        List<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
        int result = ints.stream().filter(x -> x > 2)
            .reduce(0, (x, y) -> x + y);
        System.out.println(result);
    }
    
    public static void max() {
        List<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
        System.out.println(ints.stream().max((x, y) -> {return x.compareTo(y);}).get());        
    }
    
    public static void min() {
        List<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
        System.out.println(ints.stream().min((x, y) -> {return x.compareTo(y);}).get());
        System.out.println(ints.stream().min(Comparator.naturalOrder()).get());
    }
}