package com.example.studentsApi

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class studentsController(val studentsRepository: studentsRepository) {

    @GetMapping("/all")
    fun getAllStudents(): List<students>{
        return studentsRepository.findAll()
    }
}