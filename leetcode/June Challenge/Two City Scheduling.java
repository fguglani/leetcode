class Solution {
    public int twoCitySchedCost(int[][] costs) 
    {
        //This is a greedy problem and we have to be greedy in cost cutting
        int n=costs.length;
        int diff[]=new int[n];
        int sum=0;//Let us take that A visits all the cities
        for(int i=0;i<n;i++)
        {
            sum+=costs[i][0];//Total cost of A visiting all the cities
            diff[i]=costs[i][0]-costs[i][1];//Difference in costs of visiting A and B
        }
        Arrays.sort(diff);
        for(int i=n-1;i>=n/2;i--)
        {
            sum-=diff[i];//Remove the cost of n/2 places where we were at a loss in visiting city A.
        }
        
        return sum;
    }
}