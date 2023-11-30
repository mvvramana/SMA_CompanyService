package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Company;
import com.app.service.ICompanyService;

@RestController
@RequestMapping("/company")
public class CompanyRestController {

	@Autowired
	private ICompanyService service;

	// 1. create company
	@PostMapping("/create")
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		ResponseEntity<String> response = null;
		try {
			Long id = service.createCompany(company);
			response = ResponseEntity.ok("Created with id: " + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
