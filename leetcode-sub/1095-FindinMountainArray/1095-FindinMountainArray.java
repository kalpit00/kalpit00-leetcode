// Last updated: 4/16/2025, 1:53:16 AM
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = peakIndexInMountainArray(mountainArr);
        int ans = OSbinarySearch(target, mountainArr, 0, peakIndex);
        if (ans == -1) {
            ans = OSbinarySearch(target, mountainArr, peakIndex, mountainArr.length()-1);
        }
        return ans;
    }
    
    public int peakIndexInMountainArray(MountainArray arr) {
        int start = 0;
        int end = arr.length() - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (arr.get(mid) > arr.get(mid + 1)) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return start;
    }
    
    public int OSbinarySearch(int target, MountainArray arr, int start, int end) {
        if (arr.length() == 0) {
            return -1;
        }
        boolean isAsc = arr.get(start) < arr.get(end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr.get(mid)) {
                return mid;
            }
            if (isAsc) {
                if (target < arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            else {
                if (target > arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}