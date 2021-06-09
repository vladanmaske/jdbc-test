import java.sql.*;

public class JdbcTest5 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "student";
        String pass = "student";

        try {
            connection = DriverManager.getConnection(url, user, pass);
            preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE salary > ? AND department = ?");

            preparedStatement.setDouble(1, 80000);
            preparedStatement.setString(2, "Legal");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("last_name") + ", " +
                        resultSet.getString("first_name") + ", " +
                        resultSet.getDouble("salary") + ", " +
                        resultSet.getString("department"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
}
