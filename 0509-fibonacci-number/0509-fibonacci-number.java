import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public Solution() {
        map.put(0, 0);
        map.put(1, 1);
    }

    public int fib(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int result = fib(n - 1) + fib(n - 2);
        map.put(n, result);

        return result;
    }
}
