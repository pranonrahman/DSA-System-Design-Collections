package leetcodeProblems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Raian Rahman
 * @since 5/6/2024
 */
public class RemoveNodesFromLinkedList {

    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode node = head;

        while (node != null) {
            while (!stack.isEmpty() && stack.peekLast().val < node.val) {
                    stack.pollLast();
            }

            stack.addLast(node);
            node = node.next;
        }

        head = stack.isEmpty() ? null : stack.pollFirst();
        ListNode current = head;

        while (!stack.isEmpty()) {
            current.next = stack.pollFirst();
            current = current.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
}
