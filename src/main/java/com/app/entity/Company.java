package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
@Data
@Entity
@Table(name="company_tab")
@DynamicUpdate
public class Company {
	@Id
	@Column(name="com_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="com_name")
	private String name;
	@Column(name="com_regid")
	private String cregId;
	@Column(name="com_type")
	private String ctype;
	@Column(name="com_parentorg")
	private String parentOrg;
	@Column(name="com_mode")
	private String modeOfOperate;
	@Column(name="com_service_code")
	private String sreviceCode;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="aidFk")
	private Address addr; //Has-A

}
