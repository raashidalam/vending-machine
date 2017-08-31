
package vending2;

/**
 *
 * @author nida
 */
public class dispenceproduct extends VM2{

public  boolean BuyItem(int ItemNumber,int Balence) {
		boolean returnMe; 
		
                int quantity = -1;
                //getting quantity
                database db=new database();
                quantity=db.get_quantity(ItemNumber);
                
                    if (Balence < getPrice(ItemNumber)) {
			        //System.out.println(getPrice(ItemNumber));
			Output("Not enough money!", 1);
			
			returnMe = false; // The buy was not successful.
		} 
               //getting quantity
                
                
                else if(quantity<1)
                {
                    Output("Out of stock", 1);
                    returnMe = false;
                }
                    
                

		else { 
                    
                    System.out.println("Item number:"+ItemNumber);
                    
                    System.out.println("Quantity:"+quantity);
                    db.change_quantity(ItemNumber);
                    Balence -= getPrice(ItemNumber); 
			// spent out of the users balance.
			Output("Bought " + getDescription(ItemNumber) + " for " + getPrice(ItemNumber), 1); // Tells the user
			
			returnMe = true; // The buy was successful, so we will want to return true.
		} 

		return returnMe; 
	}

    
    
}
