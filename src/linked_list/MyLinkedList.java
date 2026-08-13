package linked_list;

public class MyLinkedList {
    Node head;
    Node current;
    Node temp;

    public static void main(String[] args) {
        int[] listData = {10, 20, 30};
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < listData.length; i++) {
            list.temp = new Node(listData[i]);
            if(i==0){
                list.head = list.temp;
                list.current = list.head;
            }else {
                list.current.next = list.temp;
                list.current = list.temp;
            }
        }

        list.current = list.head;
        while(true){
            System.out.println(list.current.value);
            if(list.current.next==null){
            break;
            }
            list.current = list.current.next;
        }
    }
}
