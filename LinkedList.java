public class LinkedList {

    private Node head;  // Head of the linked list, which represents the start of the board

    // Constructor to initialize an empty linked list (board with 9 nodes)
    public LinkedList() {
        this.head = null;  // Initially, the board is empty with no nodes when the game begins
        // Initializes the board with 9 empty nodes (one for each position in the 3x3 grid)
        for (int i = 1; i <= 9; i++) {
            insertAtEnd("");  // Inserts an empty string for each node (cell)
        }
    }

    // Methods to insert a new node at the end of the linked list
    public void insertAtEnd(String data) {
        Node newNode = new Node(data);  // Creates a new node with the given data (either X, O, or "blank")
        if (head == null) {
            head = newNode;  // If the list is empty, set the new node as the head
        } else {
            Node current = head;  // Starts from the head of the list
            // Traverses to the end of the list
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;  // Links the new node at the end of the list
        }
    }

    // Method to update a specific position in the list (position 1-9) with the player's move
    public void updatePosition(int position, String data) {
        Node current = head;  // Starts from the head of the list
        int count = 1;
        // Traverse to the desired position
        while (current != null && count < position) {
            current = current.next;
            count++;
        }
        // If the node at the position exists, updates its data
        if (current != null) {
            current.data = data;
        }
    }

    // Method to get the value at a specific position (1-9)
    public String getPositionValue(int position) {
        Node current = head;  // Starts from the head of the list
        int count = 1;
        // Traverse to the desired position
        while (current != null && count < position) {
            current = current.next;
            count++;
        }
        // Returns the data at the current position or an empty string if the position is invalid
        return (current != null) ? current.data : "";
    }

    // Method to display the Tic Tac Toe board in a 3x3 grid format with horizontal lines
    public void displayBoard() {
        Node current = head;  // Start from the head of the list
        int count = 1;

        // Traverse the list and print each node's value
        while (current != null) {
            // Print the current node's value or a space if the value is empty
            System.out.print(current.data.isEmpty() ? " " : current.data);

            // Print separator between cells
            if (count % 3 != 0) {
                System.out.print(" | ");
            }

            // Move to the next node
            current = current.next;
            count++;

            // Print horizontal line after every third cell to create a 3x3 grid
            if (count % 3 == 1 && count != 1) {
                System.out.println();  // Moves to the next line
                System.out.println("---------");  // Prints horizontal line separator
            }
        }
        System.out.println();  // Ensure the final line ends with a newline
    }

    // Method to check if there is a winning combination on the board
    public boolean checkWinCondition() {
        // Check all possible winning combinations: rows, columns, and diagonals
        return checkCombination(1, 2, 3) || checkCombination(4, 5, 6) || checkCombination(7, 8, 9) || // Rows
                checkCombination(1, 4, 7) || checkCombination(2, 5, 8) || checkCombination(3, 6, 9) || // Columns
                checkCombination(1, 5, 9) || checkCombination(3, 5, 7);                                // Diagonals
    }

    // Helper method to check if three specific positions have the same value (either x or o) and are not empty
    private boolean checkCombination(int pos1, int pos2, int pos3) {
        // Get the values at the three specified positions
        String value1 = getPositionValue(pos1);
        String value2 = getPositionValue(pos2);
        String value3 = getPositionValue(pos3);

        return !value1.isEmpty() && value1.equals(value2) && value2.equals(value3);
    }

    // Method to check if the board is full (for a draw condition)
    public boolean isBoardFull() {
        Node current = head;  // Start from the head of the list
        // Traverse the list
        while (current != null) {
            // If any node contains an empty string, the board is not full
            if (current.data.isEmpty()) {
                return false;  // There's at least one empty cell
            }
            current = current.next;  // Move to the next node
        }
        return true;  // No empty cells left, the board is full
    }

    // Method to reset the board for a new game by clearing all nodes' values
    public void resetBoard() {
        Node current = head;  // Start from the head of the list
        // Traverse the list and reset each node's value to an empty string
        while (current != null) {
            current.data = "";
            current = current.next;
        }
    }
}
