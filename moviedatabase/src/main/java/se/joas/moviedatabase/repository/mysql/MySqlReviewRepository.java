package se.joas.moviedatabase.repository.mysql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.joas.moviedatabase.model.DatabaseReview;
import se.joas.moviedatabase.model.Movie;
import se.joas.moviedatabase.model.Review;
import se.joas.moviedatabase.model.ReviewUser;
import se.joas.moviedatabase.repository.RepositoryException;
import se.joas.moviedatabase.repository.ReviewRepository;

public class MySqlReviewRepository implements ReviewRepository {

    private static final ResultMapper<DatabaseReview> DATABASE_REVIEW_MAPPER = (r -> new DatabaseReview(r.getInt("id"),
            r.getInt("movieId"), r.getString("reviewDate"), r.getString("reviewText"), r.getInt("reviewUserId")));
    private static final MySqlReviewUserRepository REVIEW_USER_REPOSITORY = new MySqlReviewUserRepository();
    private static final MySqlMovieRepository MOVIE_REPOSITORY = new MySqlMovieRepository();
    private final String url = "jdbc:mysql://localhost:3306/moviedatabase?useSSL=false";
    private final String user = "root";

    @Override
    public List<Review> getAllReviews() throws RepositoryException {
        List<Movie> movies = MOVIE_REPOSITORY.getAllMovies();
        List<ReviewUser> reviewUsers = REVIEW_USER_REPOSITORY.getAllReviewUsers();

        String select = "SELECT * FROM review";
        List<DatabaseReview> databaseReviews;
        try {
            databaseReviews = new Sql(url, user, Password.getPassword()).query(select)
                    .selectMany(DATABASE_REVIEW_MAPPER);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }

        return createReviews(databaseReviews, movies, reviewUsers);
    }

    @Override
    public void addReview(Review review) throws RepositoryException {

        String insert = "INSERT INTO Review(reviewDate, reviewText, reviewUserId, movieId) VALUES(?,?,?,?)";

        try {
            new Sql(url, user, Password.getPassword()).query(insert).parameter(review.getReviewDate())
                    .parameter(review.getReviewText()).parameter(review.getReviewUser().getId())
                    .parameter(review.getMovie().getId()).update();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }

    }

    @Override
    public void removeReview(Review review) throws RepositoryException {
        // TODO Auto-generated method stub

    }

    private List<Review> createReviews(List<DatabaseReview> databaseReviews, List<Movie> movies,
            List<ReviewUser> reviewUsers) {

        List<Review> reviews = new ArrayList<Review>();

        for (DatabaseReview databaseReview : databaseReviews) {

            Movie movie = null;
            for (int i = 0; i < movies.size(); i++) {
                if (databaseReview.getMovieId() == movies.get(i).getId()) {
                    movie = movies.get(i);
                    break;
                }
            }

            ReviewUser reviewUser = null;
            for (int i = 0; i < reviewUsers.size(); i++) {
                if (databaseReview.getReviewUserId() == reviewUsers.get(i).getId()) {
                    reviewUser = reviewUsers.get(i);
                }
            }

            reviews.add(new Review(databaseReview.getId(), movie, databaseReview.getReviewDate(),
                    databaseReview.getReviewText(), reviewUser));
        }
        return reviews;
    }

}
