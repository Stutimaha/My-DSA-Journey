class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        int n=nums.length; 
        int start=0; 
        int  end=start+1;
        
        if (n == 0) {
            return result; 
        }
        
        while(end<n){
            if (nums[end]-nums[end-1]==1){
                end++;
            }
            else{
                if (start == end - 1) {
                    result.add(String.valueOf(nums[start]));
                }
                else {
                    result.add(nums[start] + "->" + nums[end - 1]);
                }
                
                start = end;
                end = start + 1;
            }
        }
        
        if (start == end - 1) {
            result.add(String.valueOf(nums[start]));
        } else {
            result.add(nums[start] + "->" + nums[end - 1]);
        }
        return result;
    }
}