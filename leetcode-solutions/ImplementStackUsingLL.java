/*
    Not on Leetcode
    
    Reference:
    https://www.youtube.com/watch?v=PjLp2BGDaeY
    https://www.techiedelight.com/stack-implementation-using-linked-list/
*/

// Creating a linked list with every new element in reverse order
// Starting with top = null ; new_val when added, new_value1 -> new_value2 ...
// Updating top to point the latest value

public class ImplementStackUsingLL {

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

    ListNode top = null;

    public void push(int x) {
        ListNode node = new ListNode(x);
        node.next = top;
        top = node;
    }

    public int pop() {
        if(!isEmpty()) {
            int pop = top.value;
            top = top.next;
            return pop;
        }else{
            return -1;
        }
    }

    public int peek() {
        if(!isEmpty()) {
            return top.value;
        }else{
            return -1;
        }
    }

    public boolean isEmpty() {
        if(top==null){
            return true;
        }else{
            return false;
        }
    }
}
