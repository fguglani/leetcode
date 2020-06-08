class Solution {
    public boolean isPowerOfTwo(int n) 
    {
        //We can check for power of 2 by taking its log value
        double check=Math.log10(n)/Math.log10(2);
        return check==(int)check;
    }
}