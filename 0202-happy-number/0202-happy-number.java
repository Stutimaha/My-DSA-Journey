class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {
            int current = n;
            int sum = 0;

            while (current != 0) {
                int digit = current % 10;
                sum += digit * digit;
                current /= 10;
            }

            if (seen.contains(sum)) {
                return false; // Detected a cycle, the number is not happy
            }

            seen.add(sum);
            n = sum;
        }

        return true; // Number is happy
    }
}
