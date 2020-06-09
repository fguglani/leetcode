class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) 
    {
        //We will use count sort here as we have only positive constraints
        int count[]=new int[1001];
        int max=0;
        for(int i:arr1)
        {
            count[i]++;
            if(max<i)max=i;
        }
        int k=0;
        //After counting the frequencies we will go one by one over each element in arr2 and add them to arr1
        for(int i:arr2)
        {
            Arrays.fill(arr1,k,k+count[i],i);
            k+=count[i];
            count[i]=0;
        }
        //No we will look out for elements that were not in arr2 and add them to arr1
        for(int i=1;i<=max;i++)
        {
            if(count[i]!=0)
            {
                Arrays.fill(arr1,k,k+count[i],i);
                k+=count[i];
            }
        }
        
        return arr1;
    }
}