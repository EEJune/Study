// 학번: 22112120 이름: 서이준
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode now=head;
        ListNode insort=new ListNode();
        insort.next=null;
        while(now!=null){
            ListNode save=now.next;
            ListNode point=insort;
            while(true){
                if(point.next==null)break;
                if(point.next.val> now.val){
                    break;
                }
                point=point.next;
            }
            now.next=point.next;
            point.next=now;
            now=save;
        }
        return insort.next;
    }
}
