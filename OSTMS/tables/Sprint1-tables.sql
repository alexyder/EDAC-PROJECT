create database project;
use project;
show tables;
drop table tlogin;

############################################ TEST TABLES ############################################

create table test1 ( memberid int primary key, membername varchar(20) );
insert into test1 values (1,"anshul");
insert into test1 values (2,"trupti");
insert into test1 values (3,"arun");
insert into test1 values (4,"avinash");
select * from test1;

############################################ STUDENT LOGIN ############################################
-- DAC --
drop table stlogindac;
create table stlogindac ( prn int primary key auto_increment , fullname varchar(50) , pwd varchar(8) );
insert into stlogindac values(1010520001 , "Anshul Kumar Shakya" , "anshul66" );
insert into stlogindac (fullname,pwd) values("Arun Kishore Gupta" , "arun2020" );
insert into stlogindac (fullname,pwd) values("Avinash Kumar" , "avinash2" );
insert into stlogindac (fullname,pwd) values("Pol Trupti Sudhir" , "trupti09" );
select * from stlogindac;
-- DBDA -- 
drop table stlogindbda;
create table stlogindbda ( prn int primary key auto_increment , fullname varchar(50) , pwd varchar(8) ); 
insert into stlogindbda values(1020520001 , "Mayank Pathak" , "mayank66" );
insert into stlogindbda (fullname,pwd) values("Manisha Sharma" , "manisha2" );
insert into stlogindbda (fullname,pwd) values("Himanshu Yadav" , "himanshu" );
insert into stlogindbda (fullname,pwd) values("Sharad Shukla" , "sharad22" );
select * from stlogindbda;
-- AI --
drop table stloginai;
create table stloginai ( prn int primary key auto_increment , fullname varchar(50) , pwd varchar(8) );
insert into stloginai values(1030520001 , "Shruti Singh" , "shruti66" );
insert into stloginai (fullname,pwd) values("Raghav kumar" , "raghav22" );
insert into stloginai (fullname,pwd) values("Monika Verma" , "monika22" );
insert into stloginai (fullname,pwd) values("Jinal Thoure" , "jinal222" );
select * from stloginai;

############################################ STUDENT REGISTERATION ############################################
drop table sturegister;
create table sturegister ( prn int primary key , gender varchar(6) , dob varchar(20) , phone long , email varchar(50),
		address blob , city varchar(20) , state varchar(20) , country varchar(10) , course varchar(10) , batch varchar(20) );
 
insert into sturegister values(1010520001,"male","24",7000314145,"anshul@gmail.com","x","Rajnandgaon","chhattisgarh","India","DAC","Sept");
insert into sturegister values(1020520001,"female","24",1234569889,"xyz@gmail.com","x","Bhilai","chhattisgarh","India","DBDA","Sept");

select * from sturegister;
delete from sturegister where prn<100;

############################################ TEACHER LOGIN ############################################

drop table teacherlogin;
create table teacherlogin ( tid int primary key auto_increment , fullname varchar(50) , pwd varchar(8) );
insert into teacherlogin values(101 , "Vasu Srinivas" , "vasu2222" );
insert into teacherlogin (fullname,pwd) values("Shanmugnathan" , "shan2222" ); 
insert into teacherlogin (fullname,pwd) values("Binu George" , "binu2222" );
insert into teacherlogin (fullname,pwd) values("Divya MG" , "xyz" );
insert into teacherlogin (fullname,pwd) values("Karuna Prasad" , "xyz" );
insert into teacherlogin (fullname,pwd) values("B. Arunachalam" , "xyz" );
insert into teacherlogin (fullname,pwd) values("Santhosh J." , "xyz" );
insert into teacherlogin (fullname,pwd) values("Srikant" , "xyz" );
insert into teacherlogin (fullname,pwd) values("Gopinath" , "xyz" );
insert into teacherlogin (fullname,pwd) values("Soham Chakarborthy" , "xyz" );
select * from teacherlogin;

