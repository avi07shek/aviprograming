import java.util.Random;
import java.util.function.Function;
public class que5a {

    public static double hillClimbing(Function<Double, Double> function, double initialX, double stepSize, int maxIterations) {
        
        double currentX = initialX;
        double currentValue = function.apply(currentX);

        for (int i = 0; i < maxIterations; i++) {
            double neighborX = currentX + (new Random().nextDouble() * 2 - 1) * stepSize;
            double neighborValue = function.apply(neighborX);

            if (neighborValue > currentValue) {
                currentX = neighborX;
                currentValue = neighborValue;
            }
        }
        return currentX;
    }
    public static void main(String[] args) {
        
        Function<Double, Double> function = x -> -x * x + 5 * x + 10;

        double initialX = 0.0; 

        double stepSize = 0.1; 
        int maxIterations = 1000; 

        double localMaximum = hillClimbing(function, initialX, stepSize, maxIterations);

        double maximumValue = function.apply(localMaximum);

        System.out.println("Local maximum found at x = " + localMaximum);

        System.out.println("Value at local maximum = " + maximumValue);

    }

}
