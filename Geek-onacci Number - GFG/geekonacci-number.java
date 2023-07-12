/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        for (int i = 0; i < testcases; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(answer(a, b, c, n));
        }
        sc.close();
    }

    public static int answer(int a, int b, int c, int n) {
        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        if (n == 3) {
            return c;
        }

        return answer(a, b, c, n - 1) + answer(a, b, c, n - 2) + answer(a, b, c, n - 3);
    }
}
