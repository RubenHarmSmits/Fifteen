package Ruben;

import java.util.*;

public class Board {

    public int[][] grid = new int[4][4];
    Scanner scn = new Scanner(System.in);
    public int nulX;
    public int nulY;
    public ArrayList<Integer> rightTiles = new ArrayList();
    public int moves;
    public Random ran = new Random();

    public static void main(String[] args){
        Board board = new Board();
        board.printBoard();
        board.solve();
        board.printBoard();
        System.out.println(board.moves);
    }

    public Board(){
        setUpBoard();
        //play();
    }

    public void moveRandom(){
        int x = ran.nextInt(4);
        int y = ran.nextInt(4);
        if(!tileIsRight(x,y)) {
            move(x,y);
            moves++;
        }
    }

    public void solve(){
        outerloop: for(int een=0;een<2;een++){
            for(int twee=0;twee<4;twee+=2){
                while(grid[een][twee]!=(15-(4*een+twee))|grid[een][twee+1]!=(15-(4*een+twee+1))){
                    moveRandom();
                }
                rightTiles.add(4*een+twee);
                rightTiles.add(4*een+twee+1);

            }
        }
//        while(!isSolved()){
//           moveRandom();
//        }

    }

    public boolean isSolved() {
        for(int y = 0; y < 4; y++){
            for (int x = 0; x < 4; x++){
                if (x == 3 && y == 3) return true;
                else if(grid[y][x]!=15-(4*y+x)) return false;
            }
        }
        return true;
    }

    public boolean tileIsRight(int x, int y){
        for(int i : rightTiles){
            if(i==4*x+y) return true;
        }
        return false;
    }

    public void play(){
        while(true){
            printBoard();
            System.out.println("Welk nummer kies je?");
            int x = scn.nextInt();
            int y = scn.nextInt();
            move(x,y);
        }
    }

    public void setUpBoard(){
        ArrayList<Integer> nummers = new ArrayList<Integer>();
        for(int i=0;i<16;i++) nummers.add(i);
        for(int x=0;x<4;x++){
            for(int y=0;y<4;y++){
                grid[x][y]= nummers.get(4*x+y);
            }
        }
        shuffle();
    }
    public void shuffle(){
        int i =0;
        while(i<1000){
            Random ran = new Random();
            int x = ran.nextInt(4);
            int y = ran.nextInt(4);
            move(x,y);
            i++;
        }
    }

    public void printBoard() {
        for(int x=0;x<4;x++){
            System.out.println(grid[x][0]+" | "+grid[x][1]+" | "+grid[x][2]+" | "+grid[x][3]);
        }
    }

    public void getNulCoordinaten(){
        for(int x=0;x<4;x++){
            for(int y=0;y<4;y++){
                if(grid[x][y]==0){
                    nulX=x;
                    nulY=y;
                }
            }
        }
    }

    public boolean checkIfChangable(int x,int y){
        if (Math.abs(x - nulX) == 1 & y == nulY) {
            return true;
        }
        if (Math.abs(y - nulY) == 1 & x == nulX) {
            return true;
        }
        return false;
    }

    public void move(int x, int y){
        getNulCoordinaten();
        if(checkIfChangable(x,y)){
            grid[nulX][nulY] = grid[x][y];
            grid[x][y] = 0;
        }
        nulY=0;
        nulX=0;
    }
}
