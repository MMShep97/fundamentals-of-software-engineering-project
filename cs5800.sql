drop database EDUCADIA;
CREATE database EDUCADIA;

CREATE TABLE EDUCADIA.Account(
AccountID int PRIMARY KEY NOT NULL,
Category varchar(50) not null,
Username varchar(50) not null,
Password varchar (50) not null
);


CREATE TABLE EDUCADIA.Instructor(
InstructorID int primary key not null,
FirstName varchar(50),
LastName varchar(50),
AccountID int,
foreign key (AccountID) references Account(AccountID) on update cascade on delete cascade
);

create table EDUCADIA.Course(
CourseID int primary key not null,
CourseName varchar(100),
InstructorID int,
foreign key (InstructorID) references Instructor(InstructorID) on update cascade on delete cascade
);

Create Table EDUCADIA.Content(
ContentName varchar (50),
ContentID int primary key not null,
Description varchar (200),
CourseID int,
InstructorID int,
foreign key (CourseID) references Course(CourseID) on update cascade on delete cascade,
foreign key (InstructorID) references Instructor(InstructorID) on update cascade on delete cascade

);


Create table EDUCADIA.Quiz(
QuizID int primary key not null,
QuizDescription varchar(100),
CourseID int,
ContentID int,
QuizGrade int,
InstructorID int,
foreign key (CourseID) references Course(CourseID) on update cascade on delete cascade,
foreign key (ContentID) references Content(ContentID) on update cascade on delete cascade,
foreign key (InstructorID) references Instructor(InstructorID) on update cascade on delete cascade
);


create table EDUCADIA.Certificate(
CertificateID int primary key not null,
Description varchar(200),
CourseID int,
foreign key (CourseID) references Course(CourseID) on update cascade on delete cascade
);


CREATE TABLE EDUCADIA.Student (
StudentID int primary key not null,
FirstName varchar(50),
LastName varchar(50),
AccountID int not null,
CourseID int,
QuizID int,
CertificateID int,
foreign key (AccountID) references Account(AccountID) on update cascade on delete cascade,
foreign key (CourseID) references Course(CourseID) on update cascade on delete cascade,
foreign key (QuizID) references Quiz(QuizID) on update cascade on delete cascade,
foreign key (CertificateID) references Certificate(CertificateID) on update cascade on delete cascade
);

create Table EDUCADIA.Administrator(
AdminID int primary key not null,
FirstName varchar (50),
LastName varchar(50),
AccountID int,
foreign key (AccountID) references Account(AccountID) on update cascade on delete cascade
);

create table EDUCADIA.Support (
SupportID int primary key not null,
RequestorID int,
AdminID int,
Description varchar(200),
SupportStatus ENUM ('open','in progress', 'completed'),
foreign key (AdminID) references Administrator(AdminID) on update cascade on delete cascade,
foreign key (RequestorID) references Account(AccountID) on update cascade on delete cascade
);


Create table EDUCADIA.Feedback (
FeedBackID int primary key not null,
Description varchar(200),
InstructorID int,
StudentID int,
foreign key (InstructorID) references Instructor(InstructorID) on update cascade on delete cascade,
foreign key (StudentID) references Student(StudentID) on update cascade on delete cascade
);