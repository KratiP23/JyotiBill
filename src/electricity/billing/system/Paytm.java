/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
public class Paytm extends JFrame implements ActionListener{
    String meter;
    JButton back;
    Paytm(String meter){
       this.meter=meter; 
       
       JEditorPane j=new JEditorPane();
       j.setEditable(false);
       try{
          j.setPage("https://paytm.com/online-payments");
       }
       catch(Exception e){
          j.setContentType("text/html");
          j.setText("<html>Could not Load</html>");
       }
       JScrollPane pane=new JScrollPane(j);
       add(pane);
       
        setSize(800,600);
        setLocation(400,150);
//setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        back=new JButton("Back");
        back.setBounds(640,20,80,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        j.add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new PayBill(meter);
    }
    
    public static void main(String[] args) {
        new Paytm("");
    }
}
