public class Node {
    String data;   // This will hold either X, O, or an empty string
    Node next;     // Pointer to the next node in the list

    // Constructor to initialize a new node with the given data
    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}
