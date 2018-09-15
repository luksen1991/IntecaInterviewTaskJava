package com.example.Family.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.example.Family.Entities.Child;
import com.example.Family.Entities.Family;
import com.example.Family.Utils.HibernateUtil;

@Component
@Transactional
public class FamilyRepository {

	@Transactional
	public Family addFamily(Family family) {
	    // TODO Auto-generated method stub

	    HibernateUtil.initManager();
	    HibernateUtil.getEntityManager().clear();
	    HibernateUtil.getEntityManager().getTransaction().begin();
	    HibernateUtil.getEntityManager().persist(family);
	    HibernateUtil.getEntityManager().getTransaction().commit();
	    HibernateUtil.shutdown();
	    return family;
	}
	
	@Transactional
	public List<Family> findAllFamilies() {
	    // TODO Auto-generated method stub
	    HibernateUtil.initManager();
	    HibernateUtil.getEntityManager().clear();
	    Query query = HibernateUtil.getEntityManager().createQuery("SELECT family FROM Family family ", Family.class);
	    List<Family> result = query.getResultList();
	    HibernateUtil.shutdown();
	    return result;
	}
	
	@Transactional
	public List<Family> getFamilyByBirthDateChild(String dateChild) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
		String dateString = dateChild ; 
		Date dates = sdf.parse(dateString);
	    HibernateUtil.initManager();
	    TypedQuery<Family> query = HibernateUtil.getEntityManager().createQuery("SELECT family FROM Family family INNER JOIN family.childList ef WHERE ef.birthDate = :birthdate ",Family.class);
	    query.setParameter("birthdate",dates);
	    List<Family> result = query.getResultList();
	    HibernateUtil.shutdown();
	    return result;
	}
	
	@Transactional
	public List<Family> getFamilyByPeselChild(String pesel){
	    HibernateUtil.initManager();
	    TypedQuery<Family> query = HibernateUtil.getEntityManager().createQuery("SELECT family FROM Family family INNER JOIN family.childList ef WHERE ef.pesel = :pesel ",Family.class);
	    query.setParameter("pesel",pesel);
	    List<Family> result = query.getResultList();
	    HibernateUtil.shutdown();
	    return result;
	}
	
	@Transactional
	public List<Family> getFamilyBySexChild(String sex){
	    HibernateUtil.initManager();
	    TypedQuery<Family> query = HibernateUtil.getEntityManager().createQuery("SELECT family FROM Family family INNER JOIN family.childList ef WHERE ef.sex = :sex ",Family.class);
	    query.setParameter("sex",sex);
	    List<Family> result = query.getResultList();
	    HibernateUtil.shutdown();
	    return result;
	}
	
	@Transactional
	public List<Family> getFamilyByNameChild(String firstName){
	    HibernateUtil.initManager();
	    TypedQuery<Family> query = HibernateUtil.getEntityManager().createQuery("SELECT family FROM Family family INNER JOIN family.childList ef WHERE ef.firstName = :firstName ",Family.class);
	    query.setParameter("firstName",firstName);
	    List<Family> result = query.getResultList();
	    HibernateUtil.shutdown();
	    return result;
	}
	
	@Transactional
	public List<Family> getFamilyBySecondNameChild(String secondName){
	    HibernateUtil.initManager();
	    TypedQuery<Family> query = HibernateUtil.getEntityManager().createQuery("SELECT family FROM Family family INNER JOIN family.childList ef WHERE ef.secondName = :secondName ",Family.class);
	    query.setParameter("secondName",secondName);
	    List<Family> result = query.getResultList();
	    HibernateUtil.shutdown();
	    return result;
	}
}
