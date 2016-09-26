package se.joas.moviedatabase.repository.mysql;

import java.sql.SQLException;
import java.util.List;

import se.joas.moviedatabase.model.Movie;
import se.joas.moviedatabase.repository.MovieRepository;
import se.joas.moviedatabase.repository.RepositoryException;

public class MySqlMovieRepository implements MovieRepository {

    private static final ResultMapper<Movie> MOVIE_MAPPER = (r -> Movie
            .builder(r.getInt("productionYear"), r.getString("title")).setId(r.getInt("id")).build());
    private final String url = "jdbc:mysql://localhost:3306/moviedatabase?useSSL=false";
    private final String user = "root";

    @Override
    public List<Movie> getAllMovies() throws RepositoryException {
        String select = "SELECT * FROM Movie";

        try {
            return new Sql(url, user, Password.getPassword()).query(select).selectMany(MOVIE_MAPPER);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    @Override
    public void addMovie(Movie movie) throws RepositoryException {
        String insert = "INSERT INTO Movie(title, productionYear) VALUES(?,?)";

        try {
            new Sql(url, user, Password.getPassword()).query(insert).parameter(movie.getTitle())
                    .parameter(movie.getProductionYear()).update();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }

    }

    @Override
    public void removeMovie(Movie movie) throws RepositoryException {
        // TODO Auto-generated method stub

    }

}
