package com.blog;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainUtil {
//    public static void main(String[] args) {
//        Predicate<String> condition = y->y.equals("mike");
//        boolean val = condition.test("mike");
//        System.out.println(val);
//
//    }

    public static void main(String[] args) {
        List<Integer> data= Arrays.asList(12,20,25,100,9,30,23);
        List<Integer> newData = data.stream().filter(x -> x > 20).collect(Collectors.toList());
        System.out.println(newData);
    }
}
