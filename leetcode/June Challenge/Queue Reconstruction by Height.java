class pair//creating a class pair to store both the h and k
{
    int i;
    int j;
    pair(int i,int j)
    {
        this.i=i;
        this.j=j;
    }
}

//Sorting based on heights in dec and on the basis of k in asc

class com implements Comparator<pair>
{
    public int compare(pair p1,pair p2)
    {
        if(p2.i!=p1.i)
        {
            return p2.i-p1.i;
        }
        else
        {
        return p1.j-p2.j;
        }
    }
}
class Solution {
    public int[][] reconstructQueue(int[][] people) 
    {
        ArrayList<pair> arr=new ArrayList<>();
        int n=people.length;
        for(int i=0;i<n;i++)
        {
            arr.add(new pair(people[i][0],people[i][1]));
        }
        Collections.sort(arr,new com());
        ArrayList<pair> a=new ArrayList<>();
        //We just need to make sure that we put the person at their correct index that will resolve the issue
        
        for(pair p:arr)
        {
            a.add(p.j,p);
        }
        int mat[][]=new int[n][2];
        for(int i=0;i<n;i++)
        {
            mat[i][0]=a.get(i).i;
            mat[i][1]=a.get(i).j;
        }
        
        return mat;
    }
}