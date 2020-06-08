class Solution {
    public int[] shuffle(int[] nums, int n) 
    {
        int temp[]=new int[2*n];
        int i=0;
        int k=0;
        //We will use two pointers to solve this one to keep track of values to be inserted and other to put the values
        while(i<n)
        {
            temp[k++]=nums[i];
            temp[k++]=nums[i+n];
            i++;
        }
        return temp;
    }
}