package com.example.springbootsudoku;

import com.example.springbootsudoku.mode.SudokuBoard;
import com.example.springbootsudoku.service.SudokuService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootSudokuApplication.class)
public class SudokuTest {

    @Autowired
    SudokuService service;

    @Test
    public void test() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        service.solve(sudokuBoard.getBoard());
        Assert.assertArrayEquals(sudokuBoard.getResult(),sudokuBoard.getBoard());
    }
}
