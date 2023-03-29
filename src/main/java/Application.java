import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "qwerty";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final Connection connection = DriverManager.getConnection(url, user, password);
//        PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)");
//        statement.setInt(1, 2);
//        final ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            String firstName = "Имя: " + resultSet.getString("first_name");
//            String lastName = "Фамилия: " + resultSet.getString("last_name");
//            String gender = "Пол: " + resultSet.getString("gender");
//            int age = resultSet.getInt(5);
//            System.out.println(firstName);
//            System.out.println(lastName);
//            System.out.println(gender);
//            System.out.println("Возраст: " + age);
//        }

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employeeList = employeeDAO.readAll();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
