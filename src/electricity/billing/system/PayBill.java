/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PayBill extends JFrame implements ActionListener{
    JButton pay,back;
    Choice Month;
    String meter;
    JLabel units,totalbill,status;
    PayBill(String meter){
        this.meter=meter;
    setLayout(null);
        setBounds(300,150,900,600);
       
        JLabel heading=new JLabel("Electricity Bill");
        heading.setFont(new Font("Calibri",Font.BOLD,24));
        heading.setBounds(120,5,400,30);
        
        JLabel lblmeter=new JLabel("Meter Number");
        lblmeter.setBounds(35,80,200,20);
        add(lblmeter);
        
        JLabel meternumber=new JLabel("");
        meternumber.setBounds(300,80,200,20);
        add(meternumber);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(35,140,200,20);
        add(lblname);
        
        JLabel name=new JLabel("");
        name.setBounds(300,140,200,20);
        add(name);
        
        JLabel lblmonth=new JLabel("Month");
        lblmonth.setBounds(35,200,200,20);
        add(lblmonth);
        
        Month=new Choice();
        Month.add("January");
        Month.add("February");
        Month.add("March");
        Month.add("April");
        Month.add("May");
        Month.add("June");
        Month.add("July");
        Month.add("August");
        Month.add("September");
        Month.add("October");
        Month.add("November");
        Month.add("December");
        Month.setBounds(300,200,200,20);
        add(Month);
        
        JLabel lblunit=new JLabel("Units");
        lblunit.setBounds(35,260,200,20);
        add(lblunit);
        
        units=new JLabel("");
        units.setBounds(300,260,200,20);
        add(units);
        
        JLabel lblbill=new JLabel("Total Bill");
        lblbill.setBounds(35,320,200,20);
        add(lblbill);
        
        totalbill=new JLabel("");
        totalbill.setBounds(300,320,200,20);
        add(totalbill);
        
        JLabel lblstatus=new JLabel("Status");
        lblstatus.setBounds(35,380,200,20);
        add(lblstatus);
        
        status=new JLabel("");
        status.setBounds(300,380,200,20);
        status.setForeground(Color.red);
        add(status);
        
        pay=new JButton("Pay");
        pay.setBounds(100,440,100,20);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        add(pay);
        
        back=new JButton("Back");
        back.setBounds(250,440,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meternum='"+meter+"'");
        while(rs.next()){
           meternumber.setText(meter);
           name.setText(rs.getString("name"));
        }
//        rs=c.s.executeQuery("select units,totalbill,status from bill where meternum='"+meter+"' and month='January'");
//        while(rs.next()){
//            units.setText(rs.getString("units"));
//            totalbill.setText(rs.getString("totalbill"));
//            status.setText(rs.getString("status"));
//        }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        Month.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("select * from bill where meternum='"+meter+"' and month='"+Month.getSelectedItem()+"'");
                    while(rs.next()){
                      units.setText(rs.getString("units"));
            totalbill.setText(rs.getString("totalbill"));
            status.setText(rs.getString("status"));  
                    }
          
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        );
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,100,400,300);
        add(image);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update bill set status='Paid' where meternum='"+meter+"' and month='"+Month.getSelectedItem()+"'");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter);
        }else if(ae.getSource()==back){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new PayBill("");
    }
}
