package RoundToMillion;

import java.util.ArrayList;
import java.util.List;

public class RoundToMillionMain {

    public static void roundToMillion(List<City> cityList){
        List<City> result = new ArrayList<>();
        for (City city:cityList) {
            int population = Integer.parseInt(city.population());
            if(population>500000){
                result.add(new City(city.cityName(),""+Math.round(population/1000000.0)*1000000));
            }
            else{
                result.add(new City(city.cityName(),"0"));
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("Nice","942208"));
        cityList.add(new City("Abu Dhabi","1482816"));
        cityList.add(new City("Naples","2186853"));
        cityList.add(new City("Vatican RoundToMillion.City","572"));
        roundToMillion(cityList);
    }
}
