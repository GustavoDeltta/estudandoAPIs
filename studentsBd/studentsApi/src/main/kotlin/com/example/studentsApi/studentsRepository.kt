package com.example.studentsApi

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface studentsRepository: JpaRepository<students, Int> {
    @Query("select name from students where age >= :age", nativeQuery = true)
    fun getStudentsByAge(@Param("age") age: Int): List<String>
}