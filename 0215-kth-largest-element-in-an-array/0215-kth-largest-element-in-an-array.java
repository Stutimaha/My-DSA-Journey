public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.add(num);
        }

        int kthLargest = 0;
        for (int i = 0; i < k; i++) {
            kthLargest = maxHeap.poll();
        }

        return kthLargest;
    }
}