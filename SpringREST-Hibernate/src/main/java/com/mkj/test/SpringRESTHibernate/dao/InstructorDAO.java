package com.mkj.test.SpringRESTHibernate.dao;

import java.util.List;

import com.mkj.test.SpringRESTHibernate.dto.Instructor;

public interface InstructorDAO {
	
	public List<String> getAllInstructorsName();
	public List<Instructor> getAllInstructorsInfo();
	
	public String insertInstructor(Instructor instructor);
	
	// ------ For Aprajit ----
	public Instructor getInstructorById(int id);
	public List<Instructor> getAllInstructorsByLocation(String location);
	
	public String deleteInstructorById(int id);
	
	// ...../trainer/7/auckland
	public Instructor updateInstructorLocationById(int id,String newLocation);
	//  return updated instructor with new values
	
	
}
