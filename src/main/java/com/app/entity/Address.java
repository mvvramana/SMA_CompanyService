package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="addr_tab")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="addr_line1")
	private String line1;
	@Column(name="addr_line2")
	private String line2;
	@Column(name="addr_city")
	private String city;
	@Column(name="addr_state")
	private String state;
	@Column(name="addr_country")
	private String country;
	@Column(name="addr_pincode")
	private Long pincode;
	

}
