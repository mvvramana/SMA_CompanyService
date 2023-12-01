package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Company;
import com.app.exception.CompanyNotFoundException;
import com.app.service.ICompanyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyRestController {

	@Autowired
	private ICompanyService service;

	// 1. create company
	@PostMapping("/create")
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		log.info("Entered into save method");
		ResponseEntity<String> response = null;
		try {
			Long id = service.createCompany(company);
			response = ResponseEntity.ok("Created with id: " + id);
			log.info("company is created {}.", id);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("About to leave save method");
		return response;
	}
	
	//2. fetch all companies
	@GetMapping("/all")
	public ResponseEntity<List<Company>> getAllCpmpanies(){
		ResponseEntity<List<Company>> response=null;
		log.info("Entered into fetch all method");
		try {
			List<Company> list= service.getAllCompanies();
			response = ResponseEntity.ok(list);
			log.info("Fetch method executed successfully");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("About to leave fetch all method");
		return response;
	}
	
	//3. fetch company by id
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
		ResponseEntity<Company> response=null;
		log.info("Entered into fetch one company by id method");
		try {
			Company company=service.getOneCompany(id);
			response=ResponseEntity.ok(company);
			log.info("Ftech company by id method executed succssfully");
		} catch (CompanyNotFoundException e) {
			log.error(e.getMessage());
			throw e;
		}
		log.info("About to leave fetch one company by id method");
		return response;
	}

}
