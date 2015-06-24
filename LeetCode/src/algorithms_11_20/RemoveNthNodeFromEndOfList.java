package algorithms_11_20;

public class RemoveNthNodeFromEndOfList {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x){ 
			val = x; 
		}
	}

	public static void main(String[] args) {
		ListNode item=new ListNode(1);
		ListNode head=item;
		for(int i=2;i<=5;i++){
			item.next=new ListNode(i);
			item=item.next;
		}
		head=removeNthFromEnd(head, 4);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}

    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode start=head,end=head;
    	for(int i=0;i<n;i++){//将start与end错开n+1个位置，当end==null时，start指向待删除元素的父节点
    		if(end.next==null)//要删除的是第一个节点
    			return head.next;
    		else//要删除的不是第一个节点，end指针后移
    			end=end.next;
    	}
    	while(end.next!=null){//当end的下一个节点未指向null时，证明还没找到了待删除元素的父节点
    		start=start.next;
    		end=end.next;
    	}
    	start.next=start.next.next;//跳过要删除的节点，重构链表
    	return head;
    }
}
