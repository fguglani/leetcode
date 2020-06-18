class Solution {
    
    
    void addDay(HashMap<Integer,String> day)
    {
        day.put(5,"Saturday");
        day.put(6,"Sunday");
        day.put(0,"Monday");
        day.put(1,"Tuesday");
        day.put(2,"Wednesday");
        day.put(3,"Thursday");
        day.put(4,"Friday");
    }
    
    void addNo(HashMap<Integer,Integer> noOfDays)
    {
        //Sum total of days till that month
        noOfDays.put(1,31);
        noOfDays.put(2,59);
        noOfDays.put(3,90);
        noOfDays.put(4,120);
        noOfDays.put(5,151);
        noOfDays.put(6,181);
        noOfDays.put(7,212);
        noOfDays.put(8,243);
        noOfDays.put(9,273);
        noOfDays.put(10,304);
        noOfDays.put(11,334);
        noOfDays.put(12,365);
    }
    
    int calculatedays(int year)
    {
        int odddays=1;
        
        //Odd days in 1900 were 1.
        //Odd days in 2000 were 0;
        //Oddd days till that year
        //e.g. if year is 1985 odd days till 1984
        year=year-1900;//85 year this one
        if(year!=0)
        year--;//84 year before this
        int leap=year/4;
        int non_leap=year-leap;
        odddays=(non_leap+(leap*2))%7;
        
        return odddays;
    }
    
    int calculatedays(int day,int month,int year,HashMap<Integer,Integer> noofDays)
    {
        //At this movement we have number of odddays till last year so 
        //lets calculate for this year
        //first check if this year is leap or not
        boolean leap=false;
        if(year%4==0)
        {
            if(year!=2100)
            leap=true;
        }
        int odddays=0;
        if(leap && month>2)
        {
            odddays++;
        }
        int monthdays=month-1==0?0:noofDays.get(month-1);
        
        odddays+=(day+monthdays);
        
        odddays%=7;
    
        
        return odddays;
        
    }
    
    public String dayOfTheWeek(int day, int month, int year) 
    {
        //We have to calculate the number of odd days to check the day
        //Lets first store the value
        HashMap<Integer,String> dayOf=new HashMap<>();
        addDay(dayOf);
        HashMap<Integer,Integer> noOfDays=new HashMap<>();
        addNo(noOfDays);
        //calculate days based on year
        int oddDays=(calculatedays(year)+calculatedays(day,month,year,noOfDays))%7;
        
        return dayOf.get(oddDays);
        
    }
}