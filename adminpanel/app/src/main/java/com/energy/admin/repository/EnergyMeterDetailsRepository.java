package com.energy.admin.repository;

import com.energy.admin.model.EnergyMeter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EnergyMeterDetailsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EnergyMeter> findByMeterDetails(String searchQuery) {
        // Use a parameterized query to prevent SQL injection
        String query = "SELECT em FROM EnergyMeter em WHERE em.id = :searchQuery";
        TypedQuery<EnergyMeter> typedQuery = entityManager.createQuery(query, EnergyMeter.class);
        typedQuery.setParameter("searchQuery", searchQuery);
        return typedQuery.getResultList();
    }
}
