public interface CityDAO {
    void create(City city);

    City readById(int cityId);

    City update(City city);

    void delete(City city);
}
