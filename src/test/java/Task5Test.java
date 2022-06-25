import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    private static int day;
    private static boolean l;

    @BeforeAll
    static void setUp() {
        day = 60;
        l = true;
    }

    @Test
    void decryptDay() {
        BiFunction<Integer, Boolean, DecryptedDay> decryptDay = Task5::decryptDay;
        DecryptedDay result = decryptDay.apply(day, l);

        System.out.print("Check allowed day range... ");
        assertTrue(result.getDay() > 0 && result.getDay() <= 31);
        System.out.println("Correct!");

        System.out.print("Check allowed month range... ");
        assertTrue(result.getMonth() > 0 && result.getMonth() <= 12);
        System.out.println("Correct!");

        System.out.println("Decrypted day:\nMonth: " + result.getMonth() + "\nDay: " + result.getDay());
    }
}