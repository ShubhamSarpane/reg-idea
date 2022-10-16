package com.Ideation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Idea {
	
	@Id
	@Column(unique = true)
	private String idea_title;
	
	private int employeeid;
	
	private String link;
	
	private String technology;
	
	private String idea_details;
	
	
	
	
	
	
	

	public Idea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Idea(String idea_title, int employeeid, String link, String technology, String idea_details) {
		super();
		this.idea_title = idea_title;
		this.employeeid = employeeid;
		this.link = link;
		this.technology = technology;
		this.idea_details = idea_details;
	}

	public String getIdea_title() {
		return idea_title;
	}

	public void setIdea_title(String idea_title) {
		this.idea_title = idea_title;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getIdea_details() {
		return idea_details;
	}

	public void setIdea_details(String idea_details) {
		this.idea_details = idea_details;
	}

	@Override
	public String toString() {
		return "Idea [idea_title=" + idea_title + ", employeeid=" + employeeid + ", link=" + link + ", technology="
				+ technology + ", idea_details=" + idea_details + "]";
	}
	
	

	
	
	

}

