class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res=0;
        int left =0;
        int right = n-1;
        int maxright =0;
        int maxleft = 0;
        
        while(left<=right){
            if (height[left]<=height[right]){
                if (height[left]>=maxleft) maxleft=height[left];
                else res+=maxleft-height[left];
                
                left++;
            }
                
            else{
                if (height[right]>=maxright) maxright=height[right];
                else res+=maxright-height[right];
                
                right--;
                }
            }
        return res;
    }
}