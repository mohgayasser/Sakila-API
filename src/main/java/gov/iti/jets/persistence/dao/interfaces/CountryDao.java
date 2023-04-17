package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Country;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public interface CountryDao {
    public Optional<Country> getCountryByName(EntityManager entityManager,String countryName) throws validationException;
}
