package com.mangkyu.stream.Quiz5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
    public int quiz1() {
        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .sum();
    }

    // 5.2 문자열 중에서 가장 긴 것의 길이를 출력하시오.
    public int quiz2() {
        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .reduce(Integer.MIN_VALUE, Math::max);
    }

    // 5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
    public List<Integer> quiz3() {
        return new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .boxed()
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
    public List<Integer[]> quiz4() {
        List<Integer> dice1 = IntStream.range(1, 6)
                .distinct()
                .limit(6)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> dice2 = IntStream.range(1, 6)
                .distinct()
                .limit(6)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        return dice1.stream()
                .flatMap(num1 -> dice2.stream().map(num2 -> new Integer[]{num1, num2}))
                .filter(numArr -> numArr[0] + numArr[1] == 6)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

}