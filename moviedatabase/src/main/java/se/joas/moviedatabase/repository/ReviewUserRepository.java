package se.joas.moviedatabase.repository;

import java.util.List;

import se.joas.moviedatabase.model.ReviewUser;

public interface ReviewUserRepository {

    List<ReviewUser> getAllReviewUsers() throws RepositoryException;
    
    void addReviewUser(ReviewUser reviewUser) throws RepositoryException;
    
    void removeReviewUser(ReviewUser reviewUser) throws RepositoryException;
}
