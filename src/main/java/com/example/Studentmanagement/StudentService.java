package com.example.Studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        return  studentRepository.addStudent(student);
    }

    public Student getStudent(int admnNo){
        return studentRepository.getStudent(admnNo);
    }

    public String removeStudent(int admnNo)
    {
        return studentRepository.removeStudent(admnNo);
    }

    public String putStudent(int admnNo,int age){
        return studentRepository.putStudent(admnNo, age);
    }
}
