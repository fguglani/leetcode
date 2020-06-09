class Solution {
    public List<Integer> findDuplicates(int[] nums) 
    {
        //The idea here is simple but tricky we will use numbers given as index as all 0=<num-1<n 
        //So we will make numbers sitting at that index as negative and if we find that that number is already negative that means kaboom..we found a number that we saw earlier.
        int n=nums.length;
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0)
            {
                ans.add(index+1);
            }
            nums[index]*=-1;
        }
        return ans;
    }
}