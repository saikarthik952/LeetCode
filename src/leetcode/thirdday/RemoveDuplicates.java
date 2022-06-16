package leetcode.thirdday;

public class RemoveDuplicates {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        /**
         * Given the head of a sorted linked list,
         * delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
         */
        final ListNode head = buildList();
        ListNode temp = head;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        ListNode removeDups = removeDupsUtil(head);
        System.out.println("-----------------------------------------------------------------------------------------");

        temp = removeDups;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    private static ListNode removeDupsUtil(ListNode head) {

        if (head == null || head.next ==  null) return head;

        ListNode next = head.next;

        if (head.val == next.val) {
            while (next != null && next.val == head.val) next = next.next;
            return removeDupsUtil(next);
        }
        else {
            head.next = removeDupsUtil(next);
            return head;
        }
    }

    private static ListNode buildList() {
        ListNode listNode = new ListNode(1, null);
        ListNode head = listNode;
        for (int i = 0; i <3; i++) {
            ListNode newNode =  new ListNode(2, null);
            listNode.next = newNode;
            listNode = listNode.next;
        }
        for (int i = 0; i <3; i++) {
            ListNode newNode =  new ListNode(3, null);
            listNode.next = newNode;
            listNode = listNode.next;
        }
        for (int i = 0; i <3; i++) {
            ListNode newNode =  new ListNode(4, null);
            listNode.next = newNode;
            listNode = listNode.next;
        }
        for (int i = 0; i <1; i++) {
            ListNode newNode =  new ListNode(5, null);
            listNode.next = newNode;
            listNode = listNode.next;
        }
        return head;
    }
}
