create database EDU;
create table EDU.instructor(
instructor_id varchar(120) PRIMARY KEY not null,
username varchar(100),
password varchar(30)
);

create table EDU.course(
course_id varchar(100) primary key not null,
instructor_id varchar(120),
course_name varchar(150),
foreign key (instructor_id) references instructor(instructor_id) on update cascade on delete cascade);
create table EDU.course_taken(
course_id varchar(100),
instructor_id varchar(120),
student_id varchar(120));
create table EDU.quiz(
quiz_id varchar(100) primary key not null,
course_id varchar(100),
quiz_name varchar(50),
quiz_point int4,
quiz_date datetime,
instructor_id varchar(120),
foreign key (instructor_id) references instructor(instructor_id) on update cascade on delete cascade,
foreign key (course_id) references course(course_id) on update cascade on delete cascade
);

create table EDU.grade(
quiz_id varchar(100),
course_id varchar(100),
instructor_id varchar(100),
student_id varchar(150),
grade_points int4,
foreign key (instructor_id) references instructor(instructor_id) on update cascade on delete cascade,
foreign key (course_id) references course(course_id) on update cascade on delete cascade,
foreign key (student_id) references student(student_id) on update cascade on delete cascade,
foreign key (quiz_id) references quiz(quiz_id) on update cascade on delete cascade
);

drop table EDU.course;
use EDU;
select * from student;
select * from instructor;
select * from account;
insert into instructor values('agcom' , 'a' , 's' , 'as' , 'a');