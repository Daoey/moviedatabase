package se.joas.moviedatabase.repository.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class Sql {

    private final String url;
    private final String user;
    private final String password;
    private String query;
    private List<Object> parameters;

    /**
     * Constructor for Sql.
     * 
     * @param url
     *            The url to the database
     * @param user
     *            The user of the database
     * @param password
     *            The password to the database
     */
    public Sql(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        parameters = new ArrayList<Object>();
    }

    public Sql query(String query) {
        this.query = query;
        return this;
    }

    public Sql parameter(Object parameter) {
        parameters.add(parameter);
        return this;
    }

    /**
     * Gets a list of T from the database.
     * 
     * @param mapper
     *            Describes how the result set should be mapped to T
     * @param <T>
     *            The type retrieved from database.
     * @return A list of T
     * @throws SQLException
     *             Can throw an SQLException whilst interacting with the
     *             database.
     */
    public <T> List<T> selectMany(ResultMapper<T> mapper) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = prepareStatement(connection);
                ResultSet resultSet = statement.executeQuery()) {

            List<T> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(mapper.map(resultSet));
            }

            return result;
        }
    }

    /**
     * Get a T from the database.
     * 
     * @param mapper
     *            Describes how the result set should be mapped to T
     * @param <T>
     *            The type retrieved from database.
     * @return T
     * @throws SQLException
     *             Can throw an SQLException whilst interacting with the
     *             database.
     */
    public <T> T selectSingle(ResultMapper<T> mapper) throws SQLException {

        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = prepareStatement(connection);
                ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return mapper.map(resultSet);
            }

            throw new RuntimeException("Could not get single value from query:" + query);
        }
    }

    /**
     * Inserts a row to the database.
     * 
     * @throws SQLException
     *             Can throw an SQLException whilst interacting with the
     *             database.
     */
    public void insert() throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = prepareStatement(connection)) {

            statement.executeUpdate();
        }

    }
    
    private PreparedStatement prepareStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < parameters.size(); i++) {
            statement.setObject(i + 1, parameters.get(i));
        }

        return statement;
    }

}
