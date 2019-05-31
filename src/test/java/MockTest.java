import Ruben.Board;
import Ruben.TodoBusinessImpl;
import Ruben.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class MockTest {

    @Test
    public void testTest(){

        Board mockList = mock(Board.class);
        //when(mockList.isSolved()).thenReturn(true);
        assertTrue(mockList.isSolved());
    }



}
