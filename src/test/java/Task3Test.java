import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    static ArrayList<Integer> a;
    static ArrayList<Integer> b;

    @BeforeAll
    static void setUp() {
        a = new ArrayList<>(Arrays.stream(new Integer[]{3, 4, 6, 7, 5, 9, 10, 12, 14, 30, 32, 45}).toList());
        b = new ArrayList<>(Arrays.stream(new Integer[]{1, 2, 6, 57, 5, 11, 10, 15, 14, 19, 99, 45}).toList());
        System.out.println("Array A: " + a.toString());
        System.out.println("Array B: " + b.toString());
    }

    @Test
    void compareArraysAndGetCommon() {
        BiFunction<ArrayList<Integer>, ArrayList<Integer>, ArrayList<Integer>> compareArraysAndGetCommon = Task3::compareArraysAndGetCommon;
        ArrayList<Integer> result = compareArraysAndGetCommon.apply(a, b);
        System.out.println("Result of comparing: " + result.toString());

        System.out.print("Check if all elements exists in source array a... ");
        assertEquals(0, result.stream().filter((rVal) -> !a.contains(rVal)).toList().size());
        System.out.println("Correct!");

        System.out.print("Check if all elements exists in source array b... ");
        assertEquals(0, result.stream().filter((rVal) -> !b.contains(rVal)).toList().size());
        System.out.println("Correct!");
    }
}