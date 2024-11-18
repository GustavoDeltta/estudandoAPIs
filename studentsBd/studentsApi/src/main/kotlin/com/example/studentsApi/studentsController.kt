package com.example.studentsApi

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class studentsController(val studentsRepository: studentsRepository) {

    @GetMapping("/all")
    fun getAllStudents(): List<students>{
        return studentsRepository.findAll()
    }
    @GetMapping("/insert") // localhost:8080/insert?regi=xxx&name=xxx&age=xxx
    fun insertStudent(@RequestParam("regi") registration: Int,
                      @RequestParam("name") name: String,
                      @RequestParam("age") age: Int): students{
                            val student = students(registration, name, age)
                            return studentsRepository.save(student);
                      }
    @GetMapping("/search") // localhost:8080/search?age=xx
    fun getStudentsByAge(@RequestParam("age") age: Int): List<String> {
        return studentsRepository.getStudentsByAge(age)
    }
}