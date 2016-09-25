package se.joas.moviedatabase.repository.mysql;

import java.sql.SQLException;
import java.util.List;

import se.joas.moviedatabase.model.Actor;
import se.joas.moviedatabase.repository.ActorRepository;
import se.joas.moviedatabase.repository.RepositoryException;

public final class MySqlActorRepository implements ActorRepository {

    private static final ResultMapper<Actor> USER_MAPPER = (r -> Actor
            .builder(r.getString("firstName"), r.getString("lastName")).setMiddleName(r.getString("middleName"))
            .setId(r.getInt("id")).build());
    private final String url = "jdbc:mysql://localhost:3306/moviedatabase?useSSL=false";
    private final String user = "root";

    @Override
    public List<Actor> getAllActors() throws RepositoryException {

        String select = "SELECT * FROM actor";

        try {
            return new Sql(url, user, Password.getPassword()).query(select).selectMany(USER_MAPPER);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    @Override
    public void addActor(Actor actor) throws RepositoryException {

        String insert = "INSERT INTO Actor(firstName, middleName, lastName) VALUES(?,?,?)";

        try {
            new Sql(url, user, Password.getPassword()).query(insert).parameter(actor.getFirstName())
                    .parameter(actor.getMiddleName()).parameter(actor.getLastName()).insert();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }

    }

    @Override
    public void removeActor(Actor actor) {
        // TODO Auto-generated method stub

    }

}
