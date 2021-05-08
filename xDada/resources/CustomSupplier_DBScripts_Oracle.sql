drop sequence seq1;
drop table suppliers;
commit;

create sequence seq1 start with 1 increment by 1 cache 1000;
create table suppliers(supplier_id varchar2(20), supplier_name varchar2(20), PRIMARY KEY (supplier_id));
insert into suppliers values(TO_CHAR(seq1.nextval),'Oracle');
insert into suppliers values(TO_CHAR(seq1.nextval),'IBM');
insert into suppliers values(TO_CHAR(seq1.nextval),'Pegasystems');
insert into suppliers values(TO_CHAR(seq1.nextval),'Microsoft');
insert into suppliers values(TO_CHAR(seq1.nextval),'Samsung');
commit;

drop sequence seq2;
drop table orders;
commit;

create sequence seq2 start with 1 increment by 1 cache 1000;
create table orders(order_id varchar2(20), supplier_id varchar2(20), order_date date, PRIMARY KEY (order_id),FOREIGN KEY (supplier_id) REFERENCES suppliers (supplier_id) ON DELETE CASCADE);
insert into orders VALUES (TO_CHAR(seq2.nextval),1,TO_DATE('2015-01-21','YYYY-MM-DD'));
insert into orders VALUES (TO_CHAR(seq2.nextval),1,TO_DATE('2015-01-21','YYYY-MM-DD'));
insert into orders VALUES (TO_CHAR(seq2.nextval),2,TO_DATE('2015-01-18','YYYY-MM-DD'));
insert into orders VALUES (TO_CHAR(seq2.nextval),3,TO_DATE('2015-01-10','YYYY-MM-DD'));
insert into orders VALUES (TO_CHAR(seq2.nextval),4,TO_DATE('2015-01-10','YYYY-MM-DD'));
insert into orders VALUES (TO_CHAR(seq2.nextval),5,TO_DATE('2015-01-10','YYYY-MM-DD'));
insert into orders VALUES (TO_CHAR(seq2.nextval),5,TO_DATE('2015-01-10','YYYY-MM-DD'));
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