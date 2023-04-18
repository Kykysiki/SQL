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
        entityManager.persist(city);
        City cityFromDb = entityManager.find(City.class, 5);
        System.out.println(cityFromDb);
        cityFromDb.getEmployeeList().get(3).setFirstName("Филипп");
        entityManager.merge(cityFromDb);
        Employee employeeToDelete = entityManager.find(Employee.class, employee2.getId());
        entityManager.remove(employeeToDelete);
        entityManager.close();
        entityManagerFactory.close();
    }
}
