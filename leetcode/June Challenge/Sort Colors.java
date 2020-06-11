class Solution 
{
    //This question is popularly known as Dutch Flag 
    //The intution behing the solution is to collect all zeros behind s and collect all 2's behind e and ones will be left in between
    
    public void swap(int s,int e,int num[])
    {
        int temp=num[s];
        num[s]=num[e];
        num[e]=temp;
    }
    
    public void sortColors(int[] nums) 
    {
        int s=0;
        int e=nums.length-1;
        int m=0;
        while(m<=e)
        {
            switch(nums[m])
            {
                case 0:{swap(s,m,nums);m++;s++;break;}
                case 1:{m++;break;}
                case 2:{swap(m,e,nums);e--;break;}
            }
        }
    }
}