package com.example.Family.Repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Family.Entities.Child;
import com.example.Family.Utils.HibernateUtil;

@Transactional
@Component
public class ChildRepository {

	@Transactional
	public List<Child> findAllChild() {
	    // TODO Auto-generated method stub
	    HibernateUtil.initManager();
	    HibernateUtil.getEntityManager().clear();
	    Query query = HibernateUtil.getEntityManager().createQuery("SELECT child FROM Child child ", Child.class);
	    List<Child> result = query.getResultList();
	    HibernateUtil.shutdown();
	    return result;
	}
}
