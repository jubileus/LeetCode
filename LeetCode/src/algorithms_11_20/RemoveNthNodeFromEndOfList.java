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
    	for(int i=0;i<n;i++){//��start��end��n+1��λ�ã���end==nullʱ��startָ���ɾ��Ԫ�صĸ��ڵ�
    		if(end.next==null)//Ҫɾ�����ǵ�һ���ڵ�
    			return head.next;
    		else//Ҫɾ���Ĳ��ǵ�һ���ڵ㣬endָ�����
    			end=end.next;
    	}
    	while(end.next!=null){//��end����һ���ڵ�δָ��nullʱ��֤����û�ҵ��˴�ɾ��Ԫ�صĸ��ڵ�
    		start=start.next;
    		end=end.next;
    	}
    	start.next=start.next.next;//����Ҫɾ���Ľڵ㣬�ع�����
    	return head;
    }
}
