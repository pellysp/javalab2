import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task1 {
    private ArrayList<Integer> array;
    public final String ANSI_RESET = "\u001B[0m";
    public final String ANSI_RED = "\u001B[31m";
    private final int DEFAULT_LENGTH  = 30;
    private final int RANDOM_MIN = -25;
    private final int RANDOM_MAX = 25;

    private int random(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public ArrayList<Integer> generateArray(@Nullable Integer length) throws Exception {
        int arrayLength = DEFAULT_LENGTH;
        if (length == null) {
            System.out.println("Please enter length to generate array:");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            try {
                String arrayLengthStringed = reader.readLine();
                arrayLength = Integer.parseInt(arrayLengthStringed);
                if (arrayLength < 1) {
                    throw new Exception("Array length couldn't be smaller than 1");
                }
            } catch (IOException e) {
                throw new Exception("Field to read console input");
            } catch (NumberFormatException e) {
                throw new Exception("Invalid input type, please provide int");
            }
        } else {
            arrayLength = length;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            result.add(random(RANDOM_MIN, RANDOM_MAX));
        }

        return result;
    }

    public String process(ArrayList<Integer> arrayList) {
        if (arrayList != null) {
            array = arrayList;
        }

        boolean hasNegative = false;
        boolean hasPositive = false;
        for (Integer val: array) {
            if (val > 0) {
                hasPositive = true;
            } else if (val < 0) {
                hasNegative = true;
            }
        }

        if (hasNegative && hasPositive) {
            return  "Array has positive and negative numbers";
        } else if (hasNegative) {
            return "Array has only negative numbers";
        } else if (hasPositive) {
            return "Array has only positive numbers";
        } else {
            return "Array fulfilled with zeros";
        }
    }
}