package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
