//Umer Kamran
//CSC229
//In short Explanation:
//TicTacToe Class: The main class responsible for managing the game flow.
//Constructor: Initializes the linked list board and sets the starting player to X".
//switchPlayer(): Alternates the current player after each valid move.
//playerMove(): Prompts the player to enter a move, validates the input, and updates the board with the player's mark.
//playGame(): The main game loop that alternates between players, checks for a winner or draw, and displays the board after each turn.
//Main Method: The entry point of the program that creates a game instance and starts it.

import java.util.Scanner;

public class TicTacToe {

    private LinkedList board;  // This is the The Tic Tac Toe board, represented by a linked list
    private String currentPlayer;  // X or O, keeps track of whose turn it is

    // Constructor to initialize the game
    public TicTacToe() {
        board = new LinkedList();  // Create a new linked list to represent the board
        currentPlayer = "X";  // X always starts the game first
    }

    // Method to switch between players after each turn
    private void switchPlayer() {
        // If the current player is X, switch to O otherwise, switch back to X
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    // Method to get the current player's move and update the board
    private void playerMove() {
        Scanner scanner = new Scanner(System.in);  // Create a scanner to capture user input
        int move;

        // this block of code loops until the player enters a valid move (1-9) and the selected position is empty
        do {
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            move = scanner.nextInt();  // Gets the player's move (an integer)
        } while (move < 1 || move > 9 || !board.getPositionValue(move).isEmpty());

        // Updates the board with the player's move at the given position
        board.updatePosition(move, currentPlayer);
    }

    // Method to start and run the game
    public void playGame() {
        boolean gameWon = false;  // Tracks if the game is won
        boolean gameDraw = false;  // Tracks if the game ends in a draw

        // The game continues until there is a winner or a draw
        while (!gameWon && !gameDraw) {
            // Display the current state of the board
            board.displayBoard();

            // Gets the player's move and update the board
            playerMove();

            // Checks if the current player has won the game
            gameWon = board.checkWinCondition();

            if (gameWon) {
                // If the player wins, this displays the final board and annonce the winner
                board.displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                // Checks if the board is full and the game is a draw
                gameDraw = board.isBoardFull();

                if (gameDraw) {
                    // If it's a draw, it display the final board and announce the draw
                    board.displayBoard();
                    System.out.println("The game is a draw!");
                } else {
                    // If no win or draw, it switch to the other player and continue the game
                    switchPlayer();
                }
            }
        }
    }

    // Main method to run the game
    public static void main(String[] args) {
        // Create an instance of TicTacToe and start the game
        TicTacToe game = new TicTacToe();
        game.playGame();  // Call the playGame method to begin
    }
}
