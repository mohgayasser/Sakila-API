package gov.iti.jets.persistence.dao;

import java.util.List;
import java.util.Optional;

import gov.iti.jets.persistence.dao.interfaces.ReadOnlyRepository;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.models.Page;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;

public class RepositoryImpl<E, K> implements ReadOnlyRepository<E, K> {

    protected EntityManager _entityManager;
    protected CriteriaBuilder _criteriaBuilder;
    private Class<E> type;

    public RepositoryImpl() {
    }

    public RepositoryImpl(Class<E> e) {
        _entityManager = EntityHandler.getEntityManager();
        _criteriaBuilder = EntityHandler.getCriteriaBuilder();
        type = e;
    }

    @Override
    public E create(E e) {

        try {
            _entityManager.getTransaction().begin();
            _entityManager.persist(e);
            _entityManager.getTransaction().commit();
        } catch (Exception ex) {
            _entityManager.getTransaction().rollback();
            System.out.println("erro : " + ex.getMessage());
            return null;
            // throw ex;
        }

        return e;
    }


    @Override
    public long count() {
        long count= (long) _entityManager.createQuery("SELECT COUNT(t) FROM " + type.getName() + "t ")
                .getSingleResult();
        return count;
    }

    @Override
    public List<E> findAll() {

        List<E> list = (List<E>) _entityManager.createQuery("FROM " + type.getName() + " ",type).getResultList();

        return list;
    }

    @Override
    public List<E> findAll(Page page) {


        Query selectQuery = _entityManager.createQuery("From "+type.getName());
        selectQuery.setFirstResult(page.getPageNumber()*page.getPageSize());
        selectQuery.setMaxResults(page.getPageNumber());
        List<E> list = selectQuery.getResultList();

        return list;
    }
    @Override
    public long pages(Page page) {
        long count= (long) _entityManager.createQuery("SELECT COUNT(t) FROM " + type.getName() + "t ")
                .getSingleResult();
        int lastPageNumber = (int) (Math.ceil(count / page.getPageSize()));

        return lastPageNumber;
    }

    @Override
    public Optional<E> findById(int id) throws validationException {
        E ew = null;
        try {
             ew = _entityManager.find(type, id);
        }catch (Exception e){
            throw new validationException("this id ("+id+") in "+type.getName()+" doesn't exist in our system");
        }
        return Optional.ofNullable(ew);
    }

    @Override
    public boolean remove(E e) {
        try {

            _entityManager.getTransaction().begin();
            _entityManager.remove(e);
            _entityManager.getTransaction().commit();

        } catch (Exception ex) {
            _entityManager.getTransaction().rollback();
            throw ex;
        }

        return true;
    }

    @Override
    public E update(E e) {
        try {
            _entityManager.getTransaction().begin();
            _entityManager.merge(e);
            _entityManager.getTransaction().commit();

        } catch (Exception ex) {
            _entityManager.getTransaction().rollback();
            throw ex;
        }
        return e;
    }

}
