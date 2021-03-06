package com.cts.consumer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Business_Master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private Long id;

	@NotBlank
	@Size(max = 40)
	@Column(name = "Business_Category")
	private String businesscategory;
	
	@NotBlank
	@Size(max = 40)
	@Column(name = "Business_Type")
	private String businesstype;
	
	@NotNull
	@Column(name = "Total_Employees")
	private Long totalemployees;
	
	@NotNull
	@Column(name = "Business_Age")
	private Long businessage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinesscategory() {
		return businesscategory;
	}

	public void setBusinesscategory(String businesscategory) {
		this.businesscategory = businesscategory;
	}

	public String getBusinesstype() {
		return businesstype;
	}

	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}

	public Long getTotalemployees() {
		return totalemployees;
	}

	public void setTotalemployees(Long totalemployees) {
		this.totalemployees = totalemployees;
	}

	public Long getBusinessage() {
		return businessage;
	}

	public void setBusinessage(Long businessage) {
		this.businessage = businessage;
	}

	
	
}
