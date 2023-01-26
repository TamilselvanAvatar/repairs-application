drop database if exists  mydb ;
create database mydb;
use mydb;
create table customer(
	 customer_id int auto_increment primary key,
     customer_name varchar(20) not null,
     customer_phonenumber varchar(20)  not null,
     location varchar(20)  not null,
	 gender  varchar(20)  not null
);

create table technician(
	 idtechnician int auto_increment primary key,
     technician_name varchar(20) not null,
     technician_rating int  not null,
     services varchar(20)  not null,
	 location  varchar(20)  not null,
     technician_pay double not null,
     availability varchar(10) not null
);

-- Password is phonenumber here
insert into customer(customer_name,customer_phonenumber,location,gender) values ("admin","9874563210","Chennai","Male");
insert into customer(customer_name,customer_phonenumber,location,gender) values ("admin","9974563210","Chennai","Female");

insert into technician(technician_name,technician_rating,services,location,technician_pay,availability) values ("Raja"	,	9,	"Mechanic",		"Coimbatore",	1000,	"yes");
insert into technician(technician_name,technician_rating,services,location,technician_pay,availability) values ("Sriram",	10,	"Mechanic",		"Chennnai",		1500,	"yes");
insert into technician(technician_name,technician_rating,services,location,technician_pay,availability) values ("Robert",	7,	"Plumber",		"Erode", 		2000,	"yes");
insert into technician(technician_name,technician_rating,services,location,technician_pay,availability) values ("Kannan",	5,	"Plumber",		"Chennai",		1000,	"yes");
insert into technician(technician_name,technician_rating,services,location,technician_pay,availability) values ("Barathik",8,	"Electrician",	"Coimbatore",	3000,	"yes");
insert into technician(technician_name,technician_rating,services,location,technician_pay,availability) values ("Karthic",9,	"Electrician",	"Trichy",		4000,	"yes");
insert into technician(technician_name,technician_rating,services,location,technician_pay,availability) values ("Shila",	8,	"Carpenter",	"Chennai",		3500,	"yes");
insert into technician(technician_name,technician_rating,services,location,technician_pay,availability) values ("Roja",	9,		"Carpenter",	"Chennai",		4000,	"yes");
insert into technician(technician_name,technician_rating,services,location,technician_pay,availability) values ("Rhagul",	7,	"Electrician",	"Coimbatore",	3000,	"yes");
insert into technician(technician_name,technician_rating,services,location,technician_pay,availability) values ("Boobala",8,	"Plumber",		"Chennai",		2800,	"yes");