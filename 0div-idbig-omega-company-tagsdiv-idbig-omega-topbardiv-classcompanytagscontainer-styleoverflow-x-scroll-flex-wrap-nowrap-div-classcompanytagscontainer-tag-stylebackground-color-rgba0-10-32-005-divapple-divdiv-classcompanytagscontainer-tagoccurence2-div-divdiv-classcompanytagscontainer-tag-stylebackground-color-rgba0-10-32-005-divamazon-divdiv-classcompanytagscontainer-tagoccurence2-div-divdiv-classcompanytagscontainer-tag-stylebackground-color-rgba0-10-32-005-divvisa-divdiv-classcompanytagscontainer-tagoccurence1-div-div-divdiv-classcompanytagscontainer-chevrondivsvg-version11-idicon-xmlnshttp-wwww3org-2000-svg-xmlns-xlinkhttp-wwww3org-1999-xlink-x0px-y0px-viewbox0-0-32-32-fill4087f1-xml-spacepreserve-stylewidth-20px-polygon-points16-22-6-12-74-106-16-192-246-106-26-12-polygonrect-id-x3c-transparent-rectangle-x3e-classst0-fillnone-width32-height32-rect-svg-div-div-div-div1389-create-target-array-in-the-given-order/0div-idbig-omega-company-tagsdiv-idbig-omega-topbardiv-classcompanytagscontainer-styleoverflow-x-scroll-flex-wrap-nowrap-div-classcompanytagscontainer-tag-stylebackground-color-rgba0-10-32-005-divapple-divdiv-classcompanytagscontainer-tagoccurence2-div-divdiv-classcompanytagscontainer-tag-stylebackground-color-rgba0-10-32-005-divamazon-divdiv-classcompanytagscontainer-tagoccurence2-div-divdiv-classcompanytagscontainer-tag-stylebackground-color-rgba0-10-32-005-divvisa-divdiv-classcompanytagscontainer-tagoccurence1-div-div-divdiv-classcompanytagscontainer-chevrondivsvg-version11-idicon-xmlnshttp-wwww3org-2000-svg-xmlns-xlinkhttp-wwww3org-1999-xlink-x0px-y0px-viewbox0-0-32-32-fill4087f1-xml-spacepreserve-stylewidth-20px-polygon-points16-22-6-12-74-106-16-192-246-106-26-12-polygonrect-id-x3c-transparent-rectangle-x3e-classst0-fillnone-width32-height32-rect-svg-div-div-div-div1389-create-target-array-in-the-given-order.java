class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        if (nums.length < 2) return nums;

        Index[] indexes = new Index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = new Index(index[i], i);
        }

        mergeSort(indexes, 0, nums.length - 1, new Index[nums.length]);
        int target[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            target[i] = nums[indexes[i].oldIndex];
        }

        return target;
    }

    private void mergeSort(Index[] indexes, int low, int high, Index[] temp) {
        if (low >= high) return;

        int mid = (high - low) / 2 + low;
        mergeSort(indexes, low, mid, temp);
        mergeSort(indexes, mid + 1, high, temp);
        merge(indexes, low, mid, high, temp);
    }

    private void merge(Index[] indexes, int low, int mid, int high, Index[] temp) {
        int left = low, right = mid + 1, index = low;
        while (left <= mid && right <= high) {
            if ((indexes[left].val + right - mid - 1) < indexes[right].val) {
                temp[index] = indexes[left++];
                temp[index++].val += right-mid-1;
            } else {
                temp[index++] = indexes[right++];
            }
        }

        while (left <= mid) {
            temp[index] = indexes[left++];
            temp[index++].val += right-mid-1;
        }

        while (right <= high) {
            temp[index++] = indexes[right++];
        }

        while (low <= high) {
            indexes[low] = temp[low++];
        }
    }

    static class Index {
        int val;
        int oldIndex;

        Index(int val, int oldIndex) {
            this.val = val;
            this.oldIndex = oldIndex;
        }
    }
}