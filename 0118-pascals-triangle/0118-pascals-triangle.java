class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows >= 1) {
            result.add(Arrays.asList(1)); 
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> answer = new ArrayList<>();
            answer.add(1);

            List<Integer> previousRow = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                int sum = previousRow.get(j - 1) + previousRow.get(j);
                answer.add(sum);
            }
            
            answer.add(1);
            result.add(answer);
        }

        return result;
    }
}