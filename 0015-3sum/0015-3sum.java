// sort
//loop
//b+c=(-a)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i<nums.length-2;i++){//i will be for a here
            if(i == 0 || i>0 && nums[i]!=nums[i-1]){
                int low = i+1; //  will be b here
                int high = nums.length-1; // will be c here
                int sum = 0 - nums[i]; //b+c=(-a)
                
                while(low<high){
                    if (nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        
                        // to  avoid dulicate sets
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        
                        low++;
                        high--;                        
                    }
                    else if (nums[low]+nums[high]<sum) low++;
                    else high--;
                }
                
            }
        }
        return res;
    }
}



