import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CityDAOImpl implements CityDAO {

    @Override
    public void create(City city) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(city);

        transaction.commit();
        entityManager.close();

        entityManagerFactory.close();
    }

    @Override
    public City readById(int cityId) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        City city = entityManager.find(City.class, cityId);

        transaction.commit();
        entityManager.close();

        entityManagerFactory.close();
        return city;
    }

    @Override
    public City update(City city) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        City resultCity = entityManager.merge(city);

        transaction.commit();
        entityManager.close();

        entityManagerFactory.close();

        return resultCity;
    }

    @Override
    public void delete(City city) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        city = entityManager.getReference(City.class, city.getCityId());
        entityManager.remove(city);

        transaction.commit();
        entityManager.close();

        entityManagerFactory.close();
    }
}
