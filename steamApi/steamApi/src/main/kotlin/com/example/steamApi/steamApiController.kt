package com.example.steamApi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SteamJgaController {

    val myGames = MyGames();

    @GetMapping("/all")
    fun getAllGames(): List<Game>{
        return myGames.getAllMyGame();
    }
    @GetMapping("/search")
    fun getGameById(@RequestParam("id") id: Any): Response<out Any>{
        return myGames.getMyGameById(id)
    }
    @GetMapping("insert")
    fun insertGame(@RequestParam("id") id: Int = 0,
                   @RequestParam("name") name: String = "",
                   @RequestParam("cover") cover: String = ""
    ): Response<out Any>{
        val gameAux = Game(id, name, cover)
        return myGames.insertMyGame(gameAux)
    }
}