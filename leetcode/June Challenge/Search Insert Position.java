class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        //This question looks very simple in o(n) but we need to notice the array is sorted so we should try to do it in o(logn)
        int s=0;
        int e=nums.length-1;
        while(s<=e)
        {
            int mid=(s+e)/2;//Calculte the mid
            if(nums[mid]==target)return mid;//if number is found return the mid
            else if(nums[mid]>target)e=mid-1;//else reduce upper bound
            else  s=mid+1;//increase lower bound
        }
        return s;//returning lower bound because we need first element i.e if we have an array of [1,1,1,1,3,3] and we have to put 3 we need to return 4 as it is the first place where we can put 3
    }
}