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
    	if(head==null || k==1)//空链表或以1个节点为反转单位，直接返回
    		return head;  
        ListNode start = new ListNode(0);//建立一个假的头结点start
        start.next = head;//将头结点添加到原链表头部  
        ListNode pre = null;  
        ListNode cur = head;  
        ListNode next = null;  
        ListNode end = null;  
        head = start;//将start指定为新的head节点  
        while( cur != null) {//cur不为空时，链表没有遍历完毕            
            int i=k-1;  
            end = cur;  
            while(i>0 && end != null ){//用end检测剩余节点数量是否不小于k  
                end = end.next;  
                i--;
            }  
            if(end==null)//当end为空时，证明剩余节点个数不够进行反转操作，直接返回 
            	return head.next;   
            i=k;  
            while(i>0) {  
                next = cur.next;//next指针向后移动一个节点  
                cur.next = pre;//让当前节点的指针指向pre  
                pre = cur;//让pre成为新的cur  
                cur = next;//cur指针向后移动一个节点  
                i--;
            }  
            start.next.next = cur;//将交换完的部分与为交换的部分链接起来
            ListNode t = start.next;//交换start与pre的位置  
            start.next = pre;  
            start = t;  
        }    
        return head.next;//跳过假的头结点start，返回后续链表  
    }
    
}
