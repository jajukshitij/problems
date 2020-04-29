public class AddTwoNumbers {

    // https://www.youtube.com/watch?v=LLPuC5kWD8U#action=share

    //-------------------------------------- Time Complexity  O(m + n) -> m and n = number of nodes in l1 and l2 respectively. -------------------------------------------


    public static  class ListNode {
        public int value;
        public ListNode next;


        public ListNode(int val) {
            this.value = val;
            this.next = null;
        }

        public ListNode() {
            this.value = -1;
            this.next = null;
        }
    }

    public static void main(String args[]) {
        ListNode list1 = new ListNode();
        // creating first list
        list1 = new ListNode(7);
        list1.next = new ListNode(5);
        list1.next.next = new ListNode(9);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(6);
        System.out.print("First List is ");
        print(list1);

        // creating seconnd list
        ListNode list2 = new ListNode(8);
        list2.next = new ListNode(4);
        System.out.print("Second List is ");
        print(list2);

        // add the two lists and see the result
        ListNode rs = addTwoNumbers(list1, list2);
        System.out.print("Resultant List is ");
        print(rs);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;

        while(l1 != null || l2!= null || carry !=0){

            int sum = ((l1==null) ? 0 : l1.value )+ ((l2==null)? 0 : l2.value) + carry;
            result.next = new ListNode(sum%10);
            carry = sum /10;

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 !=null){
                l2 = l2.next;
            }

            result = result.next; // Advance result
        }
        return head.next;
    }


    /*ListNode head = new ListNode(0);
        ListNode result = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int resVal = (l1 != null? l1.val : 0) + (l2 != null? l2.val : 0) + carry;
            result.next = new ListNode(resVal % 10);
            carry = resVal / 10;
            l1 = (l1 == null ? l1 : l1.next);
            l2 = (l2 == null ? l2 : l2.next);
            result = result.next;
        }

        return head.next;*/

    static void print(ListNode start) {
        ListNode ptr = start;
        while (ptr != null)
        {
            System.out.println("Data = " + ptr.value);
            ptr = ptr.next;
        }
    }
}
