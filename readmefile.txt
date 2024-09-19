Program Overview
The Tic Tac Toe game is built using a singly linked list to represent the game board. Each node in the list corresponds to one of the 9 cells, and the game allows two players to alternately place their marks ('X' or 'O') on the board. The program checks for win conditions after each move, and the board is displayed after every turn.

Program Design
The program consists of the following key components:
Node Class: Each node represents a cell on the board with attributes:
position: Unique identifier (1-9).
value: Current cell state ('X', 'O', or empty).
next: Pointer to the next node in the list.
LinkedList Class: Manages the singly linked list representing the 3x3 game board. It supports:
displayBoard(): Prints the board in a 3x3 format.
updatePosition(int, String): Updates the specified cell with the player's mark.
checkWinCondition(): Checks for a win (rows, columns, diagonals).
isBoardFull(): Determines if the game is a draw.
TicTacToe Class: Handles the game flow, alternating player turns, validating moves, and checking win/draw conditions.

Challenges Faced
Linked List Traversal: Accessing specific cells in a linked list is less direct than in a 2D array, requiring traversal from the start. This was managed by creating helper methods to efficiently traverse the list.

Win Condition Logic: Since the linked list is linear, mapping node positions to the grid for win checks required extra logic and was a bit hard to implement, but was handled by identifying key node combinations for rows, columns, and diagonals.

Input Validation: Ensuring players entered valid positions (1-9) and unoccupied cells required careful input checks, which were handled using loops and validation functions.