import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        City city = new City(5, "Ekaterinburg");

        Employee employee1 = new Employee("Ширшов", "Алексей", "муж", 30, city.getCityId());
        Employee employee2 = new Employee("Немова", "Луиза", "жен", 25, city.getCityId());
        city.getEmployeeList().add(employee1);
        city.getEmployeeList().add(employee2);


        CityDAOImpl cityDAO = new CityDAOImpl();
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();


        cityDAO.create(city);
        City cityFromDb = cityDAO.readById(5);
        System.out.println(cityFromDb);
        cityFromDb.setCityName("New Ekaterinburg");
        cityDAO.update(cityFromDb);
        cityDAO.delete(cityFromDb);


        employeeDAO.create(employee1);
        Employee employeeFromDb = employeeDAO.readById(employee1.getId());
        System.out.println(employeeFromDb);
        employeeFromDb.setFirstName("New Alexey");
        employeeDAO.update(employeeFromDb);
        employeeDAO.delete(employeeFromDb);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}