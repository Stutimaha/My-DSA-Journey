class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        Integer[][] cars = new Integer[n][2];
        
        for(int i =0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        
        Stack<Double> stack = new Stack<>();
        
        Arrays.sort(cars, java.util.Comparator.comparingInt(o -> o[0]));  //IMPORTANT
        
        for (int i = n-1; i>=0 ; i--) {
            double current_time= (double)(target-cars[i][0])/cars[i][1];
            if(!stack.isEmpty() && current_time<=stack.peek()){
                continue;
            }
            else stack.push(current_time);
        }
        
        return stack.size();
    }
}