package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
 @GetMapping("/laptops")
 public String laptops() {
	 return "laptops";
 }
 
 @GetMapping("/marketing")
 public String marketing() {
	 return "marketing";
 }
 @GetMapping("/sales")
 public String sales() {
	 return "sales";
 }
 @GetMapping("/tvsales")
 public String tvsales() {
	 return "tvsales";
 }
 
}
