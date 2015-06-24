package algorithms_20_30;

public class ReverseNodesInKGroup {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		ListNode test=new ListNode(1);
		ListNode head=test;
		for(int i=2;i<=2;i++){
			test.next=new ListNode(i);
			test=test.next;
		}
		ListNode rs=reverseKGroup(head, 2);
		while(rs!=null){
			rs=rs.next;
		}
	}

    public static ListNode reverseKGroup(ListNode head, int k) {
    	if(head==null || k==1)//���������1���ڵ�Ϊ��ת��λ��ֱ�ӷ���
    		return head;  
        ListNode start = new ListNode(0);//����һ���ٵ�ͷ���start
        start.next = head;//��ͷ�����ӵ�ԭ����ͷ��  
        ListNode pre = null;  
        ListNode cur = head;  
        ListNode next = null;  
        ListNode end = null;  
        head = start;//��startָ��Ϊ�µ�head�ڵ�  
        while( cur != null) {//cur��Ϊ��ʱ������û�б������            
            int i=k-1;  
            end = cur;  
            while(i>0 && end != null ){//��end���ʣ��ڵ������Ƿ�С��k  
                end = end.next;  
                i--;
            }  
            if(end==null)//��endΪ��ʱ��֤��ʣ��ڵ�����������з�ת������ֱ�ӷ��� 
            	return head.next;   
            i=k;  
            while(i>0) {  
                next = cur.next;//nextָ������ƶ�һ���ڵ�  
                cur.next = pre;//�õ�ǰ�ڵ��ָ��ָ��pre  
                pre = cur;//��pre��Ϊ�µ�cur  
                cur = next;//curָ������ƶ�һ���ڵ�  
                i--;
            }  
            start.next.next = cur;//��������Ĳ�����Ϊ�����Ĳ�����������
            ListNode t = start.next;//����start��pre��λ��  
            start.next = pre;  
            start = t;  
        }    
        return head.next;//�����ٵ�ͷ���start�����غ�������  
    }
    
}
