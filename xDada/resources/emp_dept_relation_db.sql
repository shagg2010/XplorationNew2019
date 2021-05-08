drop table o_employee;
drop table o_department;
drop table o_dept_emp_map;
commit;

CREATE TABLE o_employee (
    emp_id      varchar2(10)    NOT NULL,
    first_name  varchar2(15)     NOT NULL,
    last_name   varchar2(15)     NOT NULL,
    salary      number(6)     NOT NULL,
    manager     varchar2(10),
    PRIMARY KEY (emp_id)
);

CREATE TABLE o_department (
    dept_id     varchar2(10)         NOT NULL,
    dept_name   varchar2(40)     NOT NULL,
    PRIMARY KEY (dept_id),
    UNIQUE      (dept_name)
);

CREATE TABLE o_dept_emp_map (
    emp_id      varchar2(10)             NOT NULL,
    dept_id     varchar2(10)        NOT NULL,
    FOREIGN KEY (dept_id) REFERENCES o_department (dept_id) ON DELETE CASCADE,
    PRIMARY KEY (emp_id,dept_id)
);
commit;


delete from o_employee;
delete from o_department;
delete from o_dept_emp_map;
commit;


insert into o_employee values('1','A1','Abc1',1000,null);
insert into o_employee values('2','A2','Abc2',800,1);
insert into o_employee values('3','A3','Abc3',400,1);
insert into o_employee values('4','A4','Abc4',450,2);
insert into o_employee values('5','A5','Abc5',500,2);
insert into o_employee values('6','A6','Abc6',510,5);
insert into o_employee values('7','A7','Abc7',350,5);
insert into o_employee values('8','A8','Abc8',900,8);
insert into o_employee values('9','A9','Abc9',300,2);
insert into o_employee values('10','A10','Abc10',800,1);

insert into o_department values('D1','Dept1');
insert into o_department values('D2','Dept2');
insert into o_department values('D3','Dept3');
insert into o_department values('D4','Dept4');
insert into o_department values('D5','Dept5');

insert into o_dept_emp_map values('1','D1');
insert into o_dept_emp_map values('1','D2');
insert into o_dept_emp_map values('1','D3');
insert into o_dept_emp_map values('2','D1');
insert into o_dept_emp_map values('3','D5');
insert into o_dept_emp_map values('4','D2');
insert into o_dept_emp_map values('5','D4');
insert into o_dept_emp_map values('6','D4');
insert into o_dept_emp_map values('7','D5');
insert into o_dept_emp_map values('8','D1');
insert into o_dept_emp_map values('9','D3');
insert into o_dept_emp_map values('10','D5');
insert into o_dept_emp_map values('10','D1');
commit;


drop table emp_mgrs;
commit;

create table emp_mgrs (employee_id number(10) primary key, last_name varchar2(50) not null, email varchar2(30), hire_date date, job_id varchar2(30), department_id number(10), salary  number(6), manager_id number(6));
insert into emp_mgrs( employee_id, last_name, email, hire_date, job_id, salary,department_id ,manager_id) values ( 1001, 'Lawson', 'lawson@g.com', '01-JAN-2002','MGR', 30000,1 ,1004);
insert into emp_mgrs( employee_id, last_name, email, hire_date, job_id, salary, department_id ,manager_id) values ( 1002, 'Wells', 'wells@g.com', '01-JAN-2002', 'DBA', 20000,2, 1005 );
insert into emp_mgrs( employee_id, last_name, email, hire_date, job_id, salary, department_id ,manager_id) values( 1003, 'Bliss', 'bliss@g.com', '01-JAN-2002', 'PROG', 24000,3 ,1004);
insert into emp_mgrs( employee_id, last_name, email, hire_date, job_id, salary, department_id, manager_id) values( 1004,  'Kyte', 'tkyte@a.com', SYSDATE-3650, 'MGR',25000 ,4, 1005);
insert into emp_mgrs( employee_id, last_name, email, hire_date, job_id, salary, department_id, manager_id) values( 1005, 'Viper', 'sdillon@a .com', SYSDATE, 'PROG', 20000, 1, 1006);
insert into emp_mgrs( employee_id, last_name, email, hire_date, job_id, salary, department_id,manager_id) values( 1006, 'Beck', 'clbeck@g.com', SYSDATE, 'PROG', 20000, 2, null);
insert into emp_mgrs( employee_id, last_name, email, hire_date, job_id, salary, department_id, manager_id) values( 1007, 'Java', 'java01@g.com', SYSDATE, 'PROG', 20000, 3, 1006);
insert into emp_mgrs( employee_id, last_name, email, hire_date, job_id, salary, department_id, manager_id) values( 1008, 'Oracle', 'wvelasq@g.com', SYSDATE, 'DBA', 20000, 4, 1006);
commit;