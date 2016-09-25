package se.joas.moviedatabase.repository.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultMapper<T> {

    T map(ResultSet resultSet) throws SQLException;

}