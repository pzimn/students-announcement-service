package com.student.service.web.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_MODERATOR = "ROLE_MODERATOR";
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    public Integer getId() {
		return id;
	}

	@NotBlank
    @Column
    private String email;

    @NotBlank
    @Column(name="name")
    private String username;

    @NotBlank
    @Column
    private String last_name;

    @NotBlank
    @Column
    private String password;

    @NotBlank
    @Column
    private String education;


    @Column(name = "school_id")
    private int schoolId;

    @Column
    private String department;

    @Column
    private String specialization;

    @Column(name = "rate_avg")
    private BigDecimal rateAvg;
    
    @Column
	private String role = ROLE_USER;

    public User() {
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public BigDecimal getRateAvg() {
		return rateAvg;
	}

	public void setRateAvg(BigDecimal rateAvg) {
		this.rateAvg = rateAvg;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
