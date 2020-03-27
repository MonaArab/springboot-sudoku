# springboot-sudoku
This is a Sudoku game programmed using SpringBoot solves 9x9 puzzles.
This project uses backtracking algorithm to solve the puzzle by testing each cell for a valid solution.
The algorithm takes the first valid value and goes on with this approach until the puzzle is solved or there is no more valid value left. If there is no more valid value left 
 (but the puzzle is not solved yet) it tracks back to the last known valid value and tries another value.
If there's no violation of constraints, the algorithm moves to the next cell, fills in all potential solutions and repeats all checks.

