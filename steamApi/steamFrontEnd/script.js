var modal = document.querySelector("dialog");

async function getAllGames() {
  var answer = await fetch("http://localhost:8080/all");
  var data = await answer.json();

  console.log(data);
  for (game of data) {
    var cardGame = document.createElement("div");
    cardGame.classList.add("cardGame");
    cardGame.innerHTML = `
      <img src="${game.cover}" width="120">
      <p>${game.name}</p>
    `;

    document.querySelector(".allMyGames").appendChild(cardGame);
  }
}

function openModalInsert() {
  modal.style.display = "flex";
  modal.showModal();
}

function closeModalInsert() {
  modal.style.display = "none";
  modal.close();
}

async function insertGame(){
  var id = Math.floor(Math.random()*1000);
  var name = document.querySelector("#name");
  var cover= document.querySelector("#cover");

  var answer = await fetch(`http://localhost:8080/insert?id=${id}&name=${name.value}cover=${cover.value}`);
  var data = await answer.json();

  modal.style.display = "none";
  modal.close();
}

getAllGames();
