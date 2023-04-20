package gov.iti.jets.service;

import java.util.Date;
import java.util.Optional;

import gov.iti.jets.persistence.dao.EntityManagerLoaner;
import gov.iti.jets.persistence.dao.EntityManagerOperationsProxy;
import gov.iti.jets.persistence.dao.CategoryImpl;
import gov.iti.jets.persistence.dao.TransactionImpl;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.dto.categories.getCategoryDto;
import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.presentation.models.AddCategoryDto;
import gov.iti.jets.presentation.models.CategorywithoutFilmsDto;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.AddCategoryMapper;
import gov.iti.jets.service.util.mapper.CategoryMapper;
import gov.iti.jets.service.util.mapper.CategoryWithoutFilmsMapper;
import gov.iti.jets.service.util.mapper.CustomerMapper;
import jakarta.persistence.EntityManager;


public class CategoryService {

    EntityManagerLoaner entityManagerLoaner =new EntityManagerLoaner();
    private final EntityManagerOperations entityManagerOperations;
    public CategoryService (){
        entityManagerOperations = new EntityManagerOperationsProxy();
    }
    public Integer addCategory(AddCategoryDto getCategoryDto) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        Category category = AddCategoryMapper.INSTANCRE.addCategoryDtoToCategory(getCategoryDto);
        category.setLastUpdate(new Date());
        CategoryImpl categoryimpl = new CategoryImpl();
        Category newCategory =categoryimpl.createCategory(entityManager,category);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return newCategory.getId();
    }
    public getCategoryDto getCategoryById(Integer categoryId)  throws validationException{
        EntityManager entityManager = entityManagerOperations.getEntityManager();

        Category category= entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Category.class),categoryId,"find");
        getCategoryDto getCategoryDto = CategoryMapper.INSTANCE.categoryToCategoryDto(category);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return getCategoryDto;

    }
    public CategorywithoutFilmsDto getCategoryByIdWithoutFilms(Integer categoryId)  throws validationException{
        EntityManager entityManager = entityManagerOperations.getEntityManager();

        Category category= entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Category.class),categoryId,"find");
        CategorywithoutFilmsDto getCategoryDto = CategoryWithoutFilmsMapper.INSTANCE.categoryToCategorywithoutFilmsDto(category);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return getCategoryDto;

    }
    public Boolean updateCategory(CategorywithoutFilmsDto categorywithoutFilmsDto) throws validationException{
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        Category existCategory= entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Category.class),categorywithoutFilmsDto.getId(),"find");
        existCategory.setLastUpdate(new Date());
        existCategory.setName(categorywithoutFilmsDto.getName());
        Category category= entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Category.class),existCategory,"update");

        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return  true;
    }


}