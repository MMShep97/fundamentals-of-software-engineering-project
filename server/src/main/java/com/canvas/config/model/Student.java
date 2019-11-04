package com.canvas.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Student")
public class Student {
	//	StudentID int primary key not null,
//	FirstName varchar(50),
//	LastName varchar(50),
//	AccountID int not null,
//	CourseID int,
//	QuizID int,
//	CertificateID int,
//	foreign key (AccountID) references Account(AccountID) on update cascade on delete cascade,
//	foreign key (CourseID) references Course(CourseID) on update cascade on delete cascade,
//	foreign key (QuizID) references Quiz(QuizID) on update cascade on delete cascade,
//	foreign key (CertificateID) references Certificate(CertificateID) on update cascade on delete cascade
//	);
	@NotNull
	@GeneratedValue
	@Id
	@Column(name = "StudentID")
	private Long studentId;
	@NotNull
	@Column(name = "First")
	private String firstName;
	@NotNull
	@Column(name = "Last")
	private String lastName;
	@NotNull
	@OneToOne
	@JoinColumn(name = "AccountID")
	private Account account;
//	@NotNull
//	@Column(name = "AccountID")
//	private Long accountId;
	
	@NotNull
	@Column(name = "CourseID")
	private int courseId;
	@NotNull
	@Column(name = "QuizID")
	private int quizId;
	@NotNull
	@Column(name = "CertificateID")
	private int certificateId;
	
	public Student() {
		super();
	}
		
	public Student(@NotNull Long studentId, @NotNull String firstName, @NotNull String lastName,
			@NotNull int courseId, @NotNull int quizId, @NotNull int certificateId, @NotNull Account account) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.account = account;
		this.courseId = courseId;
		this.quizId = quizId;
		this.certificateId = certificateId;
		//this.account.setStudent(this);
		
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public int getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
//	public void setAccount(Account account) {
//		this.account = account;
//	}
//	public Account getAccount() {
//		return account;
//	}
	

}
