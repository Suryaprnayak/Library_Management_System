package com.example.firstproject.Controller;

import com.example.firstproject.Modules.Book;
import com.example.firstproject.Modules.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final HashMap<Integer, Student> studentMap = new HashMap<>();
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        studentMap.put(student.getRoll(),student);
        return "Student added successfully";
    }
    @GetMapping("/get_student")
    public List<Student> getStudent(){
        return new ArrayList<>(studentMap.values());
//        List<Student> std = new ArrayList<>();
//        for (int studentID : studentMap.keySet()){
//            System.out.println(studentMap.get(studentID));
//            std.add(studentMap.get(studentID));
//        }
//        return std;
    }
    @GetMapping("/get_student_by_name")
    public Student getStudentByName(@RequestParam String name){
       for (int key:studentMap.keySet()){
           if (studentMap.get(key).getName().equals(name)){
               studentMap.get(key);
           }
       }
       return null;
    }
    public Student getStudentById(@RequestParam int id){
        return studentMap.get(id);
    }
    @DeleteMapping("/remove_student-byId")
    public String removeStudentById(@RequestParam int id){
        if (studentMap.containsKey(id)){
            studentMap.remove(id);
            return "student deleted successfully";
        }
        else {
            return "student not found";
        }
    }
    @DeleteMapping("/remove_all_student")
    public String removeStudent(Student student){
         for (int key : studentMap.keySet()){
             studentMap.remove(key);
         }
        return "student remove successfully";
    }
    @PutMapping("/update_student-name")
    public String updateStudentName(@RequestParam int roll,@RequestParam String name){
        Student student=studentMap.get(roll);
        student.setName(name);
        studentMap.put(roll,student);
        return "student name updated successfully";
    }

}
