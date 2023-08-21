class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0; i<graph.length; i++){
            color[i]=-1;
        }
        
        for(int j = 0; j<graph.length; j++){
            if(color[j]==-1){
                if(check(j, graph, color)==false){
                    return false;
                }
            }
        }
        return true;        
    }
    
    public static boolean check(int start, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start]=0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            
            for(int i: graph[node]){
                if(color[i]==-1){
                    color[i]=1-color[node];
                    q.offer(i);
                }
                else if(color[i]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}