
import Ruben.Board;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class BoardTest{
    @Test
    public void testIsSolved(){
        Board board = new Board();
        board.grid = new int[][]{{15, 14, 13, 12}, {11, 10, 9, 8}, {7, 6, 5, 4}, {3, 2, 1, 0}};
        assertTrue(board.isSolved());
    }
    @Test
    public void testIsNotSolved(){
        Board board = new Board();
        board.grid = new int[][]{{15, 14, 13, 12}, {11, 10, 9, 8}, {7, 6, 5, 4}, {3, 2, 0, 1}};
        assertFalse(board.isSolved());
    }
    @Test
    public void SolveTest(){
        Board board = new Board();
        board.solve();
        assertTrue(board.isSolved());
    }
}