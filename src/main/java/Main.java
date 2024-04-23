import java.sql.*;


/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 18-Apr-24 5:20 PM
 * @project PracticeDatabase
 * @since ${11.0.18}
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/student";
        String username = "postgres";
        String password = "123456";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection successful");

            //print all available tables
            // Get metadata from the connection
            DatabaseMetaData metaData = connection.getMetaData();

            // Specify the type of database metadata to retrieve (in this case, tables)
            String[] types = {"TABLE"};
            ResultSet resultSet = metaData.getTables(null, null, "%", types);

            // Iterate through the result set and print table names
            System.out.println("List of Tables:");
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                System.out.println(tableName);
            }

           //select all from a table
            String selectAll = "SELECT * FROM it";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()){
                int id  = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String semester = result.getString("semester");

                System.out.println(id + " " + firstName + " " + lastName + " " + semester );
            }

            connection.close();


        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

    }
}

