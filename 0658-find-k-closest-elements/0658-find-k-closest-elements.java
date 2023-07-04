class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //int[] answer = new int[k];
        List<Integer> answer = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        int index = Arrays.binarySearch(arr, x);
        if (index < 0) {
            index = -index - 1;
        }

        left = index - 1;
        right = index;

        for (int i = 0; i < k; i++) {
            if (left >= 0 && (right >= arr.length || x - arr[left] <= arr[right] - x)) {
                answer.add(arr[left]);
                left--;
            } else { 
                answer.add(arr[right]);
                right++;
            }
        }
        Collections.sort(answer);
        return answer;
    }
}