class Solution 
{   
    //My approach is here is nullify all the zeros that cant be converted into a cross
    //These are the zeros that are directly or indirectly connected to the sides
    //Nullify all such zeros by changing their values
    //Cross the rest of zeros 
    //Change the nullified zeros to zero
    void dfs(char[][] board,int i,int j,int n)
    {
        if(i>=n || j>=board[0].length || i<0 || j<0)
        {
            return;
        }
    
        if(board[i][j]=='X' || board[i][j]=='1')
        return;
        board[i][j]='1';
        dfs(board,i+1,j,n);
        dfs(board,i-1,j,n);
        dfs(board,i,j-1,n);
        dfs(board,i,j+1,n);
    }
    public void solve(char[][] board) 
    {
        int n=board.length;
        if(n==0)
            return;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='O' && (i==0 || j==0 || i==n-1 || j==board[i].length-1))
                {
                    dfs(board,i,j,n);
                }
            }
        }                 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='O')board[i][j]='X';
                else if(board[i][j]=='1')board[i][j]='O';
            }
        }
    }
}