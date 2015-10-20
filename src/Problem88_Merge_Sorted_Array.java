
public class Problem88_Merge_Sorted_Array {
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int l = m + n;
	        int offset = 0;
	        while(m >0 && n > 0){
	            if(nums1[m-1] >= nums2[n-1]){
	                nums1[l-1-offset] = nums1[m-1];
	                m--;
	            }
	            else{
	                nums1[l-1-offset] = nums2[n-1];
	                n--;
	            }
	            offset++;
	        }
	        if(m == 0){
	            for(int i = n-1; i >= 0; i--){
	                nums1[i] = nums2[i];
	            }
	        }
	    }
}
