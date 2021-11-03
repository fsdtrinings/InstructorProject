package com.mkj.test.SpringRESTHibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkj.test.SpringRESTHibernate.dto.Instructor;

public interface InstructorRepository extends 
	JpaRepository<Instructor, Integer>, 
	CustomInstructorRepository
{
  /*
   * 1) All JPA Methods
   * 2) All Custom Instructor 
   * */
}
