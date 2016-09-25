package se.joas.moviedatabase.repository;

import java.util.List;

import se.joas.moviedatabase.model.Review;

public interface ReviewRepository {

    List<Review> getAllReviews() throws RepositoryException;
    
    void addReview(Review review) throws RepositoryException;
    
    void removeReview(Review review) throws RepositoryException;
    
}
