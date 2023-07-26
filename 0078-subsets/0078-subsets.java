class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        Arrays.sort(nums); 
        findSubsetsHelper(nums, 0, currentSubset, result);
        return result;
    }

    private void findSubsetsHelper(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result){
        result.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates to avoid generating duplicate subsets
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            currentSubset.add(nums[i]);
            findSubsetsHelper(nums, i + 1, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}