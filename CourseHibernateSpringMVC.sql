CREATE DATABASE CourseHibernateSpringMVC;

USE CourseHibernateSpringMVC;

CREATE TABLE Customer (
	id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(45),
    lastName VARCHAR(45),
	email VARCHAR(45)
);