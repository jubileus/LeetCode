package algorithms_20_30;

import algorithms_20_30.MergeTwoSortedLists.ListNode;

public class MergeKSortedLists {

	public static void main(String[] args) {

	}

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)//空数组时直接返回null
        	return null;
        return split(lists, 0, lists.length-1);
    }
    
    private ListNode split(ListNode[] lists,int low,int high){
    	if(low<high){
    		int middle=(low+high)/2;//将lists二分，直至分至单独的ListNode
    		return mergeTwoLists(split(lists, low, middle), split(lists,middle+1,high));
    	}
    	return lists[low];//当low<high时，说明已分解至单个的ListNode
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)//输入为两个空串，返回null
        	return null;
        else if(l1==null&&l2!=null)//l1是空串，l2不空，返回l2
        	return l2;
        else if(l2==null&&l1!=null)//l2是空串，l1不空，返回l1
        	return l1;
        ListNode head=new ListNode(-1);//建立头部节点
        ListNode start=new ListNode(-1);//建立链表创建开始节点
        head=start;
        while(l1!=null&&l2!=null){
        	if(l1.val<l2.val){//当l1<l2，将l1拼接在链表末端
    			start.next=l1;
    			l1=l1.next;
    		}else{//当l2<=l1，将l2拼接在链表末端
    			start.next=l2;
    			l2=l2.next;
    		}
        	start=start.next;
        }
        if(l1!=null)//l1还没有遍历完毕，将l1剩下的元素拼接在链表末端
        	start.next=l1;
        if(l2!=null)//l2还没有遍历完毕，将l2剩下的元素拼接在链表末端
        	start.next=l2;
        return head.next;//跳过头部节点第一个无实意的元素
    }
}
