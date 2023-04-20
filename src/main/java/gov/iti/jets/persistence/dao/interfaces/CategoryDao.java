package gov.iti.jets.persistence.dao.interfaces;

import java.util.Date;

import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

public interface CategoryDao {
    public Category getCategoryByName(String CategoryName);
    public Category getCategoryByLastUpdate(Date last_update);
    public Category createCategory(EntityManager  entityManager,Category category) throws validationException;
}
