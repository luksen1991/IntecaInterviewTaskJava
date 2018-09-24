package com.example.Family.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.example.Family.Entities.Family;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="child")
public class Child implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="SecondName")
    private String secondName;

    @Column(name="PESEL")
    private String pesel;
    
    @Column(name="BirthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name="Sex")
    private String sex;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="familyid",referencedColumnName = "id")
  private Family family;

  
public Date getBirthDate() {
	return birthDate;
}

public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}

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

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
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