package gov.iti.jets.persistence.dao.interfaces;

import jakarta.persistence.EntityManager;

public interface EntityManagerOperations {
     EntityManager getEntityManager();
    void closeEntityManager();
}
