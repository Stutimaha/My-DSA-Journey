class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int n = nums.length;
        if (n==0) return res;
        
        Arrays.sort(nums);
        
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                long remaining_target= (long) target - (long)nums[i] - (long)nums[j];
                
                int left = j+1;
                int right = n-1;
                
                while (left<right){
                    int sum = nums[left]+nums[right];
                    
                    if (sum<remaining_target) left++;
                    else if (sum>remaining_target)right--;
                    else {
                        List<Integer> quad = new ArrayList<Integer>();
                        
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        
                        res.add(quad);
                        
                        while (left<right && nums[left]==quad.get(2)) ++left;
                        while (left<right && nums[right]==quad.get(3)) --right;
                    }
                }
                
                while (j+1<n && nums[j+1]==nums[j]) ++j;
            }
            while (i+1<n && nums[i+1]==nums[i]) ++i;
        }
        return res;
    }
}