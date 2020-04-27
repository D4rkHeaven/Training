package lopatin;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class DbUtil {
    private static final String DB_NAME = "postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "paroll";
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/" + DB_NAME,
                    DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            log.info("SQL Exception on connect {}", e.getMessage());
        }
    }

    /**
     * Looking for record with specified title
     *
     * @param title - title for searching record
     */
    public void search(String title) {
        try {
            title = Optional
                    .ofNullable(title)
                    .orElseGet(String::new);
            List<String> productList = new ArrayList<>();
            preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE title LIKE '%" + title + "%';");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String string = "";
                for (int i = 1; i < 8; i++) {
                    string = string.concat(resultSet.getString(i).concat(" | "));
                }
                productList.add(string);
            }
            System.out.println(productList);
        } catch (SQLException e) {
            log.info("SQL Exception on search {}", e.getMessage());
        }
    }

    /**
     * Changes title for productId
     *
     * @param title     - new title
     * @param productId - product for changing title
     */
    public void change(String title, int productId) {
        try {
            title = Optional
                    .ofNullable(title)
                    .orElseGet(String::new);
            preparedStatement = connection.prepareStatement("UPDATE products SET title = ? WHERE prod_id = ?;");
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info("SQL Exception on update {}", e.getMessage());
        }
    }

    /**
     * Deletes the record with specified productId
     *
     * @param productId record for deleting
     */
    public void delete(int productId) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM products WHERE prod_id = ?;");
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info("SQL Exception on delete {}", e.getMessage());
        }
    }

    /**
     * Adds new record with specified title
     *
     * @param title - title for new record
     */
    public void add(String title) {
        try {
            title = Optional
                    .ofNullable(title)
                    .orElseGet(String::new);
            preparedStatement = connection.prepareStatement("INSERT INTO products (" +
                    "category, title, actor, price, special, common_prod_id) VALUES " +
                    "(?,?,?,?,?,?);");
            preparedStatement.setInt(1, (int) (1 + Math.random() * 15));
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, "PINKMAN");
            preparedStatement.setFloat(4, (float) (1 + Math.random() * 50));
            preparedStatement.setShort(5, (short) (Math.random()));
            preparedStatement.setInt(6, (int) (Math.random() * 10000));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info("SQL Exception on insert {}", e.getMessage());
        }
    }

    public void disconnect() {
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
