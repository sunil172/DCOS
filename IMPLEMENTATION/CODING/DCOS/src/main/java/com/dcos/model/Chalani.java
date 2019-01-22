package com.dcos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chalani {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chalani_id; 
	
	private Date chalani_date; 
	
	private String ltr_subject; 
	
	private String office_name; 
	
	private String office_address;

	public int getChalani_id() {
		return chalani_id;
	}

	public void setChalani_id(int chalani_id) {
		this.chalani_id = chalani_id;
	}

	public Date getChalani_date() {
		return chalani_date;
	}

	public void setChalani_date(Date chalani_date) {
		this.chalani_date = chalani_date;
	}

	public String getLtr_subject() {
		return ltr_subject;
	}

	public void setLtr_subject(String ltr_subject) {
		this.ltr_subject = ltr_subject;
	}

	public String getOffice_name() {
		return office_name;
	}

	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}

	public String getOffice_address() {
		return office_address;
	}

	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}

	@Override
	public String toString() {
		return "Chalani [chalani_id=" + chalani_id + ", chalani_date=" + chalani_date + ", ltr_subject=" + ltr_subject
				+ ", office_name=" + office_name + ", office_address=" + office_address + "]";
	}

}
