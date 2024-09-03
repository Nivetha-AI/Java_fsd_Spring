package com.example.demo.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

//	@GetMapping("/home")
//	public String home() {
//		return "home";
//	}
//	@GetMapping("/contact")
//	public String contact() {
//		return "contact";
//	}
	
	List <String> users=new ArrayList<>();
	
	MainController(){
		users.add("ajay");
		users.add("kavitha");
		users.add("deepa");
		users.add("Pooja");
	}
	
	@GetMapping("/getData")
	public List<String> getData(){
		return (users);
	}
	
	@PostMapping("/saveData")
	public String saveData(@RequestParam String name) {
		users.add(name);
		return "save data";
	}
	@DeleteMapping("/removeData/{name}")
	public String removeData(@PathVariable String name) {
		users.remove(name);
		return "Removed";
	}
	@PutMapping("/updateName/{pos}")
	public String updateName( @PathVariable int pos ,@RequestParam  String nNm) {
		users.set(pos, nNm);
		return "updated";
	}
}
