package com.hexaware.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.app.Dao.RepStudent;
import com.hexaware.app.Entity.Student;

@Service
public class StudentService {
	@Autowired
   RepStudent RepSt;

	public Student saveSt(Student s) {
		Student s2=RepSt.save(s);
		return s2;
	}

	public List<Student> getStuds() {
		List<Student> l=(List)RepSt.findAll();
		return l;
	}



	public Student removeStuds(int rno) {
	Student s=	RepSt.findById(rno).orElse(null);
		if(s==null) {
			return null;
		}
		else {
			RepSt.delete(s);
		}
		return s;
	}

	

	public String updateStuds(int rno, String nNM) {
		Student s=	RepSt.findById(rno).orElse(null);
		if(s==null) {
			return "not found";
		}
		else {
			s.setName(nNM);
			RepSt.save(s);
			return "updated";
		}
		

	}

	public String getRoll(int rno) {
		Student s=	RepSt.findById(rno).orElse(null);
		if(s==null) {
			return "not found";
		}
		else {
			
			return s.getName();
		}
		
	}
}
