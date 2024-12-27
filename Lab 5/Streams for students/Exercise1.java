

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




public class Exercise1 {

   public static void main(String[] args) {
      CountryDao countryDao= InMemoryWorldDao.getInstance();
      //write your answer here
      List<Country>countries = countryDao.findAllCountries();
      List<City>highestPopulationCities=countries.stream()
                           .map(c->c.getCities()
                                    .stream()
                                    .max(Comparator.comparing(City::getPopulation)))
                           .filter(c->c.isPresent())
                           .map(Optional::get)
                           .collect(Collectors.toList());

      for (City city : highestPopulationCities) {
         System.out.println("Name: "+city.getName()+"---> Country: "+city.getCountryCode()+"---> Population: "+city.getPopulation());

      }
   }

}