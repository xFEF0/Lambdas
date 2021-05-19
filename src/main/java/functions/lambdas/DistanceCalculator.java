package functions.lambdas;

@FunctionalInterface
interface DistanceCalculator {

    double calculateDistance(City city1, City city2);

    default void someDefaultMethod() {};
    static void someStaticMethod() {};
}
