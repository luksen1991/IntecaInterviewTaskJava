package com.example.Family.Repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.example.Family.Entities.Child;
import com.example.Family.Entities.Father;
import com.example.Family.Utils.HibernateUtil;

@Transactional
@Component
public class FatherRepository {

	@Transactional
	public List<Father> findAllFathers() {
	    // TODO Auto-generated method stub
	    HibernateUtil.initManager();
	    HibernateUtil.getEntityManager().clear();
	    Query query = HibernateUtil.getEntityManager().createQuery("SELECT father FROM Father father ", Father.class);
	    List<Father> result = query.getResultList();
	    HibernateUtil.shutdown();
	    return result;
	}
}
