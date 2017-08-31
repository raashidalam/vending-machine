
package vending2;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.JOptionPane; 


    public class vm1 extends JFrame implements ActionListener {
        private int Balence = 0; 
	public boolean CloseAfter = false;
        int flag=0;
	private int Width = 500; 
	private int Height = 400;
        private JButton Buttons[]; 
        private int i;
        int f=0;
        VM2 Machine = new VM2();
        coincollector machine1=new coincollector(Balence,CloseAfter);
        dispenceproduct machine2=new dispenceproduct();
        	public JLabel Bal = new JLabel("   Balance: " + machine1.getBalance());
        public JLabel About = new JLabel("   Vending Machine");
      
        
        
        public vm1() { 

		setTitle("Vending Machine"); 
		Toolkit myTK = Toolkit.getDefaultToolkit();
		Dimension myD = myTK.getScreenSize();
		setBounds((myD.width - Width)/2, (myD.height - Height)/2, Width, Height);

		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} 
		}
		); 

		
		Buttons = new JButton[10]; 
		Machine.Initialize();
              
	

		for (i = 0 ; i < 5 ; i++) { 
			
			Buttons[i] = new JButton(Machine.getDescription(i) + " - " + Machine.getPrice(i));
			// This actually carries out the action
		} 

	
		Buttons[5] = new JButton("Rs 1");
		Buttons[6] = new JButton("Rs 2");
		Buttons[7] = new JButton("Rs 5");
		Buttons[8] = new JButton("Rs 10");
		Buttons[9] = new JButton("Coinn Return");
              
               Container pane = getContentPane(); // Get the pane.
		pane.setLayout(new GridLayout(7,2)); // This sets the layout to the grid style.
		
		pane.setLayout(new GridLayout(7,2)); // This sets the layout to the grid style.
		// This has 7 down and 2 across.
		for(i = 0 ; i < 5; i++) { 
			pane.add(Buttons[i]); 
			pane.add(Buttons[i+5]); 
			
			
			Buttons[i].addActionListener(this); 
			Buttons[i+5].addActionListener(this); 
			
		} // END for(i = 0 ; i < 12; i++)

		pane.add(Bal); 
		pane.add(About);

	}
        
        public void actionPerformed(ActionEvent e) { // BEGIN actionPerformed(ActionEvent e)
		boolean Success;
		Machine.Initialize();
                  // Machine.quan();
		
		Object theButton = e.getSource();
		
		for(i = 5; i<10 ; i++) { 
			if(theButton == Buttons[i]) {
				switch(i) { 
					case 5: 
							
						Balence=machine1.Addmoney(1,f); 
                                                f=0;
						break; 
					case 6: 
						Balence=machine1.Addmoney(2,f); 
                                                f=0;
						break; 
					case 7: 
						Balence=machine1.Addmoney(5,f); 
                                                f=0;
						break; // Stop
					case 8: 
						Balence=machine1.Addmoney(10,f);
                                                f=0;
						break; // Stop
					
					case 9: 
						Machine.ReturnChange(Balence); 
						System.exit(0); 
						
				} 
			} 
		}
		for(i = 0; i < 5; i++) { 
			
			if(theButton == Buttons[i]) { 
				Success = machine2.BuyItem(i,Balence); // Buy that item number.
				
				if ((Machine.getCA() == true) || (Success == true)) {
				
                                        int bal=Balence-machine1.getPrice(i);
					 flag=1;
					//System.exit(0); 
                                        
                                           Machine.ReturnChange(bal); 
                                           Balence=0;
				} 
			}
		}
                if(flag==0)
                {
                Bal.setText("   Balance: " + machine1.getBalance());
                f=0;
		
		
	} 
                else
                {
                       Bal.setText("   Balance: " + 0); 
                       flag=0;
                       f=1;
                }
        }
    
}