############################################ TEACHER-REGISTERATION ############################################

drop table teacherregister;
create table teacherregister (tid int primary key, gender varchar(6) , phone long , email varchar(50) , yoe double , desig varchar(20));
insert into teacherregister values(101 , "male" , 4444444444 , "abc@gmail.com" , 15 ,"Teacher");
insert into teacherregister values(102 , "male" , 8888888888 , "xyz@gmail.com" , 15 ,"Teacher");
insert into teacherregister values(103 , "female" , 8888888888 , "xyz@gmail.com" , 15 ,"Coordinator");
insert into teacherregister values(104 , "female" , 8888888888 , "xyz@gmail.com" , 15 ,"Teacher");
insert into teacherregister values(105 , "female" , 8888888888 , "xyz@gmail.com" , 15 ,"Teacher");
insert into teacherregister values(106 , "male" , 8888888888 , "xyz@gmail.com" , 15 ,"Teacher");
insert into teacherregister values(107 , "male" , 8888888888 , "xyz@gmail.com" , 15 ,"Teacher");
insert into teacherregister values(108 , "male" , 8888888888 , "xyz@gmail.com" , 15 ,"Teacher");
insert into teacherregister values(109 , "male" , 8888888888 , "xyz@gmail.com" , 15 ,"Teacher");
insert into teacherregister values(110 , "male" , 8888888888 , "xyz@gmail.com" , 15 ,"Lab-Assistant");
select * from teacherregister;

delete from teacherregister where tid>20;

############################################ COURSES ############################################

drop table courses;
create table courses ( cid int primary key auto_increment, cname varchar(10) );
insert into courses values(101 , "DAC" );
insert into courses (cname) values("DBDA" );
insert into courses (cname) values("AI" );
select * from courses;

############################################ NOTIFICATIONS ############################################

-- datetime format =>  'YYYY-MM-DD'
drop table gnoti;
create table gnoti (id int auto_increment primary key , uptime varchar(20) , msg blob not null);
insert into gnoti values(1,"2021-03-12","Welcome to Cdac Portal");
insert into gnoti (uptime,msg) values('2021-03-12',"Student Details Updated");
select * from gnoti;
delete from gnoti;

############################################ QUERIES ############################################

-- multiple columns as primary key =>  primary key (prn,module)
drop table queries;
create table queries (qid int primary key auto_increment,prn int, module varchar(255) , que blob not null, reply blob);
insert into queries values(1, 1010520001 , "m2" , "what is my name" , "your name is anshul");
insert into queries (prn,module,que,reply) values( 1010520001 , "m2" , "what is my age" , "your age is 1000 years");
insert into queries (prn,module,que,reply) values( 1030520002 , "m1" , "what is my age" , "your age is 1000 years");
select * from queries;
delete from queries;

############################################ COURSE NOTIFICATIONS ############################################

-- datetime format =>  'YYYY-MM-DD'
drop table cnoti;
create table cnoti (id int auto_increment primary key , uptime varchar(20) ,course varchar(20), msg blob not null);
insert into cnoti values(1,"2021-03-12","DAC","Welcome to Cdac Portal");
insert into cnoti (uptime,course,msg) values('2021-03-12',"DBDA","Student Details Updated");
select * from cnoti;

############################################ UPLOAD/DOWNLOAD - COURSE MATERIAL ############################################

drop table myfiles;
create table myfiles (id int auto_increment primary key , filename varchar(255) , filetype varchar(255), data longblob , course varchar(10));
select * from myfiles;
delete from myfiles;
SHOW VARIABLES LIKE 'max_allowed_packet';
-- # max_allowed_packet=1073741824 max_allowed_packet=1G ==> setting this in my.ini file

############################################ UPLOAD/DOWNLOAD - ASSIGNMENTS ############################################

create table myfiles (id varchar(255) not null primary key , data longblob , file_name varchar(255) , 
file_type varchar(255) , msg varchar(255) , course varchar(255) , subject varchar(255));