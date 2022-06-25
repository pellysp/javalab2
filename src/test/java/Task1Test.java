import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Task1Test {
    static Task1 task1;
    static ArrayList<Integer> generatedArrayList = new ArrayList<>();

    @BeforeAll
    static void setUp() {
        task1 = new Task1();
    }

    @Test
    @Order(1)
    void generateArray() throws Exception {
        assertDoesNotThrow(() -> task1.generateArray(8));
        ArrayList<Integer> arrayList = task1.generateArray(8);
        generatedArrayList = arrayList;
        assertEquals(8, arrayList.size());
    }

    @Test
    @Order(2)
    void process() {
        assertTrue(generatedArrayList.size() != 0);
        String result = task1.process(generatedArrayList);
        assertTrue(() -> result == "Array has positive and negative numbers"
                || result == "Array has only negative numbers"
                || result == "Array has only positive numbers"
                || result == "Array fulfilled with zeros");
    }
}