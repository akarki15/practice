package leet;

public class SumNodes {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode = null;
        ListNode prevNode = null;
        ListNode nodeHead= null;
        
        int carryOver = 0; 
        boolean first = true; // keep track of head of the sumNode chain
        while (l1 !=null || l2 !=null){
            int sum = l1.val + l2.val + carryOver; 
            carryOver = sum /10;
            sum = sum % 10;
            curNode = new ListNode(sum);
            if (first){
                nodeHead = curNode; 
                first = false; 
            }else {
                prevNode.next = curNode; 
            }
            prevNode = curNode; 
        }
        if (carryOver>0){
            prevNode.next = new ListNode(carryOver);
        }
        return nodeHead;
    }
}


 
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
