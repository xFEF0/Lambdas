package functions;

public class MainFunctions {

    public static void main(String ...args) {
        OrderManagement orderManagement = new OrderManagement(new DistanceCalculatorDefaultImpl());

        orderManagement.setDistanceCalculator(new DistanceCalculator() {
            @Override
            public double calculateDistance(City city1, City city2) {
                return 0.0;
            }
        });

        DistanceCalculator longitudeDistanceCalculator = (city1, city2) ->
                city1.getLongitude() - city2.getLongitude();
        orderManagement.setDistanceCalculator(longitudeDistanceCalculator);

        orderManagement.setDistanceCalculator(((city1, city2) -> 3));

        orderManagement.setDistanceCalculator(GoogleDistanceCalculator::getDistanceBetweenCitiesStatic);
        GoogleDistanceCalculator gdc = new GoogleDistanceCalculator();
        orderManagement.setDistanceCalculator(gdc::getDistanceBetweenCities);
    }
}
