package com.cts.consumer.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public class ConsumerBusinessRequest {
	
	@NotBlank
	@Size(max = 50)
	private String firstname;
	
	@NotBlank
	@Size(max = 50)
	private String lastname;
	
	@NotBlank
	@Size(max = 20)
	private String dob;
	
	@NotBlank
	@Size(max = 50)
	private String businessname;
	
	@NotBlank
	@Size(max = 12)
	private String pandetails;
	
	@NotBlank
	@Size(max = 50)
	private String email;
	
	@NotBlank
	@Size(max = 10)
	private String phone;
	
	@NotBlank
	@Size(max = 40)
	private String website;
	
	@NotBlank
	@Size(max = 150)
	private String businessoverview;
	
	@NotBlank
	@Size(max = 30)
	private String validity;
	
	@NotBlank
	@Size(max = 50)
	private String agentname;
	
	@NotNull
	private Long agentid;
	
	@NotBlank
	@Size(max = 40)
	private String businesscategory;
	
	@NotBlank
	@Size(max = 40)
	private String businesstype;
	
	@NotNull
	private Long businessturnover;
	
	@NotNull
	private Long capitalinvested;
	
	@NotNull
	private Long totalemployees;
	
	
	@NotNull
	private Long businessage;


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getBusinessname() {
		return businessname;
	}


	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}


	public String getPandetails() {
		return pandetails;
	}


	public void setPandetails(String pandetails) {
		this.pandetails = pandetails;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getBusinessoverview() {
		return businessoverview;
	}


	public void setBusinessoverview(String businessoverview) {
		this.businessoverview = businessoverview;
	}


	public String getValidity() {
		return validity;
	}


	public void setValidity(String validity) {
		this.validity = validity;
	}


	public String getAgentname() {
		return agentname;
	}


	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}


	public Long getAgentid() {
		return agentid;
	}


	public void setAgentid(Long agentid) {
		this.agentid = agentid;
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


	public Long getBusinessturnover() {
		return businessturnover;
	}


	public void setBusinessturnover(Long businessturnover) {
		this.businessturnover = businessturnover;
	}


	public Long getCapitalinvested() {
		return capitalinvested;
	}


	public void setCapitalinvested(Long capitalinvested) {
		this.capitalinvested = capitalinvested;
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
