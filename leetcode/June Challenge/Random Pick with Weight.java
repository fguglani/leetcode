class Solution {
    int sum[];
    int maxsum;
    //Calculate the prefix sum
    public Solution(int[] w)
    {   
        int n=w.length;
        sum=new int[n];
        sum[0]=w[0];
        for(int i=1;i<n;i++)
        {
            sum[i]=w[i]+sum[i-1];
        }
        maxsum=sum[n-1];
    }
    //then check where a random number will lie
    public int pickIndex() 
    {
        int s=0;
        int e=sum.length-1;
        Random rand=new Random();
        double m=(double)maxsum*rand.nextDouble();
        while(s<=e)
        {
           int mid=(s+e)/2;
           if(m>sum[mid])
           {
               s=mid+1;
           }
           else
           {
               e=mid-1;
           }
        }
        
        return s;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */