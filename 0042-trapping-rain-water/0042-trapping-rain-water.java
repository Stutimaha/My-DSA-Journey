class Solution {
    public int trap(int[] height) {
        int right = height.length-1;
        int left = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int rainwater = 0;
        
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=maxLeft){
                    maxLeft = height[left];
                }
                else{
                    rainwater += maxLeft - height[left];
                }
                left++;
            }
            else{
                if(height[right]>=maxRight){
                    maxRight = height[right];
                }
                else{
                    rainwater += maxRight - height[right];
                }
                right--;
            }
        }
        return rainwater;
    }
}