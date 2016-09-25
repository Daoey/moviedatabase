package se.joas.moviedatabase.repository.mysql;

import java.util.List;

import se.joas.moviedatabase.model.Review;
import se.joas.moviedatabase.repository.RepositoryException;
import se.joas.moviedatabase.repository.ReviewRepository;

public class MySqlReviewRepository implements ReviewRepository {

    @Override
    public List<Review> getAllReviews() throws RepositoryException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addReview(Review review) throws RepositoryException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeReview(Review review) throws RepositoryException {
        // TODO Auto-generated method stub
        
    }
    
    public final class DatabaseReview {

        private final int id;
        private final int movieId;
        private final String reviewDate;
        private final String reviewText;
        private final int reviewUserId;
        
        private DatabaseReview(int id, int movieId, String reviewDate, String reviewText, int reviewUserId) {
            this.id = id;
            this.movieId = movieId;
            this.reviewDate = reviewDate;
            this.reviewText = reviewText;
            this.reviewUserId = reviewUserId;
        }
            
        public int getId() {
            return id;
        }
        
        public int getMovieId() {
            return movieId;
        }
        
        public String getReviewDate() {
            return reviewDate;
        }
        
        public String getReviewText() {
            return reviewText;
        }
        
        public int getReviewUserId() {
            return reviewUserId;
        }

        
    }
}
