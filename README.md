#Console-based Tic-Tac-Toe Game

Description:

This Java program implements a console-based Tic-Tac-Toe game, allowing two players to take turns placing their respective markers (X and O) on a 3x3 grid. The game displays the current state of the grid after each move.

Key Features:

Grid Initialization: The program initializes a 3x3 grid and displays it at the start of the game.

Turn-Based Gameplay: Players take turns placing their markers on the grid. The program alternates between X and O players.

Input Validation: The program checks user input to ensure it consists of valid integer coordinates within the range of 1 to 3.

Occupied Cell Handling: It detects if a selected cell is already occupied and prompts the user to choose another.

Winning Conditions: The program checks for horizontal, vertical, and diagonal lines of matching markers to determine a winner.

Draw Condition: If all cells are filled and no winner is determined, the game is declared a draw.

Impossible State Detection (Not Implemented): The program includes logic to detect an impossible state where one player wins and the other has too many moves.

Error Handling: The program provides error messages for invalid inputs, ensuring a smooth user experience.

Possible Upgrades:

Modularization: Break down the functionality into separate methods for better readability and maintainability.

Improved Input Validation: Add checks for out-of-range inputs and handle exceptions raised by the program.

Variable Naming: Use more descriptive variable names to improve code readability.

Documentation: Add high-level comments or a brief description at the beginning of the file to explain the program's purpose.

Overall, this program provides an interactive and functional console-based Tic-Tac-Toe game, offering an enjoyable gaming experience for two players. It serves as a foundation that can be further enhanced with additional features and improvements.
