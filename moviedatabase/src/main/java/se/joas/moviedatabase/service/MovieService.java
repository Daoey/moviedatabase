package se.joas.moviedatabase.service;

import java.util.List;

import se.joas.moviedatabase.model.Actor;
import se.joas.moviedatabase.model.Movie;
import se.joas.moviedatabase.model.Review;
import se.joas.moviedatabase.model.ReviewUser;
import se.joas.moviedatabase.repository.ActorRepository;
import se.joas.moviedatabase.repository.MovieRepository;
import se.joas.moviedatabase.repository.RepositoryException;
import se.joas.moviedatabase.repository.ReviewRepository;
import se.joas.moviedatabase.repository.ReviewUserRepository;

public class MovieService {

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewUserRepository reviewUserRepository;

    /**
     * Movie service constructor.
     * 
     * @param actorRepository
     *            The actor repository
     * @param movieRepository
     *            The movie repository
     * @param reviewRepository
     *            The review repository
     * @param reviewUserRepository
     *            The review user repository
     */
    public MovieService(ActorRepository actorRepository, MovieRepository movieRepository,
            ReviewRepository reviewRepository, ReviewUserRepository reviewUserRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
        this.reviewUserRepository = reviewUserRepository;
    }

    /**
     * Gets all actors from the actor repository.
     * 
     * @return All actors in a list
     */
    public List<Actor> getAllActors() {
        try {
            return actorRepository.getAllActors();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Adds an actor to the actor repository.
     * 
     * @param actor
     *            The actor to add
     */
    public void addActor(Actor actor) {
        try {
            actorRepository.addActor(actor);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Removes an actor from the actor repository.
     * 
     * @param actor
     *            The actor to remove
     */
    public void removeActor(Actor actor) {
        try {
            actorRepository.removeActor(actor);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Gets all movies from the movie repository.
     * 
     * @return All movies in a list
     */
    public List<Movie> getAllMovies() {
        try {
            return movieRepository.getAllMovies();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Add a movie to the movie repository.
     * 
     * @param movie
     *            The movie to add
     */
    public void addMovie(Movie movie) {
        try {
            movieRepository.addMovie(movie);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Remove a movie from the movie repository.
     * 
     * @param movie
     *            The movie to remove
     */
    public void removeMovie(Movie movie) {
        try {
            movieRepository.removeMovie(movie);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Gets all reviews from the review repository.
     * 
     * @return All the reviews in a list
     */
    public List<Review> getAllReviews() {
        try {
            return reviewRepository.getAllReviews();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Adds a review to the review repository.
     * 
     * @param review
     *            The review to add
     */
    public void addReview(Review review) {
        try {
            reviewRepository.addReview(review);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Removes a review from the review repository.
     * 
     * @param review
     *            The review to remove
     */
    public void removeReview(Review review) {
        try {
            reviewRepository.removeReview(review);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Gets all review users from the review user repository.
     * 
     * @return All the review users in a list
     */
    public List<ReviewUser> getAllReviewUsers() {
        try {
            return reviewUserRepository.getAllReviewUsers();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Adds a review user to the review user repository.
     * 
     * @param reviewUser
     *            The review user to add
     */
    public void addReviewUser(ReviewUser reviewUser) {
        try {
            reviewUserRepository.addReviewUser(reviewUser);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Removes a review user from the review user repository.
     * 
     * @param reviewUser
     *            The review user to remove
     */
    public void removeReviewUser(ReviewUser reviewUser) {
        try {
            reviewUserRepository.removeReviewUser(reviewUser);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
