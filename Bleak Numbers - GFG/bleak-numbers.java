//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int is_bleak(int n)
    {
        // To check for numbers up to log2(n) + 1 set bits
        int maxBits = Integer.toBinaryString(n).length() + 1;
        
        for (int x = n - maxBits; x < n; x++)
        {
            if (x + countSetBits(x) == n)
            {
                return 0; // Not a Bleak number
            }
        }
        return 1; // n is a Bleak number
    }
    
    // Function to count the number of set bits (1s) in a binary representation
    private int countSetBits(int num)
    {
        int count = 0;
        while (num > 0)
        {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}

