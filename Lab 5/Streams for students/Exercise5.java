



import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

import java.util.Comparator;
import java.util.List;

public class Exercise5 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
       //write your answer here 

        List<List<City>> listOflists = countryDao.findAllCountries().stream()
                .map(country -> country.getCities())
                .collect(Collectors.toList());

        List<City> highestPopulatedCity = listOflists.stream()
                .map(cities -> cities.stream()
                        .max(Comparator.comparing(City::getPopulation)))
                .filter(Optional::isPresent)
                .map(city -> city.get())
                .collect(Collectors.toList());

        Optional<City> maxCity = highestPopulatedCity.stream() // get only capitals
                .filter(
                        city -> city.getId() == countryDao.findCountryByCode(city.getCountryCode()).getCapital())
                .max(Comparator.comparing(City::getPopulation));
        City max = maxCity.get();
        System.out.println(max.getName());

    }

}