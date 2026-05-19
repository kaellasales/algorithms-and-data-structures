package data_structure;
class ListNode {
    int val;
    ListNode next;
}

public class LeetCode002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode current = dummy; // current recebe uma CÓPIA do ENDEREÇO

        int carry = 0;

        while (l1 != null || l2 != null) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int soma = x + y + carry;

            carry = soma / 10;

            ListNode newNode = new ListNode();
            newNode.val = soma % 10;

            current.next = newNode; // altera o objeto no endereço → dummy vê também

            current = current.next; // current aponta pra outro endereço → dummy NÃO muda

            if (l1 != null) {
                l1 = l1.next; // avança na lista linkada 1
            }

            if (l2 != null) {
                l2 = l2.next; // avança na lista linkada 1
            }
        }

        if (carry > 0) {
            current.next = new ListNode();
            current.next.val = carry;
        }

        return dummy.next;
    }
}
