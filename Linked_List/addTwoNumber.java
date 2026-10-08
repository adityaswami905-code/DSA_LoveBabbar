package DSA_LoveBabbar.Linked_List;

public class addTwoNumber {

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val){

            this.val = val;
            this.next = null;

        }
    }

    static ListNode addTwoNumbersOfLL(ListNode l1, ListNode l2){

        int carry = 0;
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        while( l1 != null || l2 != null || carry != 0 ){
            int sum = 0;
            if( l1 != null ){
                sum = sum + l1.val;
                l1 = l1.next;

            }

            if( l2 != null ){
                sum = sum + l2.val;
                l2 = l2.next;

            }

            sum = sum + carry;
            int digit = sum % 10;

            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            newTail.next = newNode;
            newTail = newNode;

            //

        }
        newHead = newHead.next;

        return newHead;
    }

    static void main() {

        addTwoNumber obj = new addTwoNumber();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        ListNode modifiedHead = obj.addTwoNumbersOfLL(l1,l2);

        System.out.print("LL after adding two number: ");

        while ( modifiedHead != null ){

            System.out.print(
                    modifiedHead.val + " -> "
            );
            modifiedHead = modifiedHead.next;
        }
        System.out.println("Null");
    }
}
