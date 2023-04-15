package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.service.util.models.Page;

import java.util.List;
import java.util.Map;

public interface Transaction<T> {
    T singleResult(String Query, Map<String,Object> parameters);
    List<T> listResult(String Query, Map<String,Object> parameters, Page page);
}
