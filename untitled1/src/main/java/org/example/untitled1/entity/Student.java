package org.example.untitled1.entity;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@XmlRootElement
@AllArgsConstructor
@Entity
@Table(name = "Student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sq")
    @SequenceGenerator(name = "student_sq", sequenceName = "student_sq", allocationSize = 1)
    @Column(name = "Id")
    private int Id;
    @Column(name = "Fullname")
    private String Fullname;
    @Column(name = "Birthday")
    private Date Birthday;
    @Column(name = "Classname")
    private String Classname;
    @Column(name = "Major")
    private String Major;
    @Column(name = "Hometown")
    private String Hometown;
    @Column(name = "Gender")
    private String Gender;
    @Column(name = "Averagemark")
    Double Averagemark;
//	public int getId() {
//		return Id;
//	}
//	public void setId(int id) {
//		Id = id;
//	}
//	public String getFullname() {
//		return Fullname;
//	}
//	public void setFullname(String fullname) {
//		Fullname = fullname;
//	}
//	public Date getBirthday() {
//		return Birthday;
//	}
//	public void setBirthday(Date birthday) {
//		Birthday = birthday;
//	}
//	public String getClassname() {
//		return Classname;
//	}
//	public void setClassname(String classname) {
//		Classname = classname;
//	}
//	public String getMajor() {
//		return Major;
//	}
//	public void setMajor(String major) {
//		Major = major;
//	}
//	public String getHometown() {
//		return Hometown;
//	}
//	public void setHometown(String hometown) {
//		Hometown = hometown;
//	}
//	public String getGender() {
//		return Gender;
//	}
//	public void setGender(String gender) {
//		Gender = gender;
//	}
//	public Double getAveragemark() {
//		return Averagemark;
//	}
//	public void setAveragemark(Double averagemark) {
//		Averagemark = averagemark;
//	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}