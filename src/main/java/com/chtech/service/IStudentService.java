package com.chtech.service;

import com.chtech.model.Student;

import java.util.List;

public interface IStudentService
{
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Integer id);
    public void deleteStudentById(Integer id);
	public boolean updateStudent(Integer id, Student updatedStudent);
}
