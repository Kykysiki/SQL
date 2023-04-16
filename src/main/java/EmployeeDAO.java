import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);

    Employee update(Employee employee);

    Employee readById(Long id);

    void delete(Employee employee);
}
