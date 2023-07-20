class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        
        if(num.length()==0 || num==null){
            return result;
        }
        
        backtrack(result, "", num, target, 0 , 0, 0);
        return result;
    }
    
    private void backtrack (List<String> result, String path, String num, int target, int pos, long eval, long multed){
        if(pos==num.length()){
            if(target==eval)
                result.add(path);
            return;
        }
        
        for(int i = pos; i<num.length();i++){
            if(i!= pos && num.charAt(pos)=='0')
                break;
            
            long current = Long.parseLong(num.substring(pos, i+1));
            
            if(pos==0){
                backtrack(result, path+current, num, target, i+1, current, current);
            }
            else{
                backtrack(result, path+"+"+current, num, target, i+1, eval + current, current);
                backtrack(result, path+"-"+current, num, target, i+1, eval - current, -current);
                backtrack(result, path+"*"+current, num, target, i+1, eval - multed + multed * current, multed * current);
            }
        }
    }
}