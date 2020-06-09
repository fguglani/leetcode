class Solution {
    public boolean isSubsequence(String s, String t) 
    {
        //The idea here is very simple
        char c[]=s.toCharArray();
        char p[]=t.toCharArray();
        //We will match both the strings character by character and if we could not find the char in Array p then  the condition is false
        int j=0;
        int index=-1;//We will save index of ith character we search
        for(int i=0;i<c.length;i++)
        {
            char z=c[i];
            int last_index=index;//We will put value of that index in last_index
            for(;j<p.length;j++)
            {
                if(z==p[j])//We will check if the char z is present in Array p
                {
                    index=j;
                    break;
                }
            }
            if(index==last_index)//Now if we were able to find the character in array p then last_index will have value of (i-1)th index and index will have value of ith index..but if the condition fails that means were no able to find ith character in t
            {
                return false;
            }
            else
                j+=1;
        }
        
        return true;
    }
}