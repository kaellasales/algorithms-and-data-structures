package linked_list.leetcode;

import linked_list.Node;

public class LeetCode002AddTwoNumbers {

    public Node addTwoNumbers(Node l1, Node l2) {

        Node dummy = new Node(0);
        Node current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int x = (l1 != null) ? l1.value : 0;
            int y = (l2 != null) ? l2.value : 0;

            int sum = x + y + carry;

            carry = sum / 10;

            Node newNode = new Node(sum % 10);

            current.next = newNode;
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            current.next = new Node(carry);
        }

        return dummy.next;
    }
}