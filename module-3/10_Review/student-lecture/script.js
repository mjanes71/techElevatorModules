const BOARD_SIZE = 7;

const boardSquares = [];

const hero =
{
    icon: '🦨',
    row: 0,
    col: 0,
    corpse: '👻',
    startRow: 0,
    startCol: 0
};

const enemy =
{
    icon: '👽',
    row: BOARD_SIZE -1,
    col: BOARD_SIZE -1,
    startRow: BOARD_SIZE -1,
    startCol: BOARD_SIZE -1
};

let savedValue = localStorage.getItem('gameCounter');
let gameCounter = 0;
if (savedValue !== undefined) {
    let gameCounter = Number(savedValue);
}


document.addEventListener('DOMContentLoaded', e => {
    setupBoard();
    displayCounter();
    document.body.addEventListener('click', restartGame);
    document.body.addEventListener('keyup', handleTurn);


});

function restartGame() {
    
    const square = boardSquares[hero.row][hero.col];
    square.style.backgroundColor = null;
    square.style.innerText = '';

    move(hero, hero.startRow, hero.startCol);
    move(enemy, enemy.startRow, enemy.startCol);

    displayCounter();

    document.body.addEventListener('keyup', handleTurn);

    gameCounter++;
    localStorage.setItem('gameCounter', String(gameCounter));
    displayCounter();

}

function handleTurn(event) {
    handleArrows(event);
    moveEnemy();
    checkForDeath();
    
}

function setupBoard() {
    const html = document.querySelector('html');
    html.style.setProperty('--grid-size', String(BOARD_SIZE)); //targets html element where we assigned a style property that we want to change
    const gameBoard = document.getElementById('gameBoard');

    for (let row = 0; row < BOARD_SIZE; row++) {
        boardSquares[row] = []; //initialize the array that will hold the items rol and col in the array of arrays....array array array
        for (let col = 0; col < BOARD_SIZE; col++) {
            const div = document.createElement('div');
            //div.innerText = row + ', ' + col;
            gameBoard.appendChild(div);
            boardSquares[row][col] = div; //two dimensional array (array made of arrays)
        }
    }

    move(hero, hero.row, hero.col);
    move(enemy, enemy.row, enemy.col);
}

function move(character ,row, col) {
    if (row >= 0 && col >= 0 && row < BOARD_SIZE && col < BOARD_SIZE) {
        boardSquares[character.row][character.col].innerText = ''; //removes character from current location
        character.row = row; // updates hero object row
        character.col = col; // updates hero object col
        boardSquares[character.row][character.col].innerText = character.icon; // updates boardsquares array with new hero location

    }

} 

function handleArrows(event) {
    if (event.key === 'ArrowRight') {
        move(hero, hero.row, hero.col + 1);
    }else if (event.key === 'ArrowLeft') {
        move(hero, hero.row, hero.col - 1);

    }else if (event.key === 'ArrowUp') {
        move(hero, hero.row -1, hero.col);

    }else if (event.key === 'ArrowDown') {
        move(hero, hero.row + 1, hero.col);

    }
}

function checkForDeath() {
    if(hero.row === enemy.row && hero.col === enemy.col) {
        boardSquares[hero.row][hero.col].innerText = hero.corpse;
        boardSquares[hero.row][hero.col].style.backgroundColor = 'red';
        document.body.removeEventListener('keyup', handleTurn); //stops skunk from moving anymore
        
    }
}

function moveEnemy() {
    let row = enemy.row;
    let col = enemy.col;
    if (hero.row > row) {
        row++;
    }else if (hero.row < row) {
        row--;
    }

    if (hero.col > col) {
        col++;
    }else if (hero.col < col) {
        col--;
    }

    move(enemy, row, col);
}

function displayCounter() {
    
    const section = document.getElementById('counter');
    section.innerText = `You have played ${gameCounter} times.`;
}