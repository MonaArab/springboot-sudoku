package com.example.springbootsudoku.controller;

import com.example.springbootsudoku.mode.SudokuBoard;
import com.example.springbootsudoku.service.SudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SudokuController {

    @Autowired
    SudokuService service;
    @ModelAttribute("sudokuBoard")
    public SudokuBoard getSudokuBoard() {
        return new SudokuBoard();
    }

    @GetMapping(value = "/")
    public String getPuzzel(Model model){
        SudokuBoard sb = new SudokuBoard();
        model.addAttribute("puzzel" , sb.getBoard());
        return "index";
    }

    @GetMapping(value = "/solve")
    public String solvePuzzel(Model model){
        model.addAttribute("puzzel" ,getSudokuBoard().getBoard());
        SudokuBoard sb = new SudokuBoard();
        service.solve(sb.getBoard());
        model.addAttribute("solvePuzzel" , sb.getBoard());
        return "index";
    }
}
