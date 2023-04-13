import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);

    Employee update(Employee employee);

    void delete(Employee employee);
}
