package com.example.studentsApi

import org.springframework.data.jpa.repository.JpaRepository

interface studentsRepository: JpaRepository<students, Int> {

}