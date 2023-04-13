import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee employee) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();

        entityManagerFactory.close();
    }
    @Override
    public Employee update(Employee employee) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Employee resultEmployee = entityManager.merge(employee);

        transaction.commit();
        entityManager.close();

        entityManagerFactory.close();

        return resultEmployee;
    }

    @Override
    public void delete(Employee employee) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        employee = entityManager.getReference(Employee.class, employee.getId());
        entityManager.remove(employee);

        transaction.commit();
        entityManager.close();

        entityManagerFactory.close();
    }
}