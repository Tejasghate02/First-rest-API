package com.example.Studentmanagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> db = new HashMap<>();

    public String addStudent(Student student){
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);
        return  "Student added successfully";
    }

    public Student getStudent(int admnNo){
        return db.get(admnNo);
    }

    public String removeStudent(int admnNo)
    {
        if(!db.containsKey(admnNo)){
            return "Invalid id";
        }
        db.remove(admnNo);
        return "Student removed successfully";
    }

    public String putStudent(int admnNo,int age){
        if(!db.containsKey(admnNo)) {
            return null;
        }
        db.get(admnNo).setAge(age);
        return "Update successfully";
    }
}
