package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.CountryDao;
import gov.iti.jets.persistence.entity.Country;
import gov.iti.jets.service.util.exceptions.validationException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class CountryImpl implements CountryDao {
    EntityManagerLoaner entityManagerLoaner ;
    public CountryImpl(){
        entityManagerLoaner =new EntityManagerLoaner();
    }
    @Override
    public Optional<Country> getCountryByName(String countryName) throws validationException {
        String SQLStr ="From Country c where c.country = :name";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("name",countryName);
        Country country =  entityManagerLoaner.execute(new TransactionImpl<>(Country.class),SQLStr,map);
        return Optional.ofNullable(country);
    }
}
