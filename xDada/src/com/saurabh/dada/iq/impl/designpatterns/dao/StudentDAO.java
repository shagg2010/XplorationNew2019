package com.saurabh.dada.iq.impl.designpatterns.dao;

import java.util.List;

public interface StudentDAO {
	
	public abstract List<Student> getAllStudents();
	public Student getStudent(int rollNo);
	public void updateStudent(Student student);
	public void deleteStudent(Student student);
}
