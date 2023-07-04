class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> answer = new ArrayList<>(k);
        int left = 0;
        int right = arr.length-1;
        while(right-left>=k){
            if(Math.abs(arr[left]-x)>Math.abs(arr[right]-x)){
                left++;
            }
            else{
                right--;
            }
        }
        
        for(int i = left; i<=right;i++){
            answer.add(arr[i]);
        }
        
        return answer;
    }
}

