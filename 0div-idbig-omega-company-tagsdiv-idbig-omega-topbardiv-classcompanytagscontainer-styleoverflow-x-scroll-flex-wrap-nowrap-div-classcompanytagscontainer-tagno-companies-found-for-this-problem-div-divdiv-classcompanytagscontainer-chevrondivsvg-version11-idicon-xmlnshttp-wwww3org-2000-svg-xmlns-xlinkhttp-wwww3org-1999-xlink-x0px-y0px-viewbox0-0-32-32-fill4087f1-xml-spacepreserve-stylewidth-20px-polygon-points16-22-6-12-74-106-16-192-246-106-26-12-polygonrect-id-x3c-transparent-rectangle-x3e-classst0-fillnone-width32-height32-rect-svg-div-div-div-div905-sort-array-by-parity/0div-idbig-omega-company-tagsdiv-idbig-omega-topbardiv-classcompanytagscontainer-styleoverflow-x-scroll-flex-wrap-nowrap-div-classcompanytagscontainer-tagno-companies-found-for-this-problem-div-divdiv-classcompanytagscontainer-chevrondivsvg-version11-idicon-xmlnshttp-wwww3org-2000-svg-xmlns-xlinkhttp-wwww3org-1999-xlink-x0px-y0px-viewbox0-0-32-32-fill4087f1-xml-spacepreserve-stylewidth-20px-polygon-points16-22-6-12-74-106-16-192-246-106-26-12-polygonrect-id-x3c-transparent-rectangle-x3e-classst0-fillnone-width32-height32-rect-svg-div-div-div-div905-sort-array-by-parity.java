class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        
        for(int i : nums){
            if(i%2==0){
                even.add(i);
            }
            else{
                odd.add(i);
            }
        }
        
        for(int i = 0;i<nums.length;i++){
            if (!even.isEmpty()) {
                nums[i] = even.remove(0);
            }
            else{
                nums[i] = odd.remove(0);
            }
        }
        return nums;
    }
}