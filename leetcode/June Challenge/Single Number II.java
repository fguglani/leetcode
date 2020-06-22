class Solution {
    public int singleNumber(int[] nums) 
    {
    //This is a very generic approach in which we try to use the condition that same numbers will have same bits position so we check every bit position for every number and if it is position%3==0 that tells we have that number at 3 positions other wise we use that bit to generate our solution
        
        
         int ans = 0;
    for(int i = 0; i < 32; i++) {
        int sum = 0;
        for(int j = 0; j < nums.length; j++) {
            if(((nums[j] >> i) & 1) == 1) {
                sum++;
                sum %= 3;
            }
        }
        if(sum != 0) {
            ans |= sum << i;
        }
    }
    return ans;
}
}