package com.saurabh.dada.iq.impl.designpatterns.transferobject;

import java.util.ArrayList;
import java.util.List;

public class StudentBO {

	// list is working as a database
	List<StudentVO> students;

	public StudentBO() {
		students = new ArrayList<StudentVO>();
		StudentVO student1 = new StudentVO("Priyanka", 0);
		StudentVO student2 = new StudentVO("Saurabh", 1);
		StudentVO student3 = new StudentVO("Ahish", 2);
		StudentVO student4 = new StudentVO("Yasir", 3);
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
	}

	public void deleteStudent(StudentVO student) {
		students.remove(student.getRollNo());
		System.out.println("Student: Roll No " + student.getRollNo()
				+ ", deleted from database");
	}

	// retrive list of students from the database
	public List<StudentVO> getAllStudents() {
		return students;
	}

	public StudentVO getStudent(int rollNo) {
		return students.get(rollNo);
	}

	public void updateStudent(StudentVO student) {
		students.get(student.getRollNo()).setName(student.getName());
		System.out.println("Student: Roll No " + student.getRollNo()
				+ ", updated in the database");
	}
}
