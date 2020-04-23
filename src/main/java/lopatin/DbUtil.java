package lopatin;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class DbUtil {
    private static final String DB_PASSWORD = "parol";
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    public static void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
                    "postgres", DB_PASSWORD);
        } catch (SQLException e) {
            log.info("SQL Exception on connect {}", e.getMessage());
        }
    }

    public static void disconnect() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            log.info("SQL Exception on disconnect {}", e.getMessage());
        }
    }
}
