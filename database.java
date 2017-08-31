/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Risheek
 */
public class database {
        final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost/acd";
	final String USER="root";
	
        Connection conn;
    public void change_quantity(int item){
            try {
                //get the count of item from the database
                //item_name|quantity
                int new_q;
                Class.forName(JDBC_DRIVER);
                System.out.println("connecting to the database");
                conn = DriverManager.getConnection(DB_URL,USER,"");
                String sql="SELECT * FROM data WHERE item = ? ";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, item);
                ResultSet rs=stmt.executeQuery();
                if(rs.next()){
                int qu=rs.getInt("quantity");
                   // System.out.println("quantity="+qu);
                new_q=qu-1;
                String sql2="UPDATE data SET quantity=?  WHERE item=?";
                PreparedStatement stmt2 = conn.prepareStatement(sql2);
                stmt2.setInt(1, new_q);
                stmt2.setInt(2, item);
                stmt2.executeUpdate();
                }
                //inserting back to database
                
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
          
    }
    
    public int get_quantity(int item){
        int qu=-1;    
        try {
                Class.forName(JDBC_DRIVER);
                System.out.println("connecting to the database");
                conn = DriverManager.getConnection(DB_URL,USER,"");
                System.out.println("connected");
                String sql="SELECT * FROM data WHERE item = ? ";
                PreparedStatement stmt = conn.prepareStatement(sql);
                
                
               // System.out.println(item);
                stmt.setInt(1, item);
               // System.out.println("hwrw");
                ResultSet rs=stmt.executeQuery();
                //System.out.println(rs);
                if(rs.next()){
                qu=rs.getInt(2);
                }
                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
              return qu;  
    }
}
