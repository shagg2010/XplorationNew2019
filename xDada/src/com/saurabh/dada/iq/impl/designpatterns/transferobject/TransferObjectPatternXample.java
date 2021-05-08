package com.saurabh.dada.iq.impl.designpatterns.transferobject;

public class TransferObjectPatternXample {
	
	public static void main(String[] args) {
		StudentBO studentBusinessObject = new StudentBO();

		// print all students
		for (StudentVO student : studentBusinessObject.getAllStudents()) {
			System.out.println("Student: [RollNo : " + student.getRollNo()
					+ ", Name : " + student.getName() + " ]");
		}

		// update student
		StudentVO student = studentBusinessObject.getAllStudents().get(3);
		student.setName("Yasir Ahmed");
		studentBusinessObject.updateStudent(student);

		// get the student
		student = studentBusinessObject.getStudent(3);
		System.out.println("Student: [RollNo : " + student.getRollNo()
				+ ", Name : " + student.getName() + " ]");
	}

}
