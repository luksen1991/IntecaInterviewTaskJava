package com.example.Family.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="family")
public class Family {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "father_id")
	private Father father;
	
	@JsonManagedReference
	@OneToMany(mappedBy="family",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Child> childList;

	public Father getFather() {
		return father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public List<Child> getChildList() {
		return childList;
	}

	public void setChildList(List<Child> childList) {
		this.childList = childList;
	}

	public int getId() {
		return id;
	}
	
	
}
