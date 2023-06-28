class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        double ans = 0;
        
        int[] nums = new int[n1+n2];
        
        for(int i=0; i<n1; i++){
            nums[i]=nums1[i];
        }
        for(int i=0; i<n2; i++){
            nums[n1+i]=nums2[i];
        }
        
        Arrays.sort(nums);
        
        int start = 0;
        int end = n1+n2-1;
        int mid = start+end/2;
        
        if((n1+n2)%2==1){
            ans = (double) nums[mid];
        }
        else{
            ans = (double) (nums[mid]+nums[mid+1])/2;
        }
        //System.out.print(Arrays.toString(nums));
        return ans;
    }
}