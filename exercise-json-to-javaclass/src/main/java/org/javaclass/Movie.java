package org.javaclass;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private boolean adult;
    private String backdropPath;
    private String belongs_to_collection;
    private long budget;
    private List<Genres> genres;
    private String homepage;
    private int id;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private float popularity;
    private String poster_path;
    private List<ProductionCompanies> productionCompanies;
    private List<ProductionCountries> productionCountries;
    private LocalDate releaseDate;
    private long revenue;
    private int runtime;
    private List<SpokenLanguages> spokenLanguages;
    private String status;
    private String tagLine;
    private String title;
    private Boolean video;
    private float voteAverage;
    private int voteCount;

    public Movie(boolean adult, String backdropPath, String belongs_to_collection, long budget, List<Genres> genres,
                 String homepage, int id, String imdbId, String originalLanguage, String originalTitle, String overview,
                 float popularity, String poster_path, List<ProductionCompanies> productionCompanies,
                 List<ProductionCountries> productionCountries, LocalDate releaseDate, long revenue, int runtime,
                 List<SpokenLanguages> spokenLanguages, String status, String tagLine, String title, Boolean video,
                 float voteAverage, int voteCount) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagLine = tagLine;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(String belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<ProductionCompanies> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompanies> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<ProductionCountries> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountries> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<SpokenLanguages> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguages> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}