package se.distansakademin.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import se.distansakademin.models.Car;

import java.util.List;

public class CarRepository {

    private EntityManager entityManager;

    public CarRepository() {
        var emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
    }

    public Car getCarById(Long id){
        var car = entityManager.find(Car.class, id);
        return car;
    }

    public List<Car> getAllCars(){
        var query = entityManager.createQuery("SELECT c FROM Car c", Car.class);
        var cars = query.getResultList();
        return cars;
    }

    public void insert(Car car) {
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();
    }

    public void update(Car car){
        entityManager.getTransaction().begin();
        entityManager.merge(car);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id){
        entityManager.getTransaction().begin();

        var queryString = "DELETE FROM Car WHERE id=:id";
        var query = entityManager.createQuery(queryString);

        query.setParameter("id", id);

        query.executeUpdate();

        entityManager.getTransaction().commit();
    }




}
