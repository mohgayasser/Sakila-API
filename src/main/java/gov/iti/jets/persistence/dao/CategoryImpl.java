package gov.iti.jets.persistence.dao;

import java.util.Date;

import gov.iti.jets.persistence.dao.interfaces.CategoryDao;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

public class CategoryImpl implements CategoryDao {
    EntityManagerLoaner entityManagerLoaner;
    public CategoryImpl(){
        entityManagerLoaner = new EntityManagerLoaner();
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

    @Override
    public Category createCategory(EntityManager entityManager,Category category) throws validationException {
        Category newCategory = entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Category.class),category,"create");
        return newCategory;
    }


}
