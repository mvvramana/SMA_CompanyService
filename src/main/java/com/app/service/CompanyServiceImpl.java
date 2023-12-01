package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Company;
import com.app.exception.CompanyNotFoundException;
import com.app.repo.CompanyRepository;
@Service
public class CompanyServiceImpl implements ICompanyService {
	
	@Autowired
	private CompanyRepository repo;

	@Override
	public Long createCompany(Company company) {
		return repo.save(company).getId();
	}

	@Override
	public void updateCompany(Company company) {
		if(company.getId()!=null && repo.existsById(company.getId()))
			repo.save(company);
	}

	@Override
	public Company getOneCompany(Long id) {
		Optional<Company> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new CompanyNotFoundException("Given '"+id+"' Not Exist");
		}
	}

	@Override
	public List<Company> getAllCompanies() {
		return repo.findAll();
		/*
		 * List<Company> list = repo.findAll(); return list;
		 */
	}

	

}
