package algorithms_20_30;

import algorithms_20_30.MergeTwoSortedLists.ListNode;

public class MergeKSortedLists {

	public static void main(String[] args) {

	}

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)//������ʱֱ�ӷ���null
        	return null;
        return split(lists, 0, lists.length-1);
    }
    
    private ListNode split(ListNode[] lists,int low,int high){
    	if(low<high){
    		int middle=(low+high)/2;//��lists���֣�ֱ������������ListNode
    		return mergeTwoLists(split(lists, low, middle), split(lists,middle+1,high));
    	}
    	return lists[low];//��low<highʱ��˵���ѷֽ���������ListNode
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)//����Ϊ�����մ�������null
        	return null;
        else if(l1==null&&l2!=null)//l1�ǿմ���l2���գ�����l2
        	return l2;
        else if(l2==null&&l1!=null)//l2�ǿմ���l1���գ�����l1
        	return l1;
        ListNode head=new ListNode(-1);//����ͷ���ڵ�
        ListNode start=new ListNode(-1);//������������ʼ�ڵ�
        head=start;
        while(l1!=null&&l2!=null){
        	if(l1.val<l2.val){//��l1<l2����l1ƴ��������ĩ��
    			start.next=l1;
    			l1=l1.next;
    		}else{//��l2<=l1����l2ƴ��������ĩ��
    			start.next=l2;
    			l2=l2.next;
    		}
        	start=start.next;
        }
        if(l1!=null)//l1��û�б�����ϣ���l1ʣ�µ�Ԫ��ƴ��������ĩ��
        	start.next=l1;
        if(l2!=null)//l2��û�б�����ϣ���l2ʣ�µ�Ԫ��ƴ��������ĩ��
        	start.next=l2;
        return head.next;//����ͷ���ڵ��һ����ʵ���Ԫ��
    }
}
