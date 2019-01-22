package com.dcos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Darta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int darta_id; 
	
	private Date darta_date;
	
	private String office_name; 
	
	private String office_address; 
	
	private String subject;

	public int getDarta_id() {
		return darta_id;
	}

	public void setDarta_id(int darta_id) {
		this.darta_id = darta_id;
	}

	public Date getDarta_date() {
		return darta_date;
	}

	public void setDarta_date(Date darta_date) {
		this.darta_date = darta_date;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Darta [darta_id=" + darta_id + ", darta_date=" + darta_date + ", office_name=" + office_name
				+ ", office_address=" + office_address + ", subject=" + subject + "]";
	} 

}
