
package vending2;
import javax.swing.JOptionPane;
public class VM2 {
      static int PRICE_0 = 8;
	  static int PRICE_1 = 12;
  static int PRICE_2 = 15;
	   static int  PRICE_3 = 13;
	   static int PRICE_4 = 10;
          static String DESC_0 = "Coffee";
	 static String DESC_1 = "Lemon Juice";
	 static String DESC_2 = "Coke";
	  static String DESC_3 = "Sprite ";
 static  String DESC_4 = "Mountain deo";
     
      
        	private static boolean CA = false;
                private static int Price[] = new int[5];
			
	private static  String Description[] = new String[5];
        	
			
	private static int MaxLen = 0; 
        public  String getDescription(int ItemNumber) {
		
		return Description[ItemNumber]; 
	} 
        
	
        
        public  int getPrice(int ItemNumber) {
		
		return Price[ItemNumber]; // Return the price of our item.
	} 
        
        
       
        public static void Initialize() {
		
		
		
        setDescription(0, DESC_0);
        setDescription(1, DESC_1);
        setDescription(2, DESC_2);
        setDescription(3, DESC_3);
        setDescription(4, DESC_4);
      //  setDescription(5, DESC_5);
        // The following statements set the prices for these items.
        setPrice(0, PRICE_0);
        setPrice(1, PRICE_1);
        setPrice(2, PRICE_2);
        setPrice(3, PRICE_3);
        setPrice(4, PRICE_4);
        
          
                
       
	} 
     
  
        public static void setDescription(int ItemNumber, String theDescription) {
		
		Description[ItemNumber] = theDescription; // Set the description.
	} 
        
        public static void setPrice(int ItemNumber, int thePrice) {
		
		Price[ItemNumber] = thePrice; // set the price of our item.
	} 
        
        
        
        public static void ReturnChange(int Balence) {
		
		Output("Your Total change is: \n" +
				 " Rupees" +" "+
				 + Balence,1); // This outputs the change to the user.
				
	} 
        public static boolean getCA() {
		return CA;
	}
        public static void Output(String Message, int Type) {
		
		if (Type == 1) {  // this checks the type of output
		
			JOptionPane.showMessageDialog(null, Message, "Vending Machine", JOptionPane.PLAIN_MESSAGE);
		} 
		else {
			
		} 
	} 

}
