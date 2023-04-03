package gov.iti.jets.persistence.dao.interfaces;

import java.util.Date;

import gov.iti.jets.persistence.entity.Category;

public interface categoryDao {
    public Category getCategoryByName(String CategoryName);
    public Category getCategoryByLastUpdate(Date last_update);
}
