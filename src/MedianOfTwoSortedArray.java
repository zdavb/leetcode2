/**
 * Created by dave on 2015/10/4.
 */
public class MedianOfTwoSortedArray {
    private int findKthElement(int[] nums1,int[] nums2,int k,int nums1Left,int nums1Len,int nums2Left,int nums2Len){
        int len1 = nums1Len - nums1Left;
        int len2 = nums2Len - nums2Left;
        if(len1<len2)
            return findKthElement(nums2,nums1,k,nums2Left,nums2Len,nums1Left,nums1Len);

        if(len2 == 0)
            return nums1[k-1];
        if(k == 1)
            return Math.min(nums1[nums1Left],nums2[nums2Left]);

        int num2ptr = Math.min(len2,k/2);
        int num1ptr = k-num2ptr;
        int val1 = nums1[nums1Left+num1ptr-1];
        int val2 = nums2[nums2Left+num2ptr-1];

        if(val1==val2)
            return val1;
        else if(val1>val2)
            return findKthElement(nums1,nums2,k-num2ptr,nums1Left,nums1Len,nums2Left+num2ptr,nums2Len);
        else
            return findKthElement(nums1,nums2,k-num1ptr,nums1Left+num1ptr,nums1Len,nums2Left,nums2Len);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        if(length%2==1)//odd
            return findKthElement(nums1,nums2,length/2+1,0,nums1.length,0,nums2.length);
        else
            return (findKthElement(nums1,nums2,length/2,0,nums1.length,0,nums2.length)
            +findKthElement(nums1,nums2,length/2+1,0,nums1.length,0,nums2.length))*0.5;
    }
    public void test(){
        int[] num1 = {1,2};
        int[] num2 = {1,2};
        System.out.println(findMedianSortedArrays(num1,num2));
    }
}
