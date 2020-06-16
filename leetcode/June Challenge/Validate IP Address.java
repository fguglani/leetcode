class Solution {
    public String validIPAddress(String ip) 
    {
        //This problem is easy but has lots of edgecases
        //Lets look one by one
        
        if(ip.contains("."))//We need to check for ipv4
        {
            
         String sep[]=ip.split("\\.");//Seperate over dot
            
        if(sep.length!=4 || ip.charAt(ip.length()-1)=='.')//If we have numbers not equal to 4 or "."at last we have a problem
        {
            return "Neither";
        }
        //check the authenticity of the numbers   
           
            for(int i=0;i<sep.length;i++)
            {
                int no_check;
                try
                {
                no_check=Integer.parseInt(sep[i]);//if anythin else than number we have a problem
                }
                catch(Exception e)
                {
                    return "Neither";
                }
                if(no_check>255 || no_check<0)//if its number we need to check if it lies in the rannge
                return "Neither";
                
                //If it is a single digit positive number no issue then but
                if(sep[i].length()>1)
                {
                    int num=0;
                    //check for any leading zeros or -0
                    for(int j=0;j<sep[i].length();j++)
                    {
                         if(sep[i].charAt(j)=='0' && num<=0 || sep[i].charAt(0)=='-')return "Neither";

                        else  num++;
                    }
                       
                }
            }
             return "IPv4";//Else we have valid ip
        }   
       

        else
        {
        ip=ip.toLowerCase();//change to lower case to reduce test cases
            
        String sep[]=ip.split("\\:");
            
        if(sep.length!=8 || ip.charAt(ip.length()-1)==':')
        {
            return "Neither";
        }
        
        for(int i=0;i<sep.length;i++)
        {
            int value=0;
            try
            {
                value=Integer.parseInt(sep[i],16);
            }
            catch(Exception e)
            {
                return "Neither";
            }
            
            if(value>65536 || value<0)return "Neither";
            
            if(sep[i].length()>4 || sep[i].charAt(0)=='-')return "Neither";
        }
        return "IPv6";      
        }  
    }
}