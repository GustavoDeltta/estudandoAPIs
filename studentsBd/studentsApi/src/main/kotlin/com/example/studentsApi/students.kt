package com.example.studentsApi

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "students")
data class students(
    @Id val registration: Int,
    val name: String,
    val age: Int
)