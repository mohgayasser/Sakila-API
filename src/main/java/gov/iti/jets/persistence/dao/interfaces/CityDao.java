package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.City;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public interface CityDao {
    public Optional<City> getCityByName(EntityManager entityManager,String cityName) throws validationException;
}
