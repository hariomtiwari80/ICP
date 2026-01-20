// BRUTE FORCE
import java.util.Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] nums3=new int[m+n];
        int k=0;
        for(int i=0;i<m;i++){
            nums3[k++]=nums1[i];
        }
        for(int i=0;i<n;i++){
            nums3[k++]=nums2[i];
        }
        Arrays.sort(nums3);
        if(nums3.length%2!=0){
            return (double)nums3[nums3.length/2];
        }
        else{
            int middle1 = nums3[nums3.length / 2 - 1];
            int middle2 = nums3[nums3.length / 2];
            return (middle1 +  middle2) / 2.0;
        }
    }
}

// OPTIMAL APPROACH
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length)
        return findMedianSortedArrays(arr2, arr1);

        int n=arr1.length,m=arr2.length;
        int l=0,h=n;
        while(l<=h){
            int m1=l+(h-l)/2; 
            int m2=(n+m+1)/2 - m1; 
            int x1=m1==0?Integer.MIN_VALUE:arr1[m1-1];
            int x2=m2==0?Integer.MIN_VALUE:arr2[m2-1];
            int x3=m1==n?Integer.MAX_VALUE:arr1[m1];
            int x4=m2==m?Integer.MAX_VALUE:arr2[m2];

            if(x1<=x4 && x2<=x3){
                if((m+n)%2!=0){
                    return (double)Math.max(x1,x2);
                }
                else{
                    return (Math.max(x1,x2)+Math.min(x3,x4))/2.0;
                }
            }
            else if(x1>x4) h=m1-1;
            else l=m1+1;
        }
        return 0;
    }
}
