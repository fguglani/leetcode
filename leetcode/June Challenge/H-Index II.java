class Solution {
    public int hIndex(int[] citations) 
    {
        //Our aim here is to achieve such a value in the array that len-its index==that value
        int len=citations.length;
        int s=0,e=len-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(citations[mid]==len-mid)
            {
               return len-mid;
            }
            else if(citations[mid]<len-mid)
            {
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }
        
        return len-s;
    }
}