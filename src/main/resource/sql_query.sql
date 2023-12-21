drop schema employeemanagement;
create schema employeemanagement;
use employeemanagement;
drop table employees;
drop table departments;
CREATE TABLE employees (
    empno      INT             NOT NULL,  -- UNSIGNED AUTO_INCREMENT??
    birthdate  DATE            NOT NULL,
    firstname  VARCHAR(14)     NOT NULL,
    lastname   VARCHAR(16)     NOT NULL,
    gender      ENUM ('M','F')  NOT NULL,  -- Enumeration of either 'M' or 'F'  
    hiredate   DATE            NOT NULL,
    PRIMARY KEY (empno)                   
);

INSERT INTO employees (empNo, birthDate, firstName, lastName, gender, hireDate)
VALUES
(1, '1990-01-15', 'John', 'Doe', 'M', '2020-05-01'),
(2, '1985-07-22', 'Jane', 'Smith', 'F', '2019-08-10'),
(3, '1993-03-05', 'Bob', 'Johnson', 'M', '2022-02-18'),
(4, '1988-11-30', 'Alice', 'Williams', 'F', '2018-06-25'),
(5, '1995-09-12', 'Charlie', 'Brown', 'M', '2021-04-14'),
(6, '1987-04-03', 'Emily', 'Davis', 'F', '2017-11-08'),
(7, '1992-08-19', 'Michael', 'Miller', 'M', '2019-10-22'),
(8, '1998-02-28', 'Olivia', 'Johnson', 'F', '2020-12-05'),
(9, '1991-06-14', 'Daniel', 'Lee', 'M', '2018-09-30'),
(10, '1989-12-07', 'Sophia', 'Smith', 'F', '2017-07-12'),
(11, '1994-05-25', 'David', 'Jones', 'M', '2021-01-17'),
(12, '1986-10-08', 'Ella', 'White', 'F', '2019-03-04'),
(13, '1997-03-18', 'Ryan', 'Martin', 'M', '2020-08-09'),
(14, '1996-07-01', 'Grace', 'Anderson', 'F', '2018-12-12'),
(15, '1990-09-09', 'Brian', 'Taylor', 'M', '2022-03-26'),
(16, '1984-12-23', 'Mia', 'Brown', 'F', '2017-05-20'),
(17, '1993-01-07', 'Jacob', 'Moore', 'M', '2019-06-15'),
(18, '1988-04-29', 'Chloe', 'Wilson', 'F', '2020-09-18'),
(19, '1995-11-11', 'Matthew', 'Johnson', 'M', '2018-02-02'),
(20, '1992-06-03', 'Ava', 'Jones', 'F', '2021-07-08');

CREATE TABLE departments (
    deptno     CHAR(4)         NOT NULL,  
    deptname   VARCHAR(40)     NOT NULL,
    PRIMARY KEY (deptno),                 
    UNIQUE  KEY (deptname)   
);
INSERT INTO departments (deptNo, deptName)
VALUES
('D001', 'Sales'),
('D002', 'Marketing'),
('D003', 'Human Resources'),
('D004', 'Finance'),
('D005', 'Research and Development'),
('D006', 'Customer Service'),
('D007', 'Information Technology'),
('D008', 'Operations'),
('D009', 'Quality Assurance'),
('D010', 'Legal'),
('D011', 'Procurement'),
('D012', 'Public Relations'),
('D013', 'Administration'),
('D014', 'Facilities'),
('D015', 'Health and Safety'),
('D016', 'Product Management'),
('D017', 'Training and Development'),
('D018', 'Internal Audit'),
('D019', 'Business Development'),
('D020', 'Supply Chain');


CREATE TABLE deptemp (
    empno      INT         NOT NULL,
    deptno     CHAR(4)     NOT NULL,
    fromdate   DATE        NOT NULL,
    todate     DATE        NOT NULL,
    KEY         (empno),   
    KEY         (deptno),  
    FOREIGN KEY (empno) REFERENCES employees (empno) ON DELETE CASCADE,
           
    FOREIGN KEY (deptno) REFERENCES departments (deptno) ON DELETE CASCADE,
          
    PRIMARY KEY (empno, deptno)
          
);

INSERT INTO deptemp (empno, deptno, fromdate, todate)
VALUES
(1, 'D001', '2020-05-01', '2021-08-15'),
(2, 'D002', '2019-08-10', '2022-02-18'),
(3, 'D003', '2022-02-18', '2023-06-30'),
(4, 'D004', '2018-06-25', '2020-12-31'),
(5, 'D005', '2021-04-14', '2022-10-01'),
(6, 'D006', '2017-11-08', '2019-06-30'),
(7, 'D007', '2019-10-22', '2022-05-15'),
(8, 'D008', '2020-12-05', '2023-01-20'),
(9, 'D009', '2018-09-30', '2022-11-30'),
(10, 'D010', '2017-07-12', '2019-12-31'),
(11, 'D011', '2021-01-17', '2022-11-30'),
(12, 'D012', '2019-03-04', '2020-08-31'),
(13, 'D013', '2020-08-09', '2022-04-30'),
(14, 'D014', '2018-12-12', '2021-07-31'),
(15, 'D015', '2022-03-26', '2023-12-31'),
(16, 'D016', '2017-05-20', '2019-10-31'),
(17, 'D017', '2019-06-15', '2023-02-28'),
(18, 'D018', '2020-09-18', '2022-08-31'),
(19, 'D019', '2018-02-02', '2020-05-15'),
(20, 'D020', '2021-07-08', '2023-03-31'),
(1, 'D002', '2021-08-16', '2023-12-31'),
(2, 'D003', '2022-02-19', '2023-06-30'),
(3, 'D004', '2023-07-01', '2023-12-31'),
(4, 'D005', '2021-01-01', '2022-09-30'),
(5, 'D006', '2022-10-02', '2023-12-31'),
(6, 'D007', '2019-07-01', '2022-05-15'),
(7, 'D008', '2023-01-21', '2023-12-31'),
(8, 'D009', '2022-12-01', '2023-12-31'),
(9, 'D010', '2020-01-01', '2020-12-31'),
(10, 'D011', '2020-01-01', '2022-11-30'),
(11, 'D012', '2021-01-01', '2021-12-31'),
(12, 'D013', '2020-09-01', '2022-04-30'),
(13, 'D014', '2022-05-01', '2022-12-31'),
(14, 'D015', '2024-01-01', '2024-12-31'),
(15, 'D016', '2024-01-01', '2024-12-31'),
(16, 'D017', '2023-03-01', '2023-12-31'),
(17, 'D018', '2022-09-01', '2023-08-31'),
(18, 'D019', '2021-01-01', '2022-05-15'),
(19, 'D020', '2023-04-01', '2023-12-31'),
(20, 'D001', '2023-04-01', '2023-12-31');
