import java.util.ArrayList;
import java.util.Arrays;

public class Task3 {

    public static ArrayList<Integer> compareArraysAndGetCommon(ArrayList<Integer> a, ArrayList<Integer> b) {
        return new ArrayList<>(a.stream().filter(b::contains).toList());
    }
}
