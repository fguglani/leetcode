class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) 
    {
        
        //To do it in O(n) we need to make sure we can do it we have the counts beforehand
        int n=nums.length;
        
        int yes[]=new int[101];
        for(int i:nums)
        {
            yes[i]++;
        }
        //Take the count for every element
        int count[]=new int[101];
        
        int c=0;
        //Then we need to check the number smaller than particular number
        for(int i=0;i<101;i++)
        {
            if(yes[i]!=0)
            {
                count[i]=c;
                c+=yes[i];
            }
        }
        //Fill the result into result array
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=count[nums[i]];
        }
        
        return ans;
    }
}