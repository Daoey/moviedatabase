package se.joas.moviedatabase.repository;

import java.util.List;

import se.joas.moviedatabase.model.Actor;

public interface ActorRepository {

    List<Actor> getAllActors() throws RepositoryException;

    void addActor(Actor actor) throws RepositoryException;

    void removeActor(Actor actor) throws RepositoryException;

}
