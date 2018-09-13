package com.example.Family.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="father")
public class Father {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="secondName")
	private String secondName;
	
	@Column(name="PESEL")
	private String pesel;
	
	@Column(name="BirthDate")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@JsonBackReference
	@OneToOne(mappedBy = "father")
	private Family family;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public int getId() {
		return id;
	}
	
	
	

}
