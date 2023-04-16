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
        query.setParameter("minAge", 30);
        List<Employee> employee = query.getResultList();
        entityManager.getTransaction().commit();
        for (Employee employee1 : employee) {
            System.out.println("Имя: " + employee1.getFirstName());
            System.out.println("Фамилия: " + employee1.getLastName());
            System.out.println("Возвраст: " + employee1.getAge());
            System.out.println("------------");
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
