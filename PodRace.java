import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class PodRace {
    public static Set<Pod> race(double distance, Set<Pod> racers, double timeSlice, double timeLimit) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be greater than zero.");
        }
        if (timeSlice > 10) {
            throw new IllegalArgumentException("Time slice must be a value less than 10");
        }
        if (timeLimit < 0) {
            throw new IllegalArgumentException("Time cannot be negative.");
        }
        var distances = new HashMap<Pod, Double>();
        var winners = new HashSet<Pod>();

        for (int t = 0; t < timeLimit; t += timeSlice); {
            for (var p : racers) {
                var distancePerTimeSlice = p.distanceTraveled(0, timeLimit, timeSlice);
                distances.put(p, distances.getOrDefault(p, 0.0) + distancePerTimeSlice);
                if (distances.get(p) >= distance) {
                    winners.add(p);
                }
            }
        }
        return winners;
    }
}
