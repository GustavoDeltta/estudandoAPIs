package com.example.steamApi

data class Game(val id: Int, val name: String, val cover: String)

class Response<T>(val data: T)

class MyGames{
    private val allMyGames: MutableList<Game> = mutableListOf(
        Game(1, "Sombras da Guerra", "https://m.media-amazon.com/images/I/91gPp8gUvWL._AC_UF1000,1000_QL80_.jpg"),
        Game(2, "Tomb Raider", "https://m.media-amazon.com/images/I/81XmzKjxu4L._AC_UF350,350_QL50_.jpg"),
        Game(3, "Dark Souls", "https://m.media-amazon.com/images/I/71xY1CYZmfL._AC_UF1000,1000_QL80_.jpg")
    );
    fun getAllMyGame(): List<Game>{
        return allMyGames;
    }
    fun getMyGameById(id: Any): Response<out Any> {
        var gameAux = Game(0, "", "")
        for (game: Game in allMyGames) {
            if (game.id.toString() == id.toString()) {
                gameAux = game
                break
            }
        }
        if (gameAux.id != 0){
            val response = Response<Game>(gameAux)
            return response;
        }else{
            val response = Response<String>("Error 404! Game Not Found")
            return response;
        }
    }
    fun insertMyGame(game: Game): Response<out Any>{
        allMyGames.add(game)
        return Response("Game Insert Succesfuly")
    }
}