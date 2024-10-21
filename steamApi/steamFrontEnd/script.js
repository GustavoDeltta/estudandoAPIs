async function getAllGames() {
    var response = await fetch("http://localhost:8080/all");
    var infos = await response.json();

    console.log(infos);
    for(game of infos){
        var cardGame = document.createElement("div")
        cardGame.innerHTML = `
            <img src="${game.cover}" width="100">
            <p>${game.name}</p>
        `;
        document.querySelector(".allMyGames").appendChild(cardGame)
    }
}
getAllGames();