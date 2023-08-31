/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdateInfo extends JFrame implements ActionListener{
    JButton update,back;
    JTextField address,city,state,email,phone;
    String meter;
    JLabel name;
    
    UpdateInfo(String meter){
        this.meter=meter;
        setBounds(250,150,1000,550);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(120,10,500,40);
        heading.setFont(new Font("Calibri",Font.BOLD,20));
        add(heading);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,80,100,20);
        add(lblname);
        
        name=new JLabel("");
        name.setBounds(220,80,100,20);
        add(name);
       
        JLabel lblmeter=new JLabel("Meter Number");
        lblmeter.setBounds(50,130,100,20);
        add(lblmeter);
        
        JLabel meternum=new JLabel("");
        meternum.setBounds(220,130,100,20);
        add(meternum);
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(50,180,100,20);
        add(lbladdress);
        
        address=new JTextField();
        address.setBounds(220,180,200,20);
        add(address);
        
        JLabel lblcity=new JLabel("City");
        lblcity.setBounds(50,230,100,20);
        add(lblcity);
        
        city=new JTextField();
        city.setBounds(220,230,200,20);
        add(city);
        
        JLabel lblstate=new JLabel("State");
        lblstate.setBounds(50,280,100,20);
        add(lblstate);
        
        state=new JTextField();
        state.setBounds(220,280,200,20);
        add(state);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(50,330,100,20);
        add(lblemail);
        
        email=new JTextField();
        email.setBounds(220,330,200,20);
        add(email);
        
        JLabel lblphone=new JLabel("Phone no");
        lblphone.setBounds(50,380,100,20);
        add(lblphone);
        
        phone=new JTextField();
        phone.setBounds(220,380,200,20);
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
        
        update=new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(90,450,100,25);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(260,450,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        
        image.setBounds(550,100,400,300);
       add(image);
        
        setVisible(true);
    }
    
   public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            String saddress=address.getText();
            String scity=city.getText();
            String sstate=state.getText();
            String semail=email.getText();
            String sphone=phone.getText();
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update customer set address='"+saddress+"',city='"+scity+"',state='"+sstate+"',email='"+semail+"',phone='"+sphone+"' where meternum='"+meter+"' ");
                JOptionPane.showMessageDialog(null, "User information updated successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }  
    
    public static void main(String[] args) {
        new UpdateInfo("");
    }
}
