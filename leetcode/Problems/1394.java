class Solution {
    public int findLucky(int[] arr) 
    {
        //This question has only positive numbers so we can use array to store values
        //With negative numbers HashMap is the better option
        int count[]=new int[501];
        int max=0;
        for(int i:arr)
        {
            count[i]++;
           if(i>max)max=i;
        }
        //Store the frequency of all elements in the array
        //Find the max value in the array
        //We will decrement our counter as we want the maximum number where no.=freq;
        for(int i=max;i>=1;i--)
        {
            if(count[i]==i)
            {
                return i;
            }
        }
        return -1;
    }
}