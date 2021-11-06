# TicTacToe

# Assumption
Analyze the game state to determine if either of the players has already won the game or it is still ongoing, if the game is a draw, or if the user has entered an impossible game state (two winners, or with one player having made too many moves).

Get the 3x3 grid from the input as in the previous stages.
Output this 3x3 grid as in the previous stages.
Prompt the user to make a move.
The user should input 2 numbers that represent the cell where they want to place their X. (the 9 symbols representing the field will be the first line of input, and the 2 coordinate numbers will be the second line of input)
Analyze user input and show messages in the following situations:
This cell is occupied! Choose another one! if the cell is not empty.
You should enter numbers! if the user enters non-numeric symbols in the coordinates input.
Coordinates should be from 1 to 3! if the user enters coordinates outside the game grid.
Update the grid to include the user's move and print the updated grid to the console.
