class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //Binary Search
        int s = 0;
        int e = arr.length - 1;
        
        int mid = s + (e-s)/2;
        
        while(s<=e){
            mid = s + (e-s)/2;
            if(mid < arr.length - 1 && 0 < mid && arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                return mid;
            }
            else if(mid < arr.length - 1 && arr[mid]<arr[mid+1]){
                s = mid+1;
            }
            else{
                e = mid - 1;
            }
        }
        return mid;
    }
}
