package com.chtech.rest;

import com.chtech.model.Student;
import com.chtech.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentRestController
{
    @Autowired
    private IStudentService service;

    @PostMapping("/Student")   
  
    public Student registerStudent(@RequestBody Student student)
    {
        System.out.println("Student data " +student);

        Student st=service.saveStudent(student);
        return st;
    }
//CORS
    @GetMapping("/Students")
    public List<Student> getAllStudents()
    {
        //invock service method responsible to retrive all records of students
        List<Student> list=service.getAllStudents();
        return list;
    }

    @GetMapping("/Student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id)
    {
        //invock service method responsible to retrive student data based on id
       Student stu= service.getStudentById(id);
       //return stu;
       // return new ResponseEntity<Student>(stu, HttpStatus.OK);
        return ResponseEntity.ok(stu);
    }

    @DeleteMapping("/Student/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Integer id)
    {
        //invock service method responsible to retrive student data based on id
       // return new ResponseEntity<>(new Studnet, HttpStatus.OK)
        service.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/Student/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer id,@RequestBody Student updatedStudent)
    {
    	boolean isStuentUpdated = service.updateStudent(id, updatedStudent);
    	if (isStuentUpdated)
    		return new ResponseEntity<String>("Student updated successfully",HttpStatus.OK);
		else
			return  new ResponseEntity<String>("Student not updated successfully",HttpStatus.NOT_FOUND);
    }


}
