package com.example.repository;

import com.example.model.VectorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculateSDRepository extends JpaRepository<VectorDetails, Integer>{
}
