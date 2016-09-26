package se.joas.moviedatabase.repository.mysql;

import java.sql.SQLException;
import java.util.List;

import se.joas.moviedatabase.model.ReviewUser;
import se.joas.moviedatabase.repository.RepositoryException;
import se.joas.moviedatabase.repository.ReviewUserRepository;

public class MySqlReviewUserRepository implements ReviewUserRepository {

    private static final ResultMapper<ReviewUser> REVIEW_USER_MAPPER = (r -> ReviewUser
            .builder(r.getString("username"), r.getString("registerDate")).setId(r.getInt("id")).build());
    private final String url = "jdbc:mysql://localhost:3306/moviedatabase?useSSL=false";
    private final String user = "root";
    
    @Override
    public List<ReviewUser> getAllReviewUsers() throws RepositoryException {
        String select = "SELECT * FROM reviewuser";
        try {
            return new Sql(url, user, Password.getPassword()).query(select).selectMany(REVIEW_USER_MAPPER);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    @Override
    public void addReviewUser(ReviewUser reviewUser) throws RepositoryException {
        
        String insert = "INSERT INTO Review(username, registerDate) VALUES(?,?)";

        try {
            new Sql(url, user, Password.getPassword()).query(insert).parameter(reviewUser.getUsername())
                    .parameter(reviewUser.getRegisterDate()).update();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    @Override
    public void removeReviewUser(ReviewUser reviewUser) throws RepositoryException {
        // TODO Auto-generated method stub

    }

}
