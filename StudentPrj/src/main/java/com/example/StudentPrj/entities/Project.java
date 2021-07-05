package com.example.StudentPrj.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="PROJECT")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projId;
	private String prjName;
	private String prjDuration;
	
	@ManyToOne
	private Student student;

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjDuration() {
		return prjDuration;
	}

	public void setPrjDuration(String prjDuration) {
		this.prjDuration = prjDuration;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projId, String prjName, String prjDuration, Student student) {
		super();
		this.projId = projId;
		this.prjName = prjName;
		this.prjDuration = prjDuration;
		this.student = student;
	}
	
}
