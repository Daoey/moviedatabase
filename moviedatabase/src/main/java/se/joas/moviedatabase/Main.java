package se.joas.moviedatabase;

import java.util.List;

import se.joas.moviedatabase.model.Actor;
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

        for (Actor actor : actors) {
            System.out.println("Id: " + actor.getId());
            System.out.println("First name: " + actor.getFirstName());
            System.out.println("Middle name : " + actor.getMiddleName());
            System.out.println("Last name: " + actor.getLastName());
        }
        
        movieService.removeActor(actors.get(0));

    }
}
