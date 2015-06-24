package algorithms_20_30;

public class SwapNodesInPairs {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode start=head;
		for(int i=2;i<=4;i++){
			start.next=new ListNode(i);
			start=start.next;
		}
		
	}

    public static ListNode swapPairs(ListNode head) {
    	if(head==null)
    		return null;
    	if(head.next==null)
    		return head;
        ListNode first=head;
        ListNode second=first.next;
        ListNode last=null;
        head=second;//指定第二个节点为新链表的第一个节点
        while(true){
        	first.next=second.next;
        	second.next=first;
        	if(last!=null)//不是第一次交换，将last保存的上次交换的最后节点的指针指向新一轮交换后的头结点
        		last.next=second;
        	last=first;//将交换后的first指定为最后交换的节点last
        	if(first.next!=null)//非被交换的两个节点的后一个节点不是空节点，指定下一个节点为新的first
        		first=first.next;
        	else
        		break;//非被交换的两个节点的后一个节点是空节点，跳出循环
        	if(first.next!=null)//非被交换的两个节点后的第二个节点不是空节点，指定该节点为新的second
        		second=first.next;
        	else//非被交换的两个节点后的第二个节点是空节点，证明链表节点个数是奇数个，跳出循环
        		break;
        }
        return head;
    }
}
