import java.sql.*;

public class JdbcTest4 {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "student";
        String pass = "student";

        try {
            connection = DriverManager.getConnection(url, user, pass);

            statement = connection.createStatement();

            System.out.println("Deleting the user");

            statement.executeUpdate(
                    "DELETE FROM employees " +
                            "WHERE id = 14");

            resultSet = statement.executeQuery("SELECT * FROM employees ORDER BY last_name");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("last_name") + ", " +
                        resultSet.getString("first_name") + ", " +
                        resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
}
