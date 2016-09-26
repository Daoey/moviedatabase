package se.joas.moviedatabase;

import java.util.List;

import se.joas.moviedatabase.model.Actor;
import se.joas.moviedatabase.model.Movie;
import se.joas.moviedatabase.model.Review;
import se.joas.moviedatabase.model.ReviewUser;
import se.joas.moviedatabase.repository.mysql.MySqlActorRepository;
import se.joas.moviedatabase.repository.mysql.MySqlMovieRepository;
import se.joas.moviedatabase.repository.mysql.MySqlReviewRepository;
import se.joas.moviedatabase.repository.mysql.MySqlReviewUserRepository;
import se.joas.moviedatabase.service.MovieService;

public final class Main {

    /**
     * Used for testing.
     * 
     * @param args
     *            parameters
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        MovieService movieService = new MovieService(new MySqlActorRepository(), new MySqlMovieRepository(),
                new MySqlReviewRepository(), new MySqlReviewUserRepository());

        movieService.addActor(Actor.builder("Martin", "Freeman").build());

        List<Actor> actors = movieService.getAllActors();
        System.out.println("---Actors---");
        for (Actor actor : actors) {
            System.out.println("Id: " + actor.getId());
            System.out.println("First name: " + actor.getFirstName());
            System.out.println("Middle name : " + actor.getMiddleName());
            System.out.println("Last name: " + actor.getLastName());
        }
        
        movieService.addMovie(Movie.builder(2003, "Harry Potter").build());

        List<Movie> movies = movieService.getAllMovies();
        System.out.println("---Movies---");
        for (Movie movie : movies) {
            System.out.println("Id: " + movie.getId());
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Production year: " + movie.getProductionYear());
        }
        
        List<Review> reviews = movieService.getAllReviews();
        System.out.println("---Reviews---");
        for (Review review : reviews) {
            System.out.println("Id: " + review.getId());
            System.out.println("Movie title: " + review.getMovie().getTitle());
            System.out.println("Review user username: " + review.getReviewUser().getUsername());
            System.out.println("Review text: " + review.getReviewText());
            System.out.println("Review date: " + review.getReviewDate());
        }
        System.out.println("---Review users---");
        List<ReviewUser> reviewUsers = movieService.getAllReviewUsers();
        for (ReviewUser reviewUser : reviewUsers) {
            System.out.println("Id: " + reviewUser.getId());
            System.out.println("Username: " + reviewUser.getUsername());
            System.out.println("Register date");
            
        }

        movieService.removeActor(actors.get(0));

    }
}
