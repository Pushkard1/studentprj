package com.example.StudentPrj.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
public class Student {
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message="First Name Required")
	
	private String fname;
	@NotBlank(message="Last Name Required")
	private String lname;
	@NotBlank(message="Mobile Number Required")
	private String mobno;
	@NotBlank(message="Password  Required")
	private String password;
	
	@Column(unique = true)
	@NotBlank(message="Email Required")
	private String email;
	private String role;
	private String imgUrl;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Project> projects = new ArrayList<>();
	
	public Student(int id, String fname, String lname, String mobno, String email, String imgUrl,
			List<Project> projects) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.mobno = mobno;
		this.email = email;
		this.imgUrl = imgUrl;
		this.projects = projects;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public Student(int id, @NotBlank(message = "First Name Required") String fname,
			@NotBlank(message = "Last Name Required") String lname,
			@NotBlank(message = "Mobile Number Required") String mobno,
			@NotBlank(message = "Email Required") String email, String role, String imgUrl, List<Project> projects) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.mobno = mobno;
		this.email = email;
		this.role = role;
		this.imgUrl = imgUrl;
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", mobno=" + mobno + ", email=" + email
				+ ", imgUrl=" + imgUrl + ", projects=" + projects + "]";
	}
	
	
	
}
