/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;

public class PayBill extends JFrame{
    PayBill(){
        setLayout(null);
        setBounds(300,150,900,600);
        
        JLabel heading=new JLabel("Electricity Bill");
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new PayBill();
    }
}
