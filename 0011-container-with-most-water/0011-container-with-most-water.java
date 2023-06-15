class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater = -1;
        int left = 0;
        int right = n - 1;
        
        while(left<right){
                int water = (right - left) * Math.min(height[left],height[right]);
                maxWater= Math.max(water, maxWater);
                if (height[left]<height[right]){
                    left++;
                }
                else{
                    right--;
                }
        }
        
        return maxWater;
    }
}
