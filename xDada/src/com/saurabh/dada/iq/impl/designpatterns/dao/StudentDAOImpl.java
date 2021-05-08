package com.saurabh.dada.iq.impl.designpatterns.dao;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
	
	   //list is working as a database
	   List<Student> students;

	   public StudentDAOImpl(){
	      students = new ArrayList<Student>();
	      Student student = new Student("Priyanka",110);
	      students.add(student);
	      student = new Student("Saurabh",101);	      
	      students.add(student);
	      student = new Student("Ashish",102);	      
	      students.add(student);
	      student = new Student("Yasir",103);	      
	      students.add(student);
	   }
	   @Override
	   public void deleteStudent(Student student) {
	      students.remove(student.getRollNo());
	      System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
	   }

	   //retrive list of students from the database
	   @Override
	   public List<Student> getAllStudents() {
	      return students;
	   }

	   @Override
	   public Student getStudent(int rollNo) {
		   for(Student stu:students){
			   if(stu.getRollNo()==rollNo){
				   return stu;
			   }
		   }
	      return null;
	   }

	   @Override
	   public void updateStudent(Student student) {
	      getStudent(student.getRollNo()).setName(student.getName());
	      System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
	   }
	}
