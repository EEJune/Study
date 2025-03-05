//학번: 22112120 이름: 서이준
class Solution {
    public ListNode findMid(ListNode head){
        ListNode ptr=head;
        ListNode dptr=head;
        ListNode mid=null;

        while(dptr!=null && dptr.next!=null){
            mid=ptr;
            ptr=ptr.next;
            dptr=dptr.next.next;
        }
        mid.next=null;
        return ptr;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null)return new TreeNode(head.val);

        ListNode mid=findMid(head);
        TreeNode node=new TreeNode(mid.val);

        if(head==mid)return node;
        node.left=sortedListToBST(head);
        node.right=sortedListToBST(mid.next);

        return node;
    }
}