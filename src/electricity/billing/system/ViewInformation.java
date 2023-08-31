/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class ViewInformation extends JFrame implements ActionListener{
JButton cancel;
    
    ViewInformation(String meter) {
       setBounds(350,150,850,600);
       getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(300,10,500,40);
        heading.setFont(new Font("Calibri",Font.BOLD,20));
        add(heading);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(70,90,100,20);
        add(lblname);
        
        JLabel name=new JLabel("");
        name.setBounds(220,90,100,20);
        add(name);
       
        JLabel lblmeter=new JLabel("Meter Number");
        lblmeter.setBounds(70,150,100,20);
        add(lblmeter);
        
        JLabel meternum=new JLabel("");
        meternum.setBounds(220,150,100,20);
        add(meternum);
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(70,210,100,20);
        add(lbladdress);
        
        JLabel address=new JLabel("");
        address.setBounds(220,210,100,20);
        add(address);
        
        JLabel lblcity=new JLabel("City");
        lblcity.setBounds(70,270,100,20);
        add(lblcity);
        
        JLabel city=new JLabel("");
        city.setBounds(220,270,100,20);
        add(city);
        
        JLabel lblstate=new JLabel("State");
        lblstate.setBounds(500,90,100,20);
        add(lblstate);
        
        JLabel state=new JLabel("");
        state.setBounds(650,90,100,20);
        add(state);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(500,150,100,20);
        add(lblemail);
        
        JLabel email=new JLabel("");
        email.setBounds(650,150,100,20);
        add(email);
        
        JLabel lblphone=new JLabel("Phone no");
        lblphone.setBounds(500,210,100,20);
        add(lblphone);
        
        JLabel phone=new JLabel("");
        phone.setBounds(650,210,100,20);
        add(phone);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select* from customer where meternum='"+meter+"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                meternum.setText(rs.getString("meternum"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone")); 
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(350,330,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        
        image.setBounds(60,300,600,300);
       add(image);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            setVisible(false);
        }
    }  
    
    public static void main(String[] args) {
        new ViewInformation("meter");
    }
}
