class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
	
        int m = matrix.length;
        int n = matrix[0].length;

        int begin = 0, end = m * n - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/n][mid%n];

            if( mid_value == target){
                return true;
            }else if(mid_value < target){
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}