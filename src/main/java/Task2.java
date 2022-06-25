import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Task2 {
    private int random(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public ArrayList<Integer> generateAArray(int length, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(random(min, max));
        }
        return result;
    }

   public ArrayList<Integer> generateBArray(ArrayList<Integer> aArrayList) {
        return new ArrayList<>(
                aArrayList.stream().map(
                        (aVal) -> aArrayList.stream()
                                .filter((computeAVal) -> Objects.equals(aVal, computeAVal))
                                .toArray().length)
                        .toList());
   }

    public ArrayList<Integer> generateBAArrayNotFunction(ArrayList<Integer> aArrayList) {
        ArrayList<Integer> bArrayList = new ArrayList<>();

        for (int i = 0; i < aArrayList.size(); i++) {
            int amount = 0;
            for (int j = 0; j < aArrayList.size(); j++) {
                if (aArrayList.get(j) == aArrayList.get(i)) {
                    amount++;
                }
            }
            bArrayList.add(amount);
        }
        return bArrayList;
    }
}
