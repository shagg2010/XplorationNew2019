-- nth highest salary

SELECT e1.employee_id, e1.last_name, e1.salary FROM EMP_MGRS e1 WHERE 1 =(SELECT COUNT(DISTINCT e2.salary) FROM EMP_MGRS e2 WHERE e1.salary<=e2.salary);
-- 1 in where clause gives top salary, 2 gives 2nd hishest
OR
SELECT * FROM EMP_MGRS Emp1 WHERE 1 = (SELECT COUNT(DISTINCT(Emp2.salary))FROM EMP_MGRS Emp2 WHERE Emp2.salary > Emp1.salary);

-- this solution will use Correlated Subquery. This is also generic solution to find Nth highest salary in Employee table. 
-- For each record processed by outer query, inner query will be executed and will return how many records has salary less than the current salary. 
-- If you are looking for second highest salary then your query will stop as soon as inner query will return 2. === http://java67.blogspot.in/2015/01/second-highest-salary-in-mysql-and-sql-server.html
-- where 1 means only 1 salary greater than the selected one, which will give us - 2nd highest salary for 3rd just make it (2) in where clause

-- Normal Subquery- http://javarevisited.blogspot.in/2012/07/subquery-example-in-sql-correlated-vs.html
SELECT name FROM employee WHERE dept_name IN (SELECT dept_name FROM departments WHERE dept_id='1008')

---------------------------------------------
-- http://www.folkstalk.com/2012/01/oracle-subquerycorrelated-query.html
select * from EMPLOYEE;
select * from DEPARTMENT;
select * from DEPT_EMP_MAP;
-- Employee working in Dept-name='d1'
select e1.emp_id, e1.first_name,dem.DEPT_ID,dept.DEPT_NAME from EMPLOYEE e1,DEPT_EMP_MAP dem,DEPARTMENT dept where e1.EMP_ID=dem.EMP_ID and dept.DEPT_ID = dem.DEPT_ID and dept.DEPT_NAME='D1';

-- employees whose salary is greater than emp with id=5
select * from O_EMPLOYEE where salary > (select salary from O_EMPLOYEE e1 where e1.emp_id='5'); 

-- all employees with top salaries (all employees with highest salary)
select * from O_EMPLOYEE where salary = (select max(salary) from O_EMPLOYEE);

-- max salary for a department
select max(salary) from O_EMPLOYEE e1,O_DEPT_EMP_MAP dem where e1.EMP_ID=dem.EMP_ID and dem.DEPT_ID='D5';

--- departments in which the least salary is greater than the highest salary in the department of id-D4
select min(e1.salary), e1.dept_id, d1.DEPT_NAME from P_EMPLOYEE e1,P_DEPARTMENT d1 where e1.dept_id=d1.dept_id GROUP BY e1.dept_id,d1.DEPT_NAME having min(e1.salary) > (select max(e2.salary) from P_EMPLOYEE e2 where e2.DEPT_ID='D4');

-- highest salary in every department
select max(e1.salary), e1.DEPT_ID from P_EMPLOYEE e1 where e1.DEPT_ID IN (select distinct(d1.DEPT_ID) from P_DEPARTMENT d1) group by e1.DEPT_ID order by e1.DEPT_ID; 

-- departments in which the least salary is greater than the highest salary in the department of id-2
select min(salary) as min_salary,DEPARTMENT_ID from EMP_MGRS group by DEPARTMENT_ID having min(salary) > (select max(salary) from EMP_MGRS where DEPARTMENT_ID=2);

-- all the employees with their respective dept names
select e1.EMP_ID,e1.LAST_NAME,dept.DEPT_ID, dept.DEPT_NAME from O_EMPLOYEE e1,O_DEPARTMENT dept,O_DEPT_EMP_MAP dem where dem.EMP_ID=e1.EMP_ID and dem.DEPT_ID=dept.DEPT_ID order by e1.EMP_ID,dem.DEPT_ID;

--------------------------------------------------------------
-- Self join for employee manager
select e1.employee_id as EmpId, e1.last_name as Emp, e2.last_name as ManagerName, e2.employee_id as ManagerId from emp_mgrs e1 
LEFT OUTER JOIN emp_mgrs e2 ON e1.manager_id=e2.employee_id  order by e1.employee_id
--easy
select e1.employee_id, e1.last_name, e2.last_name as ManagerName from emp_mgrs e1 
LEFT OUTER JOIN emp_mgrs e2 ON e1.manager_id=e2.employee_id  order by e1.employee_id

