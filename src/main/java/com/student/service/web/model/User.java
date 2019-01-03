package com.student.service.web.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "users")
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @NotBlank
    @Column
    private String email;

    @NotBlank
    @Column
    private String name;

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

    public User(String email, String name, String lastname, String password, String education, int schoolId, String department, String specialization, BigDecimal rateAvg) {
        this.email = email;
        this.name = name;
        this.last_name = lastname;
        this.password = password;
        this.education = education;
        this.schoolId = schoolId;
        this.department = department;
        this.specialization = specialization;
        this.rateAvg = rateAvg;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return last_name;
    }

    public void setLastname(String lastname) {
        this.last_name = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", education='" + education + '\'' +
                ", schoolId=" + schoolId +
                ", department='" + department + '\'' +
                ", specialization='" + specialization + '\'' +
                ", rateAvg=" + rateAvg +
                '}';
    }
}
