drop table p_employee;
drop table p_department;

CREATE TABLE p_department (
    dept_id     varchar2(10)         NOT NULL,
    dept_name   varchar2(40)     NOT NULL,
    PRIMARY KEY (dept_id),
    UNIQUE      (dept_name)
);

CREATE TABLE p_employee (
    emp_id      varchar2(10)    NOT NULL,
    first_name  varchar2(15)     NOT NULL,
    last_name   varchar2(15)     NOT NULL,
    salary      number(6)     NOT NULL,
    dept_id     varchar2(10)        NOT NULL,
    manager     varchar2(10),
    PRIMARY KEY (emp_id),
    FOREIGN KEY (dept_id) REFERENCES p_department (dept_id) ON DELETE CASCADE
);

commit;

delete from p_employee;
delete from p_department;

insert into p_department values('D1','Dept1');
insert into p_department values('D2','Dept2');
insert into p_department values('D3','Dept3');
insert into p_department values('D4','Dept4');
insert into p_department values('D5','Dept5');
commit;

insert into p_employee values('1','A1','Abc1',1000,'D1',null);
insert into p_employee values('2','A2','Abc2',800,'D1',1);
insert into p_employee values('3','A3','Abc3',400,'D3',1);
insert into p_employee values('4','A4','Abc4',450,'D5',2);
insert into p_employee values('5','A5','Abc5',500,'D2',2);
insert into p_employee values('6','A6','Abc6',510,'D2',5);
insert into p_employee values('7','A7','Abc7',350,'D4',5);
insert into p_employee values('8','A8','Abc8',900,'D5',8);
insert into p_employee values('9','A9','Abc9',300,'D4',2);
insert into p_employee values('10','A10','Abc10',800,'D3',1);
commit;