package com.simple.myapp;

public class Patient {
	int id;
	String name;
	String phone;
	String gender;
	String city;
	
	public Patient()
	{
		//default constructor
	}
	public Patient(int id, String name, String phone, String gender, String city) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.city = city;
	}
	public Patient(String name, String phone, String gender, String city) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.city= city;
		System.out.println("In patient class");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", gender=" + gender + "]";
	}
	
}
