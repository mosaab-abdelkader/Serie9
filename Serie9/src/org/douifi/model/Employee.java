package org.douifi.model;


import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {

	
	String firstName;
	String lastName ;
	int age ;
	int salary;
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, int age, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return " " + firstName + ", " + lastName + ", " + age + ", " + salary
				;
	}

	
	

	
}

