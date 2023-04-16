package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.City;
import gov.iti.jets.service.util.exceptions.validationException;

import java.util.Optional;

public interface CityDao {
    public Optional<City> getCityByName(String cityName) throws validationException;
}
