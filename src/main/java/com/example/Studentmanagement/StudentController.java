package com.example.Studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //adding student
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response=studentService.addStudent(student);
        return  new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //getting student
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("Q") int admnNo){
        Student student=studentService.getStudent(admnNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    //remove student
    @DeleteMapping("/remove_student/{id}")
    public ResponseEntity removeStudent(@PathVariable("id") int admnNo)
   {
       String response = studentService.removeStudent(admnNo);
       if(response.equals("Invalid id")){
           return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
       }
       return  new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    //updating student
    @PutMapping("/put_student")
    public ResponseEntity putStudent(@RequestParam("id") int admnNo,@RequestParam("age") int age){
        String response = studentService.putStudent(admnNo,age);
        if(response==null){
            return new ResponseEntity<>("Invalid id",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
