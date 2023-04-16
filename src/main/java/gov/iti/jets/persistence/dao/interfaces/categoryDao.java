package gov.iti.jets.persistence.dao.interfaces;

import java.util.Date;

import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.service.util.exceptions.validationException;

public interface categoryDao {
    public Category getCategoryByName(String CategoryName);
    public Category getCategoryByLastUpdate(Date last_update);
    public Category createCategory(Category category) throws validationException;
}
