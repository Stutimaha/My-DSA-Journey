class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1){
            return 0;
        }
        
        int prevK = (k+1)/2;
        int prevValue  = kthGrammar(n-1,prevK);
        
        if(prevValue==0){
            if(k%2==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            if(k%2==0){
                return 0;
            }
            else{
                return 1;
            }
        }
    }
}