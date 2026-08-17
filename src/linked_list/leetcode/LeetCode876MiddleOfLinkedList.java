package linked_list.leetcode;
import linked_list.Node;
import linked_list.LinkedListFactory;

public class LeetCode876MiddleOfLinkedList {

    private int findOutTheSizeOfTheList(Node headListLinked){
        Node current = headListLinked;
        int sizeOfList = 0;
        while(current != null) {
            current = current.next;
            sizeOfList++;
        }
        return sizeOfList;
    }


    public Node middleOfLinkedList(Node headLinkedList) {
       int sizeOfList = findOutTheSizeOfTheList(headLinkedList);
       int middleOfList = (sizeOfList/2) + 1;

       Node current = headLinkedList;
       for (int i = 1; i <= sizeOfList; i++){
           if (i == middleOfList){
               return current;
           }else {
               current = current.next;
           }
       }

       return null;
    }

    public static void main(String[] args){
        LeetCode876MiddleOfLinkedList middle = new LeetCode876MiddleOfLinkedList();
        LinkedListFactory linkedList = new LinkedListFactory();
        Node middleNode = middle.middleOfLinkedList(linkedList.randomLinkedList(6));
        System.out.printf("The middle node of the list is node %d", middleNode.value);
    }
}