-- Triggers
CREATE OR REPLACE TRIGGER Print_salary_changes
  BEFORE DELETE OR INSERT OR UPDATE ON Emp_tab
  FOR EACH ROW
WHEN (new.Empno > 0)
DECLARE
    sal_diff number;
BEGIN
    sal_diff  := :new.sal  - :old.sal;
    dbms_output.put('Old salary: ' || :old.sal);
    dbms_output.put('  New salary: ' || :new.sal);
    dbms_output.put_line('  Difference ' || sal_diff);
END;

-- Cursor
DECLARE
   supp_id suppliers.supplier_id%type;
   supp_name suppliers.supplier_name%type;
   CURSOR c_suppliers is
      SELECT supplier_id, supplier_name FROM suppliers;
BEGIN
   OPEN c_suppliers;
   LOOP
      FETCH c_suppliers into supp_id, supp_name;
      EXIT WHEN c_suppliers%notfound;
      dbms_output.put_line(supp_id || ' ' || supp_name);
   END LOOP;
   CLOSE c_suppliers;
END;

-- Subqueries - to find number of records which has multiple LAST_OFFERED=1 for a given combination of CASE_ID and PROPOSITION_ID 

SELECT CASE_ID, PROPOSITION_ID, NUM_OFFERS FROM 
		(SELECT COUNT(CASE_ID) AS NUM_OFFERS, CASE_ID, PROPOSITION_ID 
					FROM IS_FACT_RESPONSE WHERE LAST_OFFERED=1 
					GROUP BY CASE_ID, PROPOSITION_ID 
					ORDER BY CASE_ID) 
		WHERE NUM_OFFERS>1;
		
/* to find records which has multiple number of duplicate NUM_OFFERS for a given CASE_ID and PROPOSITION_ID  */

SELECT CASE_ID, PROPOSITION_ID, NUM_OFFERS, NO_OF_DUPLICATE_RECORDS FROM 
		(SELECT CASE_ID, PROPOSITION_ID, NUM_OFFERS, COUNT(NUM_OFFERS) AS NO_OF_DUPLICATE_RECORDS 
				FROM IS_FACT_RESPONSE 
				GROUP BY CASE_ID, PROPOSITION_ID, NUM_OFFERS 
				ORDER BY PROPOSITION_ID) 
		WHERE NO_OF_DUPLICATE_RECORDS>1; 
		

/* Other examples */
select e1.emp_id,e1.first_name, DEM.DEPT_ID from EMPLOYEE e1 left outer join DEPT_EMP_MAP DEM ON e1.EMP_ID=DEM.EMP_ID where DEM.DEPT_ID IN (SELECT DEPT_ID from DEPARTMENT where DEPT_NAME='D1');

SELECT DISTINCT(DATE_ID) FROM IS_FACT_RESPONSE where TO_CHAR(OFFERED_ON,'yyyy/mm/dd')='2015/03/17';

SELECT DECISION_RESULT_ID,MEASURE20, NO_OF_DUPLICATE_RECORDS,DATE_ID FROM 
		(SELECT DECISION_RESULT_ID, MEASURE20, DATE_ID, COUNT(MEASURE20) AS NO_OF_DUPLICATE_RECORDS 
				FROM IS_FACT_RESPONSE 
				GROUP BY DECISION_RESULT_ID,MEASURE20,DATE_ID
        ORDER BY DECISION_RESULT_ID) 
		WHERE NO_OF_DUPLICATE_RECORDS>1 and DATE_ID IN (SELECT DISTINCT(IFR1.DATE_ID) FROM IS_FACT_RESPONSE IFR1 where TO_CHAR(IFR1.OFFERED_ON,'yyyy/mm/dd')='2015/03/17');
    
    
    
SELECT * FROM IS_FACT_RESPONSE WHERE MEASURE20 IN (SELECT MEASURE20 FROM 
		(SELECT DECISION_RESULT_ID, MEASURE20, DATE_ID, COUNT(MEASURE20) AS NO_OF_DUPLICATE_RECORDS 
				FROM IS_FACT_RESPONSE 
				GROUP BY DECISION_RESULT_ID,MEASURE20,DATE_ID
        ORDER BY DECISION_RESULT_ID) 
		WHERE NO_OF_DUPLICATE_RECORDS>1 and DATE_ID IN (SELECT DISTINCT(IFR1.DATE_ID) FROM IS_FACT_RESPONSE IFR1 where TO_CHAR(IFR1.OFFERED_ON,'yyyy/mm/dd')='2015/03/17'));		