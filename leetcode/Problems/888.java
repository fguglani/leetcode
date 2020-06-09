class Solution {
    public int[] fairCandySwap(int[] a, int[] b) 
    {
        //The idea here is to use the sums to check if we can swap or not
        //E.g let one array be [1,1] and other be [2,2] If we have to swap 1 and 2 it also means we will be deleting something from two and adding it to 1.I.e Adding or deleting (sum2-sum1)/2
        int sum1=0;
        int sum2=0;
        for(int i:a)
        {
            sum1+=i;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i:b)
        {
            sum2+=i;
            set.add(i);
        }
        //After finding the sums this problem reduce to finding if sum=k is possible or not
        int diff=(-sum1+sum2)/2;
        int ans[]=new int[2];
        int i=0;
        while(i<a.length)
        {
            if(set.contains(diff+a[i]))
            {
                ans[0]=a[i];
                ans[1]=a[i]+diff;
                break;
            }
            i++;
        }
                
        
        return ans;
    }
}