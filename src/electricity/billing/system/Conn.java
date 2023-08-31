/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import java.sql.*;
/**
 *
 * @author krati
 */
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
       //2.creating a connection(mysql info)
       c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","Tiger@123");
        s=c.createStatement();  //3.creating a statement 
        }catch(Exception e){
            e.printStackTrace();
        }   
        }
}
