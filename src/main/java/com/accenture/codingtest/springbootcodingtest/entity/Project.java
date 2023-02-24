package com.accenture.codingtest.springbootcodingtest.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {
	@Id
	private UUID id;
	private String name;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
