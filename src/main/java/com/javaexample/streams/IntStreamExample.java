package com.javaexample.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamExample {

    public static void main(String[] args) {

        System.out.println(IntStream.of(1,2,3,4).min());

        System.out.println(IntStream.of(1,2,3,4,5).anyMatch( x -> x % 2 == 0));

        int arr[] = new int[] { 1,3,4,5,6,7};
        Arrays.stream(arr).map(x -> x*2).forEach(System.out::println);
    }
}
