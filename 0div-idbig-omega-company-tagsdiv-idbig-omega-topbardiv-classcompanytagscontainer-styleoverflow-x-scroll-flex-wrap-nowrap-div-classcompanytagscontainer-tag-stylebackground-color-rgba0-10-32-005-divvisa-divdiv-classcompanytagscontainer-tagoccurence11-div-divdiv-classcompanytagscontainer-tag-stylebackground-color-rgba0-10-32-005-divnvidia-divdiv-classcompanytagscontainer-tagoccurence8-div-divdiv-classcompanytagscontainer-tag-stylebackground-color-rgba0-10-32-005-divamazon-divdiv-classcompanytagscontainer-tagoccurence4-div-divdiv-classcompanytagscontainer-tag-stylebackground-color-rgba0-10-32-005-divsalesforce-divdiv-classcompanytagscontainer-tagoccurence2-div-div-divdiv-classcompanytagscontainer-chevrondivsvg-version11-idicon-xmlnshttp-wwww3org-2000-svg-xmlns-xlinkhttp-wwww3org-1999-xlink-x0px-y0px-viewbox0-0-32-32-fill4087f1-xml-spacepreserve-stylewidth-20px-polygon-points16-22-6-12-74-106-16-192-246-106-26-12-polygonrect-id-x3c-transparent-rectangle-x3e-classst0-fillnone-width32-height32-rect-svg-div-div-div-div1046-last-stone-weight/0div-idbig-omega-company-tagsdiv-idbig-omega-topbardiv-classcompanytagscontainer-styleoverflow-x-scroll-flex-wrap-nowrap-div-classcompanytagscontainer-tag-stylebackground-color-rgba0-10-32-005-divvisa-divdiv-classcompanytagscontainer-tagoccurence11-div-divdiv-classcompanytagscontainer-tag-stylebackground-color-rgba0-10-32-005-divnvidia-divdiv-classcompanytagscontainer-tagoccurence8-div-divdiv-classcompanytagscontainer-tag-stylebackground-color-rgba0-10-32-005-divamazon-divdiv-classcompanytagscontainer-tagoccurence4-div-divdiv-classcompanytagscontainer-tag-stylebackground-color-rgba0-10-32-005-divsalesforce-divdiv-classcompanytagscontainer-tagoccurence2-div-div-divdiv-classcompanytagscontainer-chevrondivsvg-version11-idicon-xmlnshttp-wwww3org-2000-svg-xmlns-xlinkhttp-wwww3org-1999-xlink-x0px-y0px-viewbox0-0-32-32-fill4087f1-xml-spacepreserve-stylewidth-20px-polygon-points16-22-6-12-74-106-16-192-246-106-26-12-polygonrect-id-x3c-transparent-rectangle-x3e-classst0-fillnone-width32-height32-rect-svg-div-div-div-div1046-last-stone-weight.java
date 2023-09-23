class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while (pq.size()>1) {
            int l = pq.poll();
            int l2 = pq.poll();
            if(l!=l2){
                int rem = l - l2; 
                pq.add(rem);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        else{
            return pq.poll();
        }
    }
}