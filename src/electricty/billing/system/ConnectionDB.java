/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricty.billing.system;

import java.sql.*;

/**
 *
 * @author dell
 */
public class ConnectionDB {
    Connection c;
    Statement s;
     ConnectionDB(){
        //1.Register the driver-- Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            //2 creating connection
            c= DriverManager.getConnection("jdbc:mysql://localhost:3308/ebs","root","Sanyal"); 
            //3 creating statementt
            s=c.createStatement();
            //4 Executing mysql query
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
         
         //c.close();
     }
}
