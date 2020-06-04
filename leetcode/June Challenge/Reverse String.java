class Solution {
    public void reverseString(char[] s) 
    {
        int n=s.length;
        //The idea here is very simple.We just need to swap first and last elements so we iterate till mid of the array
        for(int i=0;i<(n/2);i++)
        {
            char temp=s[i];
            s[i]=s[n-i-1];
            s[n-i-1]=temp;
            //Just swap the ith and n-1-i th number.
        }
    }
}