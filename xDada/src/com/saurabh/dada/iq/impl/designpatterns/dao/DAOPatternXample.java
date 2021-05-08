package com.saurabh.dada.iq.impl.designpatterns.dao;

public class DAOPatternXample {
	
	public static void main(String[] args) {
		
		StudentDAO studentDao = new StudentDAOImpl();

		// print all students
		for (Student student : studentDao.getAllStudents()) {
			System.out.println("Student: [RollNo : " + student.getRollNo()
					+ ", Name : " + student.getName() + " ]");
		}

		// update student
		Student student = studentDao.getStudent(103);
		if(student!=null){
			student.setName("Yasir Ahmed");
			studentDao.updateStudent(student);
		}
		
		// get the student
		studentDao.getStudent(0);
		System.out.println("Student: [RollNo : " + student.getRollNo()
				+ ", Name : " + student.getName() + " ]");
	}

}
