package com.chtech.service;

import com.chtech.model.Student;
import com.chtech.dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService
{

    @Autowired
    private StudentRepo repo;

    @Override
    public Student saveStudent(Student student) {
        //Invock Logic to store data in database

        repo.save(student);

        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        //Invock Logic to retrive all student records from database
        return  repo.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {

        Optional<Student> optional=repo.findById(id);
       return optional.get();

    }

    @Override
    public void deleteStudentById(Integer id) {
        repo.deleteById(id);
    }
    
    @Override
    public boolean updateStudent(Integer id, Student updatedStudent)
    {
    	List<Student> Students= getAllStudents();
    	for(Student student:Students ) {
    		if (student.getId().equals(id)) {
    			
    			student.setName(updatedStudent.getName());
    			student.setEmail(updatedStudent.getEmail());
    			student.setAddress(updatedStudent.getAddress());
    			student.setPhoneNumber(updatedStudent.getPhoneNumber());
    			student.setClassName(updatedStudent.getClassName());
    			student.setFatherName(updatedStudent.getFatherName());
    			repo.save(student);
    			
    			return true;
    		}
    	}
    	return false;
    	
    }
}
