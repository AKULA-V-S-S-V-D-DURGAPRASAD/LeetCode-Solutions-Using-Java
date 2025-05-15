class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                /* You are in the Descending Part of the array
                this may be the answer but look at the remaining
                part of the Array
                 */
                end = mid;
            } else {
                //You are in the ascending part of the Array
                start = mid + 1;
            }
        }
        return start;
    }
}