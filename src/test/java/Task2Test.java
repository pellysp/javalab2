import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Task2Test {
    static Task2 task2;
    static ArrayList<Integer> generatedArrayList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        task2 = new Task2();
    }

    @Test
    @Order(1)
    void generateAArray() {
        int max = 500;
        int min = -500;
        int length = 5000;
        generatedArrayList = task2.generateAArray(length, min, max);

        System.out.println("Array List: " + generatedArrayList.toString());
        System.out.print("Check if min border correct... ");
        assertEquals(min, generatedArrayList.stream().mapToInt(Integer::intValue).reduce(Math::min).getAsInt());
        System.out.println("Correct!");
        System.out.print("Check if max border correct... ");
        assertEquals(max, generatedArrayList.stream().mapToInt(Integer::intValue).reduce(Math::max).getAsInt());
        System.out.println("Correct!");
        System.out.print("Check if correct length... ");
        assertEquals(length, generatedArrayList.size());
        System.out.println("Correct!");
    }

    @Test
    @Order(2)
    void generateBArray() {
        ArrayList<Integer> bArrayList = task2.generateBArray(generatedArrayList);
        System.out.println("B array list: " + bArrayList.toString());

        System.out.print("Check if correct length... ");
        assertEquals(generatedArrayList.size(), bArrayList.size());
        System.out.println("Correct!");

        System.out.print("Check result with another similar function... ");
        assertArrayEquals(task2.generateBAArrayNotFunction(generatedArrayList).toArray(Integer[]::new), bArrayList.toArray(Integer[]::new));
        System.out.println("Correct!");
    }

    @Test
    @Order(3)
    void generateBAArrayNotFunction() {
        ArrayList<Integer> bArrayList = task2.generateBAArrayNotFunction(generatedArrayList);
        System.out.println("B array list: " + bArrayList.toString());

        System.out.print("Check if correct length... ");
        assertEquals(generatedArrayList.size(), bArrayList.size());
        System.out.println("Correct!");

        System.out.print("Check result with another similar function... ");
        assertArrayEquals(task2.generateBArray(generatedArrayList).toArray(Integer[]::new), bArrayList.toArray(Integer[]::new));
        System.out.println("Correct!");
    }
}