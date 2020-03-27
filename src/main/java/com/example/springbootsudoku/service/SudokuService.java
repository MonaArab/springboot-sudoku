package com.example.springbootsudoku.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SudokuService {

    public boolean solve(int [][] board){
        for(int row = 0;row<9;row++) {
            for (int column = 0; column < 9; column++) {
                if(board[row][column] == 0){
                    for (int value = 1; value < 10; value++) {
                        board[row][column] = value;
                        boolean isValid = isValid(value, row, column,board);
                        if (isValid && solve(board)) {
                            return true;
                        }
                        board[row][column] = 0;
                     }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(int value, int row, int column, int[][] board){
        List<Integer> rowNeighbour = new ArrayList<>();
        List<Integer> columnNeighbour = new ArrayList<>();
        List<Integer> boxNeighbour = new ArrayList<>();
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(i == row && j != column){
                    rowNeighbour.add(board[i][j]);
                }
                if(j == column && i != row){
                    columnNeighbour.add(board[i][j]);
                }
                if( row/3 == i / 3
                        && j/3 == column / 3){
                    if(i == row && j == column){
                        continue;
                    }else {
                        boxNeighbour.add(board[i][j]);
                    }

                }
            }
        }
        if(boxNeighbour.contains(value)
                || columnNeighbour.contains(value)
                || rowNeighbour.contains(value)){
            return false;
        }
        return true;
    }
}
