package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.presentation.models.Page;

import java.util.List;
import java.util.Map;

public interface Transaction<T> extends Repository<T,Integer>{
    T singleResult(String Query, Map<String,Object> parameters);
    T functions(String Query, Map<String,Object> parameters);
    List<T> listResult(String Query, Map<String,Object> parameters, Page page);
}
