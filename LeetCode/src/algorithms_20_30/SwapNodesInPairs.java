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
        head=second;//ָ���ڶ����ڵ�Ϊ������ĵ�һ���ڵ�
        while(true){
        	first.next=second.next;
        	second.next=first;
        	if(last!=null)//���ǵ�һ�ν�������last������ϴν��������ڵ��ָ��ָ����һ�ֽ������ͷ���
        		last.next=second;
        	last=first;//���������firstָ��Ϊ��󽻻��Ľڵ�last
        	if(first.next!=null)//�Ǳ������������ڵ�ĺ�һ���ڵ㲻�ǿսڵ㣬ָ����һ���ڵ�Ϊ�µ�first
        		first=first.next;
        	else
        		break;//�Ǳ������������ڵ�ĺ�һ���ڵ��ǿսڵ㣬����ѭ��
        	if(first.next!=null)//�Ǳ������������ڵ��ĵڶ����ڵ㲻�ǿսڵ㣬ָ���ýڵ�Ϊ�µ�second
        		second=first.next;
        	else//�Ǳ������������ڵ��ĵڶ����ڵ��ǿսڵ㣬֤������ڵ������������������ѭ��
        		break;
        }
        return head;
    }
}
