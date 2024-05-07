package leetcodeProblems;

/**
 * @author Raian Rahman
 * @since 5/7/2024
 */
public class DoubleANumberRepresentedAsALinkedList {

    public ListNode doubleIt(ListNode head) {
        int carry = doubleNext(head);

        ListNode newNode = head;
        if (carry != 0) {
            newNode = new ListNode(carry, head);
        }

        return newNode;
    }

    private int doubleNext(ListNode node) {
        if (node == null) {
            return 0;
        }

        int doubleValue = node.val * 2 + doubleNext(node.next);

        node.val = doubleValue % 10;
        return doubleValue / 10;
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
