import java.util.ArrayList;
import java.util.OptionalDouble;

class ComputingResult {
    private double lessThenAvg = 0;
    private double equalWithAvg = 0;
    private double biggerThanAvg = 0;

    public double getLessThenAvg() {
        return lessThenAvg;
    }

    public double getEqualWithAvg() {
        return equalWithAvg;
    }

    public double getBiggerThanAvg() {
        return biggerThanAvg;
    }

    ComputingResult(double lessThenAvg, double equalWithAvg, double biggerThanAvg) {
        this.lessThenAvg = lessThenAvg;
        this.equalWithAvg = equalWithAvg;
        this.biggerThanAvg = biggerThanAvg;
    }
}

public class Task4 {
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

    public ComputingResult compute(ArrayList<Integer> a) throws Exception {
        OptionalDouble optionalAverage = a.stream().mapToDouble(aVal -> aVal).average();
        if (optionalAverage.isEmpty()) {
            throw new Exception("Couldn't compute average");
        }
        double realAverage = optionalAverage.getAsDouble();

        return new ComputingResult(
                (double)a.stream().filter((aVal) -> aVal < realAverage).toArray().length / (double)a.size() * 100.0,
                (double)a.stream().filter((aVal) -> aVal == realAverage).toArray().length / (double)a.size() * 100.0,
                (double)a.stream().filter((aVal) -> aVal > realAverage).toArray().length / (double)a.size() * 100.0
        );
    }
}
