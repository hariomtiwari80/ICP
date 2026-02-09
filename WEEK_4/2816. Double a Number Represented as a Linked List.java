class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode temp=head;
        ListNode prev=null;
         while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
             prev=temp;
             temp=next;
         }
        head=prev;
       int carry=0;
       temp=head;
       prev=null;
       while(temp!=null)
       {
        int val=temp.val*2;
        if(val+carry<10)
        {
            temp.val=val+carry;
            prev=temp;
            carry=0;
            temp=temp.next;
        }
        else{
            temp.val=(val+carry)%10;
            carry=(val+carry)/10;
            prev=temp;
            temp=temp.next;
        }
       }
       if(carry!=0)
       prev.next=new ListNode(carry);
       prev=null;
       temp=head;
       while(temp!=null)
       {
        ListNode next=temp.next;
        temp.next=prev;
       prev=temp;
       temp=next;
       }
       return prev;
    }
}
