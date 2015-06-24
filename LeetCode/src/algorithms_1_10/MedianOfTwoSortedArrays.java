package algorithms_1_10;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start_1=0,start_2=0;
        int mid1=0,mid2=0;
        double end=((double)nums1.length+nums2.length)/2;
		while(start_1+start_2<end){
			if(start_1>=nums1.length){//
				mid1=nums2[start_2];
				start_2++;
			}else if(start_2>=nums2.length){
				mid1=nums1[start_1];
				start_1++;
			}else{
				if(nums1[start_1]<nums2[start_2]){
					mid1=nums1[start_1];
					start_1++;
				}else{
					mid1=nums2[start_2];
					start_2++;
				}
			}
		}
		if((nums1.length+nums2.length)%2==1){//nums1和nums2总长度为奇数
			mid2=mid1;
		}else if(start_1>=nums1.length){
			mid2=nums2[start_2];
		}else if(start_2>=nums2.length){
			mid2=nums1[start_1];
		}else if(nums1[start_1]<nums2[start_2]){
			mid2=nums1[start_1];
		}else{
			mid2=nums2[start_2];
		}
		return ((double)mid1+mid2)/2;
    }
}
