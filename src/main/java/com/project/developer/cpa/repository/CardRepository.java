package com.project.developer.cpa.repository;


import com.project.developer.cpa.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends JpaRepository<CreditCard, Long> {
    CreditCard findByName(String name);
}

