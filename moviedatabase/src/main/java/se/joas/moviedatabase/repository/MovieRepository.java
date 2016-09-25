package se.joas.moviedatabase.repository;

import java.util.List;

import se.joas.moviedatabase.model.Movie;

public interface MovieRepository {
    
    List<Movie> getAllMovies() throws RepositoryException;
    
    void addMovie(Movie movie) throws RepositoryException;
    
    void removeMovie(Movie movie) throws RepositoryException;

}
