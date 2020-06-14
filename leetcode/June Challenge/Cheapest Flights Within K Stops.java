//I started with the simplest possible approach that was to try to consider all possible cases and go over them one by one then I read some solutions and found that we need to sort in such a way that we can reach in less than k stops with minimum cost 
/*class Edge
{
    int v;
    int w;
    Edge(int v,int w)
    {
        this.v=v;
        this.w=w;
    }
}

class Graph
{
    HashMap<Integer,ArrayList<Edge>> map;
    int min;
    Graph(int n)
    {
        map=new HashMap<>();
        min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            map.put(i,new ArrayList<Edge>());
        }
    }
    
    void add(int u,int v,int w)
    {
        ArrayList<Edge> e=map.get(u);
        e.add(new Edge(v,w));
        map.put(u,e);
    }
    //The simplest approach here can be to try every possible combination using dfs--->But this answer gives TLE
    void dfs(int src,int dst,int k,int w)
    {
        if(src==dst && k>=0)
        {
            min=Math.min(w,min);
            return;
        }
        else if(k==0)
        {
            return;
        }
        ArrayList<Edge> arr=map.get(src);
        for(Edge i:arr)
        {
            dfs(i.v,dst,k-1,w+i.w);
        }
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] f, int src, int dst, int k) 
    {
        Graph g=new Graph(n);
        for(int i=0;i<f.length;i++)
        {
            g.add(f[i][0],f[i][1],f[i][2]);
        }
        int min=Integer.MAX_VALUE;
        
        g.dfs(src,dst,k+1,0);
        
        if(g.min==Integer.MAX_VALUE)
        {
            return -1;
        }
        else
            return g.min;
    }
}*/

//Now we will use pq to check if the answer we are getting is the most optimal or not

class Solution {
    public int findCheapestPrice(int n, int[][] fl, int src, int dst, int k) 
    {
        HashMap<Integer,HashMap<Integer,Integer>> graph=new HashMap<>();
        for(int f[]:fl)
        {
            graph.put(f[0], graph.getOrDefault(f[0], new HashMap<>()));
            graph.put(f[1], graph.getOrDefault(f[1], new HashMap<>()));
            graph.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (Integer.compare(a[0], b[0])));//Using Lambda Expressions.
        pq.add(new int[]{0,src,k+1});//Take k as k+1 because we consider dst as a stop also.
        while(!pq.isEmpty())
        {
            int []top=pq.remove();
            int price=top[0];
            int city=top[1];
            int stop=top[2];
            if(city==dst)
            {
                return price;
            }
            if(stop>0)//We will check if the solution we are calculating is has stops>0 or not
            {
                Map<Integer,Integer> it=graph.get(city);
                for(int a:it.keySet())
                {
                    pq.add(new int []{price+it.get(a),a,stop-1});
                }
            }
        }
        return -1;
    }
}

