package collections.exercises;

import java.sql.Array;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 1. Create a Set<String> cities.
 2. Add at least 5 city names, including one duplicate.
 3. Print all cities (verify no duplicates).
 4. Check if a given city exists.
*/

public class Exercise2
{
    public static void main(String[] args) {

        Set<String> cities = new HashSet<>();
        addCities(cities, new  String[]{"Paris", "Brussels", "Tokyo", "London", "Paris"});
        System.out.println("cities: "+ cities);
        Set<String> visitedCities = new HashSet<>();
        addCities(visitedCities, new  String[]{"Paris", "Brussels", "Madrid", "London"});
        System.out.println("visitedCities: "+ visitedCities);
        System.out.println("Cities addAll (union)  visitedCities: "+ cities.addAll(visitedCities));
        System.out.println("cities: "+ cities + " visitedCities: " + visitedCities);
        cities.clear();
        System.out.println("Clear cities: "+ cities);
        addCities(cities, new  String[]{"Paris", "Brussels", "Tokyo", "London", "Paris"});
        cities.retainAll(visitedCities);
        System.out.println("RetainAll (intersection) cities: "+ cities);
    }
    public static Set addCities(Set set, String[] cities){
        for(String city:cities){
            set.add(city);
        }
       return set;
    }
}
