

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Exercise2 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
  //      write your answer here
        List<Country>countries = countryDao.findAllCountries();
        List<City>highestCities=countries.stream()
                       .map(c->c.getCities()
                            .stream()
                            .max(Comparator.comparing(City::getPopulation)))
                       .filter(c->c.isPresent())
                       .map(Optional::get)
                       .collect(Collectors.toList());

        
        Set<String>continents = countryDao.getAllContinents();
        continents
            .stream()
            .map(continent->highestCities
                .stream()
                .filter(city->countryDao.findCountryByCode(city.getCountryCode())
                .getContinent().equals(continent))
                .max(Comparator.comparing(City::getPopulation)))
                .filter(c->c.isPresent());//findCountryByCode

            for (String string : continents) {
                System.out.println(string);   
            }
    }

}
