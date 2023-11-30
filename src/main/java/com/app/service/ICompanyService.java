package com.app.service;

import java.util.List;

import com.app.entity.Company;

public interface ICompanyService {
	
	Long createCompany(Company company);
	void updateCompany(Company company);
	Company getOneCompany(Long id);
	List<Company> getAllCompanies();
}
