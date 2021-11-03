package com.mkj.test.SpringRESTHibernate.dao;

import java.util.List;
//   JPA (Java Persistence API
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkj.test.SpringRESTHibernate.dto.Instructor;

@Repository
public class InstructorDAOImpl implements InstructorDAO{

	@Autowired
	EntityManager entityManager; // Spring boot created and provide to us
	// jpa manager 
	
	@Override
	@Transactional
	public List<String> getAllInstructorsName() {
	
		Session session = entityManager.unwrap(Session.class);// connection
		// JPQL :- same like SQL but for Java Developers
		
		Query<String> query = session.createQuery("select name from Instructor");
		// query fire over table
		
		return query.getResultList(); // convert result into List<String>
	}

	
	  @Override
	  
	  @Transactional public List<Instructor> getAllInstructorsInfo() 
	  {
		  Session  session = entityManager.unwrap(Session.class);
		  // connection // JPQL :- same
	   // like SQL but for Java Developers
	  
	  Query<Instructor> query =
	  session.createQuery("from Instructor",Instructor.class); 
	  // query fire over  table
	  
	  return query.getResultList(); // convert result into List<String>
	  
	  }
	 

	@Override
	@Transactional
	public String insertInstructor(Instructor instructor) {
		Session session = entityManager.unwrap(Session.class);// connection
		session.save(instructor);
		return instructor.getInstructorcode()+" is Saved" ;
	}

	@Override
	public Instructor getInstructorById(int id) {
		Session session = entityManager.unwrap(Session.class);// connection
		Query<Instructor> query = session.createQuery("from Instructor where id = "+id);
				return query.getSingleResult(); 
	}

	@Override
	public List<Instructor> getAllInstructorsByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteInstructorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instructor updateInstructorLocationById(int id, String newLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
}
