package com.hexaware.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
@Id
int Roll;
String Name;
Double Fee;
public int getRoll() {
	return Roll;
}
public void setRoll(int roll) {
	Roll = roll;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Double getFee() {
	return Fee;
}
public void setFee(Double fee) {
	Fee = fee;
}
public Student(int roll, String name, Double fee) {
	super();
	Roll = roll;
	Name = name;
	Fee = fee;
}
public Student() {
	super();
}
@Override
public String toString() {
	return "Student [Roll=" + Roll + ", Name=" + Name + ", Fee=" + Fee + "]";
}

}
