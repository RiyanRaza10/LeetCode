/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int left = 1 , right = n-2 , peakIndex = -1;

        // Find peakindex
        while(left <= right){
            int mid = left + (right - left) / 2;

            int currElem = mountainArr.get(mid);
            int leftElem = mountainArr.get(mid-1);
            int rightElem = mountainArr.get(mid+1);

            if(currElem > leftElem && currElem > rightElem){
                peakIndex = mid;
                break;
            }

            else if(leftElem > currElem) right = mid - 1;

            else left = mid + 1;
        }

        // Search in left half of peakIndex
        left = 0 ; right = peakIndex;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int currElem = mountainArr.get(mid);

            if(currElem == target){
                return mid;
            }

            else if(currElem > target) right = mid - 1;

            else left = mid + 1;
        }

        // Search in right half of peakIndex
        left = peakIndex+1; right = n-1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int currElem = mountainArr.get(mid);

            if(currElem == target){
                return mid;
            }

            else if(currElem < target) right = mid - 1;

            else left = mid + 1;
        }

        return -1;
    }
}