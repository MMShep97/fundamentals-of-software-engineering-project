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
student_id varchar(120),
foreign key (instructor_id) references instructor(instructor_id) on update cascade on delete cascade,
foreign key (course_id) references course(course_id) on update cascade on delete cascade,
foreign key (student_id) references student(student_id) on update cascade on delete cascade);

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
foreign key (quiz_id) references quiz(quiz_id) on update cascade on delete cascade,
primary key(quiz_id , course_id , instructor_id , student_id)
);
create table EDU.studentCourse(
course_id varchar(100),
student_id varchar(100),
foreign key (course_id) references course(Course_id) on update cascade on delete cascade,
foreign key (student_id) references student(student_id) on update cascade on delete cascade,
primary key(course_id, student_id)
);


drop table EDU.course;
use EDU;
select * from student;
select * from instructor;
select * from course;
select * from quiz;
select * from grade;
insert into course values('cs120' , 'agco' , 'database');
select * from account;
insert into instructor values('agcom' , 'a' , 's' , 'as' , 'a');
insert into quiz values('quiz1' , 'cs12' , 'database1' , '10' , '10-11-12', 'agco');
insert into grade values('quiz1' ,'cs12' , 'agco' , 4, 4 ,'12xyz' );  
delete from grade where id = '1';    
insert into student_course values('cs12' , '12xyz');
select * from student_course;
SELECT
        c.course_id,
        course_name,
        instructor_id
    FROM
        course c 
    INNER JOIN
        student_course s 
            ON c.course_id = s.course_id 
    WHERE
        s.student_id = "12xyz";
        
DROP table grade;
insert into student_course values('cs120','12xyz' );
Alter table grade DROP COLUMN student_id;
ALTER TABLE grade
ADD FOREIGN KEY (student_id) REFERENCES student_course(student_id);
desc student;
select * from administrator;
insert into grade values('quiz1','cs12','agco','12xyz','7','1');
insert into administrator values('abc','abc','abc','abc','abc');

