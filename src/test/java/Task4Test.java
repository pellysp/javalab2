import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Task4Test {
    private static Task4 task4;
    private static ArrayList<Integer> generatedArrayList;
    @BeforeAll
    static void setUp() {
        task4 = new Task4();
    }

    @Test
    @Order(1)
    void generateAArray() {
        int max = 500;
        int min = -500;
        int length = 5000;
        generatedArrayList = task4.generateAArray(length, min, max);

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
    void compute() throws Exception {
        ComputingResult computingResult;

        System.out.println("\nCompute test");

        System.out.print("Check for not throwing exception.. ");
        assertDoesNotThrow(() -> task4.compute(generatedArrayList));
        System.out.println("Correct!");

        computingResult = task4.compute(generatedArrayList);

        System.out.print("Check if sum of percents equals to 100... ");
        assertEquals(100, Math.floor(computingResult.getBiggerThanAvg() + computingResult.getEqualWithAvg() + computingResult.getLessThenAvg()));
        System.out.println("Correct!");


        System.out.println("Result:\nLess than avg: " + computingResult.getLessThenAvg() + "%\nEquals to avg: " + computingResult.getEqualWithAvg() + "%\nBigger than avg: " + computingResult.getBiggerThanAvg() + "%");
    }
}