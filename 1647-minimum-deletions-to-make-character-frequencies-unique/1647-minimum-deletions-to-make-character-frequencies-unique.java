import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26]; 
        
        for (char c : s.toCharArray()) {
            int alpha = c - 'a';
            arr[alpha]++;
        }
        
        Integer[] integerArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integerArr[i] = arr[i];
        }
        Arrays.sort(integerArr, Collections.reverseOrder());
        
        HashSet<Integer> set = new HashSet<>();
        int del = 0;

        for (int i = 0; i < integerArr.length; i++) {
            int freq = integerArr[i];
            while (set.contains(freq)) {
                freq--; 
                del++;
            }
            if (freq > 0) {
                set.add(freq); 
            }
        }
        
        return del;
    }
}
