package com.mkj.test.SpringRESTHibernate.dao;

import java.util.List;

import com.mkj.test.SpringRESTHibernate.dto.Instructor;

public interface CustomInstructorRepository {

	public List<Instructor> getInstructorByLocation(String location);
}
