
package vending2;


public class coincollector extends VM2 {
    
  
public static int Balence=0;
private static boolean CA = false;

public coincollector(int myBalance, boolean CloseAfter) { 
	
		Balence = myBalance; 
		// balance is.
		CA = CloseAfter;
		
	} 

public int Addmoney(int balence,int flag)
{
    if(flag==1)
    {
	Balence=0;
}
    
       
        Balence+=balence;
        return Balence;
    
}

	public  int getBalance() {
		
		return Balence; // Return the balance.
	}
        
 
    
}
