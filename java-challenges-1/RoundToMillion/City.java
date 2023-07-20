package RoundToMillion;

public record City(String cityName, String population) {

    @Override
    public String toString() {
        return "{" +
                "cityName='" + cityName + '\'' +
                ", population='" + population + '\'' +
                '}';
    }
}
