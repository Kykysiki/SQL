import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT s FROM Employee s WHERE s.age > :minAge";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employee = query.getResultList();
        entityManager.getTransaction().commit();
        for (Employee employee1 : employee) {
            System.out.println("Student ID: " + employee1.getId());
            System.out.println("Student Name: " + employee1.getLast_name());
            System.out.println("Student Age: " + employee1.getAge());
            System.out.println("------------");
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
