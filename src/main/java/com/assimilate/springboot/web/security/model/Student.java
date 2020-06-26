package com.assimilate.springboot.web.security.model;

public class Student {
	
	private String name;
	private String subject;
	private int id;
	private Integer marks;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", subject=" + subject + ", id=" + id + ", marks=" + marks + ", address="
				+ address + "]";
	}
	
	
	
	
	

}
