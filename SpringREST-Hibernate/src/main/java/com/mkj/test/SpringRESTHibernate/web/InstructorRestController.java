package com.mkj.test.SpringRESTHibernate.web;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mkj.test.SpringRESTHibernate.dao.InstructorDAO;
import com.mkj.test.SpringRESTHibernate.dto.Instructor;
import com.mkj.test.SpringRESTHibernate.execption.InstructorNotFoundException;
import com.mkj.test.SpringRESTHibernate.service.InstructorService;

@RestController
@CrossOrigin(origins = {"http://localhost:9001", "http://localhost:4200"},allowedHeaders = "*")
public class InstructorRestController {

	@Autowired          // Approach based on Hibernate
	private InstructorDAO dao;  // constructor injection
	
	@Autowired			// Apprach based on Spring JPA Data
	private InstructorService insService;
	
	
	public InstructorRestController() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(" Rest Controller Constructor ");
	}
	
	
	@GetMapping("/jpa/trainers")
	public List<Instructor> getAllInstructorsThroughJPAData()
	{
		return insService.getAllInstructors();
	}
	
	@GetMapping("/jpa/trainers/exp")
	public List<Instructor> getAllInstructorsThroughJPAData2()
	{
		return insService.getAllInstructorsbyExp();
	}
	
	@GetMapping("/jpa/trainers/location/{location}")
	public List<Instructor> getAllInstructorsThroughJPAData3(@PathVariable String location)
	{
		return insService.getAllInstructorsbyLocation(location); // this is the method from custom repo.
	}
	
	@GetMapping("/jpa/trainer/{id}")
	public Instructor getAllInstructorsInfoByJPARepo(@PathVariable int id)
	{
		Instructor instructor =  insService.getInstructorById(id);
		if(instructor != null) return instructor;
		else throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Instructor assigned to Instructor Code "+id);
		
	}
	
	
	@PostMapping("/jpa/trainer")
	//@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON)
	//@RequestMapping(method = RequestMethod.POST, value = "/jpa/trainer",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String saveInstructor(@RequestBody Instructor instructor)
	{
		System.out.println(" --->> "+instructor+" :- "+LocalTime.now());
		String msg = dao.insertInstructor(instructor);
		return msg;
	}
	
	
	@PutMapping("/jpa/trainer/{id}/location/{newlocation}")
	public ResponseEntity<Instructor> updateLocation(@PathVariable int id,@PathVariable String newlocation)
	{
		Instructor updatedInstructor = insService.updateInstructor(id, newlocation);
		System.out.println(" ----->> Inside updateLocation "+updatedInstructor);
		return ResponseEntity.ok(updatedInstructor);
	}
	
	
	
	@GetMapping("/root")
	public String root()
	{
		System.out.println(" --- inside root()");
		return "x=10 , y = 20";
	}
	
	@GetMapping("/trainers")
	public List<String> getAllInstructors()
	{
		// fetch all instructors from database
		// call dao to access Liust<String>
		
		// convert into json/xml / any ther business supported format
	
		//return List of trainers
		
		//return Arrays.asList("ashish","aprajit","gaurav");
		
		return dao.getAllInstructorsName();
	}
	
	
	@GetMapping("/trainers/info")
	public List<Instructor> getAllInstructorsInfo()
	{
		// fetch all instructors from database
		// call dao to access Liust<String>
		
		// convert into json/xml / any ther business supported format
	
		//return List of trainers
		
		return dao.getAllInstructorsInfo();
		
	}
	
	@GetMapping("/trainer/{id}")
	public Instructor getAllInstructorsInfo(@PathVariable int id)throws InstructorNotFoundException
	{
		return dao.getInstructorById(id);
		
	}
	
	

	
	
}//end class



















