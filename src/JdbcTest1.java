import java.sql.*;

public class JdbcTest1 {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");

            System.out.println("Database successfully connected");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM employees");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("last_name") + ", " + resultSet.getString("first_name"));
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
