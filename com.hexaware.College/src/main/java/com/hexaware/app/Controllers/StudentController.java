package com.hexaware.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.hexaware.app.Entity.Student;
import com.hexaware.app.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
    StudentService studSer;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student s) {
		Student s2=studSer.saveSt(s);
		return s2;
	}
	@GetMapping("/getStudents")
	public List <Student> getStudent(){
		List<Student> users= studSer.getStuds();
		return users;
	}
	@DeleteMapping("/removeStudent/{rno}")
	public Student removeStudent(@PathVariable int rno) {
		Student s2=studSer.removeStuds(rno);
		return s2;
	}
	@PutMapping("/updateName/{rno}/{nNM}")
	public String updateName(@PathVariable int rno ,@PathVariable  String nNM) {
		String r=studSer.updateStuds(rno,nNM);
		return r;
	}
	// find by roll no 
	@GetMapping("/getrollno/{rno}")
	public String getRollno(@PathVariable int rno) {
		String r=studSer.getRoll(rno);
		return r;
	}
}
