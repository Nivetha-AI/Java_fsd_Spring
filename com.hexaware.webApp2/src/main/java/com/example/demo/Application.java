package com.example.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.Entities.User;
import com.example.demo.UserRepo.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		UserRepository rep = context.getBean(UserRepository.class);
		// to add values
//		User user1 = new User();
//		user1.setUserId(200);
//		user1.setName("Pooja");
//		user1.setFee(7000.9);
//		rep.save(user1);
		// read from back end
//		Iterable<User> users=rep.findAll();
//		users.forEach((t)->System.out.println(t.toString()));
//		to delete
		// rep.deleteById(100);
//		Optional<User> u=rep.findById(200);
//		System.out.println(u);
//		if(u.isPresent()) {
//			rep.deleteById(200);
//		}
//		else {
//			System.out.println("Not Found");
//		}
//		
// update
		Optional<User> u=rep.findById(100);
		if(u.isPresent()) {
		     User temp=u.get();
		     temp.setName("Nivetha");
		     rep.save(temp);
		}
		else {
			System.out.println("Not found");
		}
	}

}
