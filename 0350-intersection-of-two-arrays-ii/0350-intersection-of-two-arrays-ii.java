class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> count= new HashMap<>();
        
        for (int num: nums1){
            count.put(num, count.getOrDefault(num,0)+1);
        }
        
        ArrayList<Integer> intersection= new ArrayList<>();
        
        for (int num: nums2){
            if(count.containsKey(num) && count.get(num)>0){
                intersection.add(num);
                count.put(num, count.get(num)-1);
            }
        }
        
        int[] result =new int[intersection.size()];
        
        for (int i =0; i< intersection.size();i++){
            result[i]=intersection.get(i);
        }
        return result;
    }
}