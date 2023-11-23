class Solution(object):
    def productExceptSelf(self, arr):
        product = 1
        zero_count = 0 

        for i in range(len(arr)):
            if arr[i] == 0:
                zero_count += 1
            else:
                product *= arr[i]

        for i in range(len(arr)):
            if zero_count == 0:
                arr[i] = product // arr[i]
            elif zero_count == 1 and arr[i] == 0:
                arr[i] = product
            else:
                arr[i] = 0

        return arr