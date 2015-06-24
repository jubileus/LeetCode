package algorithms_01_10;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(8);
		ListNode l1_start=l1;
		l1.next=new ListNode(9);
		l1=l1.next;
		l1.next=new ListNode(9);
//		
//		ListNode l2=new ListNode(5);
//		ListNode l2_start=l2;
//		l2.next=new ListNode(6);
//		l2=l2.next;
//		l2.next=new ListNode(4);
		
		ListNode l2_start=new ListNode(2);
		
		ListNode rs=addTwoNumbers(l1_start,l2_start);
		while(rs!=null){
			System.out.print(rs.val+" ");
			rs=rs.next;
		}
		
//		while(l1_start!=null){
//			System.out.print(l1_start.val+" ");
//			l1_start=l1_start.next;
//		}
//		while(l2_start!=null){
//			System.out.print(l2_start.val+" ");
//			l2_start=l2_start.next;
//		}
	}

	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode rs=new ListNode(-1);
		ListNode start=rs;
		if(l1!=null&&l2==null){//��l2Ϊ�գ�l1��Ϊ��ʱ��ֱ�ӷ���l2
			return l1;
		}else if(l1==null&&l2!=null){//��l1Ϊ�գ�l2��Ϊ��ʱ��ֱ�ӷ���l1
			return l2;
		}else{
			while(l1!=null||l2!=null){
				if(l1!=null&&l2==null){//l2�������,l1û�б������
					int quotient=l1.val/10;//��
					int cary=l1.val%10;//����
					rs.next=new ListNode(cary);
					rs=rs.next;
					if(l1.next==null){
						if(quotient!=0)
							l1.next=new ListNode(quotient);
						l1=l1.next;
					}else{
						l1=l1.next;
						l1.val+=quotient;
					}
				}else if(l1==null&&l2!=null){//l1�������,l2û�б������
					int quotient=l2.val/10;//��
					int cary=l2.val%10;//����
					rs.next=new ListNode(cary);
					rs=rs.next;
					if(l2.next==null){
						if(quotient!=0)
							l2.next=new ListNode(quotient);
						l2=l2.next;
					}else{
						l2=l2.next;
						l2.val+=quotient;
					}
				}else{//���������û�б������
					int sum=l1.val+l2.val;
					int quotient=sum/10;//��
					int cary=sum%10;//����
					rs.next=new ListNode(cary);
					rs=rs.next;
					if(l1.next!=null){//��l1����һλ��Ϊ��ʱ������λ�ӵ�l1����һλ��
						l1=l1.next;
						l1.val+=quotient;
						l2=l2.next;
					}else if(l2.next!=null){//��l2����һλ��Ϊ��ʱ������λ�ӵ�l1����һλ��
						l2=l2.next;
						l2.val+=quotient;
						l1=l1.next;
					}else{
					    l1=l1.next;
					    l2=l2.next;
					    if(quotient!=0){
					    	rs.next=new ListNode(quotient);
							rs=rs.next;
					    }
					}
				}
			}
		}
		return start.next;
    }
	
}
