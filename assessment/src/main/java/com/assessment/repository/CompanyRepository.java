package com.assessment.repository;

import com.assessment.model.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Companies,Integer> {

}
