class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) 
    {
        //The idea is simple first we need to find the max candies in the group and then check which kids can have the maxcandies after receiving the extracandies
        List<Boolean> ans=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i:candies)
        {
            max=Math.max(i,max);
        }
        for(int i:candies)
        {
            ans.add(i+extraCandies>=max);
        }
        
        return ans;
    }
}