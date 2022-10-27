package suanfa;

import org.junit.Test;

/**
 * @Description:
 * @author:ljh
 * @date:2022/8/8 23:55
 */

public class MainA {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode a1 = new ListNode(2);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(6);
        ListNode d1 = new ListNode(8);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        ListNode merge = Merge(a, a1);
        System.out.println(merge);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode FindKthToTail(ListNode head, int k) { //5,{1,2,3,4,5}
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        //这里将end的next改为next.next，也把pre的3-》4-》5改成 3-》5 因为是同一块地址 将3的next引用指向5的内存
        end.next = end.next.next;
        return pre.next;
    }


    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }


    int Fibonacci(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        int first = 1, second = 1, third = 0;
        for (int i = 3; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }


    @Test
    public void test() {
      int a = 1/2;
        System.out.println(a);
    }

    public boolean chazhao(int[][] a , int b) {
        int row = a.length;
        int col = a[0].length;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (a[i][j] == b) {
                    return true;
                }
            }
        }
        return false;

    }

}