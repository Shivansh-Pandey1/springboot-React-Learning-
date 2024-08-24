let boxes = document.querySelectorAll(".box");
let reset = document.getElementById("reset");
let newgame = document.getElementById("newgame");
let turn0 = true;

const winpattern = [
    [0, 1, 2],
    [0, 3, 6],
    [0, 4, 8],
    [1, 4, 7],
    [2, 5, 8],
    [2, 4, 6],
    [3, 4, 5],
    [6, 7, 8]
];

boxes.forEach((box) => {
    box.addEventListener("click", () => {
        if (box.innerText === "") { 
            box.innerText = turn0 ? "0" : "X"; 
            box.disabled = true; 
            checkWinner();
            turn0 = !turn0; 
        }
    });
});

const enableboxes = () => {
    for (let box of boxes) {
        box.disabled = false;
        box.innerText = "";
    }
}

const checkWinner = () => {
    for (let pattern of winpattern) {
        let pos1 = boxes[pattern[0]].innerText;
        let pos2 = boxes[pattern[1]].innerText;
        let pos3 = boxes[pattern[2]].innerText;

        if (pos1 !== "" && pos1 === pos2 && pos1 === pos3) { 
            alert(`WINNER is ${pos1}`);
            for (let box of boxes) {
                box.disabled = true; 
            }
            return; 
        }
        

    }
}

const resetgame = () => {
    turn0 = true; 
    enableboxes(); 
}


newgame.addEventListener("click", resetgame);
reset.addEventListener("click", resetgame);