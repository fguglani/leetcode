class RandomizedSet 
{
    //When we read the question first thing strikes is 0(1) insertion so--->linkedlist and hashmap
    //0(1) deletion hm...--->hashMap
    //So hashmap is confirmed
    //random in o(1).....we cannot traverse hashmap in o(1) and dont have access to it so we need another data structures...for o(1) access arraylist but if we remove something from middle we need to shift everything to the left
    //So so so...we will delete from arraylist after swappiing the element to be deleted to the end
    //HashMap will store indexes of ArrayList for value it stores.
    //Random will be generates by accessing arraylist in o(1)
    
    /** Initialize your data structure here. */
    HashMap<Integer,Integer> map;
    ArrayList<Integer> arr;
    java.util.Random rand=new java.util.Random();
    public RandomizedSet() 
    {
        map=new HashMap<>();
        arr=new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) 
    {
        if(map.containsKey(val))
        {
            return false;
        }
        else
        {
            arr.add(val);
            map.put(val,arr.size()-1);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val)
    {
        if(!map.containsKey(val))
        {
            return false;
        }
        {
            int loc=map.get(val);
            int last=arr.get(arr.size()-1);
            arr.set(loc,last);
            map.put(last,loc);
            map.remove(val);
            arr.remove(arr.size()-1);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() 
    {
        return arr.get(rand.nextInt(arr.size()));    
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */