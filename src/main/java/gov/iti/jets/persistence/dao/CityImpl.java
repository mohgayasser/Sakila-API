package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.CityDao;
import gov.iti.jets.persistence.entity.City;
import gov.iti.jets.service.util.exceptions.validationException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class CityImpl implements CityDao {
    EntityManagerLoaner entityManagerLoaner ;
    public CityImpl(){
        entityManagerLoaner = new EntityManagerLoaner();
    }
    @Override
    public Optional<City> getCityByName(String cityName) throws validationException {
        String SQLStr ="From City c where c.city = :name";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("name",cityName);
        City city =  entityManagerLoaner.execute(new TransactionImpl<>(City.class),SQLStr,map);
        return Optional.ofNullable(city);
    }
}
