package com.example.MyServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyServerApplication

fun main(args: Array<String>) {
	runApplication<MyServerApplication>(*args)
}
