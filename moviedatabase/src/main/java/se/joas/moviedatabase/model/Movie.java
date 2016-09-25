package se.joas.moviedatabase.model;

public final class Movie {

    private final int id;
    private final int productionYear;
    private final String title;

    private Movie(int id, int productionYear, String title) {
        this.id = id;
        this.productionYear = productionYear;
        this.title = title;
    }

    public static MovieBuilder builder(int productionYear, String title) {
        return new MovieBuilder(productionYear, title);
    }

    public int getId() {
        return id;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getTitle() {
        return title;
    }

    public static class MovieBuilder {

        private int id = 0;
        private int productionYear;
        private String title;

        private MovieBuilder(int productionYear, String title) {
            this.productionYear = productionYear;
            this.title = title;
        }

        public Movie build() {
            return new Movie(id, productionYear, title);
        }

        public MovieBuilder setId(int id) {
            this.id = id;
            return this;
        }

    }
}
