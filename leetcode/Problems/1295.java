class Solution {
    public int findNumbers(int[] nums) 
    {
        int ans=0;
        for(int i:nums)
        {
            //The only trick here is how to calculate no. of digits
            //We will use log function here
            //log10(10)==1 and log10(100)=2 So for all 2 digits no. 1<=floor(log(n))<2 
            int digits=(int)Math.log10(i)+1;
            if((digits&1)==0)
            {
                ans++;
            }
        }
        
        return ans;
    }
}