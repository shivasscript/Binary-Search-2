// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// Using two binary search functions to find first and last positions of target.
// First finds the leftmost index of the target element in the sorted array.
// If first returns -1, target is not present, otherwise Last finds the last occurrence.



class Solution {
    private int binarySearchFirst(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0||nums[mid]!=nums[mid-1]){
                return mid;}
                else{
                    high=mid-1;
                }
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid]!=nums[mid+1]){
                    return mid;
                } 
                else{
                    low=mid+1;
                }
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        if(n==0){return new int[]{-1,-1};}
        if(target<nums[0] || target>nums[n-1]){
            return new int[]{-1,-1};
        }
        int first=binarySearchFirst(nums,0,n-1,target);
        if(first==-1){return new int[]{-1,-1};}
        int last=binarySearchLast(nums,first,n-1,target);
        return new int[]{first,last};
    }
}