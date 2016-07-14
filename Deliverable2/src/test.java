/**
 * Created by Derek on 7/13/16.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        printList(swapPairs(head));

    }

    private static void printList(ListNode head) {
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode left = head.next;
        ListNode right = left.next;
        while(left!=null&&right!=null){
            head.next = right;
            left.next = right.next;
            right.next = left;
            head = left;
            if(left.next==null)
                return dummy.next;
            left = left.next;
            if(left.next==null)
                return dummy.next;
            right = left.next;
        }
        return dummy.next;
    }
}
