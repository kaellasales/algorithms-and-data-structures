package linked_list;
import java.util.Random;

public class LinkedListFactory {
    public Node randomLinkedList(int size){
        Random random = new Random();
        Node headList = null;
        Node currentNode = null;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                currentNode = new Node(random.nextInt(100));
                headList = currentNode;
            } else {
                currentNode.next = new Node(random.nextInt(100));
                currentNode = currentNode.next;
            }

        }
        return headList;
    }
}

