class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;  

        int jumps = 0;
        int currentJumpEnd = 0;  
        int farthestJump = 0;    

        for (int i = 0; i < n - 1; i++) {
            farthestJump = Math.max(farthestJump, i + nums[i]);


            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthestJump;
            }
        }

        return jumps;
    }

}