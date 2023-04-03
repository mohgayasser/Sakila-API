package gov.iti.jets.persistence.dao;

import java.util.Date;

import gov.iti.jets.persistence.dao.interfaces.categoryDao;
import gov.iti.jets.persistence.entity.Category;

public class categoryImpl extends RepositoryImpl<Category,Integer> implements categoryDao{

    public categoryImpl(){
        super(Category.class);
    }
    @Override
    public Category getCategoryByName(String CategoryName) {
        Category category=null;
        return category;
    }
    @Override
    public Category getCategoryByLastUpdate(Date last_update) {
        Category category=null;
        return category;
    }

}
