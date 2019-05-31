var app = angular.module('app',[]);

app.controller('controller',function($scope){
    $scope.count = 0;
    $scope.addMove = function(){
        $scope.count++;
    }
})


var board;

fetchBoard();

function solve(){
    fetch("http://localhost:8085/webapi/myresource",{
        method: 'PUT',
        body: JSON.stringify(board),
        headers:{
            'Content-Type':'application/json'
        }
    }).then(res=> res.json()).then(res=>{
        board = res
        makeBoard();
        solve();
    })
}

function fetchBoard(){
    fetch("http://localhost:8085/webapi/myresource")
        .then(res => res.json())
        .then(res => {
            board=res
            makeBoard();
        });
}


function makeBoard(){
    for(var x=0;x<4;x++){
        for(var y=0;y<4;y++){
            document.getElementById(x.toString()+y.toString()).classList.remove("empty");
            document.getElementById(x.toString()+y.toString()).innerHTML =  board.grid[x][y];
            if(board.grid[x][y]==0) document.getElementById(x.toString()+y.toString()).classList.add("empty");
        }
    }
}

function move(x,y){
    fetch("http://localhost:8085/webapi/myresource?x="+x+"&y="+y,{
        method:'POST',
        body:JSON.stringify(board),
        headers:{
            'Content-Type':'application/json'
        }
    }).then(res=> res.json()).then(async res => {
        board = res
        await makeBoard();
        checkIfSolved();
    })
}

function checkIfSolved(){
    console.log("solving");
    fetch("http://localhost:8085/webapi/myresource/isSolved",{
        method: 'POST',
        body :JSON.stringify(board),
        headers:{
            'Content-Type':'application/json'
        }
    }).then(res=>
       res.json())
    .then(json=>{
        if(json) showWinner();
    })
}

function showWinner(){
    console.log("WInnaar!")
    window.alert("Gefeliciteerd, je hebt gewonnen!")
}

