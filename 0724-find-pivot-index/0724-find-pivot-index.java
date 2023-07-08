class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sumR = new int[n];
        int[] sumL = new int[n];
        int sumRight = 0;
        int sumLeft = 0;
        int idx = -1;
 
        for(int i=n-1;i>=0;i--){
            sumRight+=nums[i];
            sumR[i] = sumRight;
        }

        for(int i=0;i<n;i++){
            sumLeft+=nums[i];
            sumL[i] = sumLeft;
            if(sumL[i]==sumR[i]){
                idx = i;
                break;
            }        
        }
        return idx;
    }
}