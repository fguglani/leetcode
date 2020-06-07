class Solution {
    public int change(int amount, int[] coins) 
    {
        //The only catch in this question is that we need to make sure we do not take duplicates
        //e.g 3=2+1 and 3=1+2
        //To avoid this our outer loop will be of coins and inner loop of amounts achievable
        int dp[]=new int[amount+1];
        dp[0]=1;
        for(int j=0;j<coins.length;j++)
            {
            for(int i=coins[j];i<=amount;i++)
                {
                 dp[i]+=dp[i-coins[j]];
                }
            }
        return dp[amount];
    }
}