drop database EDU;
CREATE database EDU;

CREATE TABLE EDU.instructor(
instructor_id varchar(120) primary key not null,
firstName varchar(100),
lastName varchar(100),
userName varchar(100),
password varchar(30)
);

CREATE TABLE EDU.Student (
Student_id varchar(100) primary key not null,
FirstName varchar(100),
LastName varchar(100),
username varchar(100),
password varchar(30)
);


create table EDU.course(
course_id varchar(100) primary key not null,
instructor_id varchar(120),
course_name varchar(100),
foreign key (instructor_id) references instructor(instructor_id) on update cascade on delete cascade
);

create table EDU.studentCourse(
course_id varchar(100),
student_id varchar(100),
foreign key (course_id) references course(Course_id) on update cascade on delete cascade,
foreign key (student_id) references student(student_id) on update cascade on delete cascade,
primary key(course_id, student_id)
);

Create Table EDU.content(
content_id varchar(100) primary key not null,
contentName varchar (50),
Description varchar (200),
course_id varchar(100),
instructor_id varchar(120),
foreign key (course_id) references course(Course_id) on update cascade on delete cascade,
foreign key (instructor_id) references instructor(instructor_id) on update cascade on delete cascade
);


Create table EDU.quiz(
quiz_id varchar(100) primary key not null,
course_id varchar(100),
instructor_id varchar(120),
quiz_date datetime,
foreign key (course_id) references course(Course_id) on update cascade on delete cascade,
foreign key (instructor_id) references instructor(instructor_id) on update cascade on delete cascade
);


create table EDU.grades(
quiz_id varchar (100),
student_id varchar (100),
grade int, 
foreign key (quiz_id) references quiz(quiz_id) on update cascade on delete cascade,
foreign key (student_id) references student(student_id) on update cascade on delete cascade,
primary key (quiz_id, student_id) 
);

create table EDU.Certificate(
Certificate_id varchar(100) primary key not null,
Description varchar(200),
Course_id varchar(100),
student_id varchar(100),
foreign key (course_id) references course(course_id) on update cascade on delete cascade,
foreign key (student_id) references student(student_id) on update cascade on delete cascade
);








