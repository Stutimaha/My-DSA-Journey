//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    //creating an object of class Print
		    Solution obj=new Solution();
		    int N;
		    
		    //input N
		    N=sc.nextInt();
		    
		    //calling printNos() methdo
		    //of class Print
		    obj.printNos(N);
		    System.out.println();
		    
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java



class Solution
{
    
  public void printNos(int N)
    {
     int n = 1;
     print(n, N);
    }
    
    public void print(int n, int N){
        if(n==N){
            System.out.print(n);
            return;
         }
         System.out.print(n+ " ");
         print(n+1, N);
        
    }
}


