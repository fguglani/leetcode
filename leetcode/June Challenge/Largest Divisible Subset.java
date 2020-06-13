public class Solution {
    //The idea here is same as LIS
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        //We find the longest series given the provided condition.
        //This part where we find max and index can be merged but kept different for easy understandings.
        //Find the max index.
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++)
        {
            if (dp[i] > max)
            {
                index = i;
                max = dp[i];
            }
        }
        //Iterate back from that index and find if we can put that number or not
        List<Integer> ans = new ArrayList<>();
        int num = nums[index];
        for (int i = index; i >= 0; i--)
        {
            if (num % nums[i] == 0 && dp[index] - dp[i] <= 1)
            {
                ans.add(nums[i]);
                num = nums[i];
                index = i;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}