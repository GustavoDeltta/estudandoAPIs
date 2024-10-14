package com.example.MyServer

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@RestController
class MyServerController {

    @GetMapping("/")
    fun getServerOn(): String{
        return "Server On"
    }

    @GetMapping("/info")
    fun getInfoServer(@RequestParam("name") myName: String?,
                      @RequestParam("age") myAge: Int?): String{
        if (myName == null || myAge == null){
            return "Hello human, i'm from localhost."
        }
        return "Hello human, i'm from localhost. My name is $myName and i $myAge years old.";
    }
    @GetMapping("/hobbies")
    fun getMyHobbies(): List<Hobby>{
        val myHobbies: List<Hobby> =
            listOf(Hobby("Jogar Videogame", "Digital"),
                   Hobby("Jogar Volei", "Esporte"),
                   Hobby("Estudar", "Casual")
            )
        return myHobbies;
    }
}