class Solution {
    public int[] decompressRLElist(int[] nums)
    {
        int sum=0;
        int n=nums.length;
	//Lets first calculate the array size we need every odd index represents the frequency
        for(int i=0;i<n;i+=2)
        {
            sum+=nums[i];
        }
        int ans[]=new int[sum];
        int k=0;
	//Just fill the array(Try to use any inbuild function-->to fill the array)
        for(int i=1;i<n;i+=2)
        {
            int no=nums[i];
            int freq=nums[i-1];
            Arrays.fill(ans,k,k+freq,no);
            k+=freq;
        }
        
        return ans;
    }
}