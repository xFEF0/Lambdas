package functions.lambdas;

public class OrderManagement {

    private DistanceCalculator distanceCalculator;

    OrderManagement(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    void setDistanceCalculator(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }
}
