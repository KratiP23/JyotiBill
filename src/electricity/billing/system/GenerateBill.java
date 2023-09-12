/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class GenerateBill extends JFrame implements ActionListener{
    String meter;
    JButton bill;
    Choice month;
    JTextArea area;
    GenerateBill(String meter){
        this.meter=meter;
        setSize(500,750);
        setLocation(550,30);
        setLayout(new BorderLayout());
        JPanel p=new JPanel();
        JLabel heading =new JLabel("Generate Bill");
        JLabel meternum=new JLabel(meter);
        
        month=new Choice();
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        
        area=new JTextArea(50,15);
        area.setText("\n\n\t\t---------Click on the---------\n\t\t Generate Bill Button to get\n\t\tthe bill of the selected Month");
//        area.setFont(new Font("Senserif",Font.ITALIC,13));
        JScrollPane pane=new JScrollPane(area);
        bill=new JButton("Generate Bill");
        bill.addActionListener(this);
        p.add(heading);
        p.add(meternum);
        p.add(month);
        add(p,"North");
        
        add(pane,"Center");
        add(bill,"South");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c=new Conn();
            String smonth=month.getSelectedItem();
            area.setText("\n\t\tRELIANCE POWER LIMITED\n\tElectricity bill generated for the month of "+smonth+",2023\n\n\n");
            ResultSet rs=c.s.executeQuery("select * from customer where meternum='"+meter+"'");
            if(rs.next()){
                area.append("\n    Customer Name       : "+rs.getString("name"));
                area.append("\n    Meter Number           : "+rs.getString("meternum"));
                area.append("\n    Address                     : "+rs.getString("address"));
                area.append("\n    City                            : "+rs.getString("city"));
                area.append("\n    State                          : "+rs.getString("state"));
                area.append("\n    Email                         : "+rs.getString("email"));
                area.append("\n    Phone number          : "+rs.getString("phone"));
                area.append("\n-------------------------------------------------------------------");
                area.append("\n");
            }
            rs=c.s.executeQuery("select * from meterinformation where meternum='"+meter+"'");
            if(rs.next()){
                area.append("\n    Meter Location           : "+rs.getString("meter_location"));
                area.append("\n    Meter Type                 : "+rs.getString("meter_type"));
                area.append("\n    Phasecode                  : "+rs.getString("phasecode"));
                area.append("\n    Bill Type                     : "+rs.getString("billtype"));
                area.append("\n    Days                          : "+rs.getString("days"));
                area.append("\n-------------------------------------------------------------------");
                area.append("\n");
                
            }
            rs=c.s.executeQuery("select * from tax");
            if(rs.next()){
                area.append("\n    Cost per unit             : "+rs.getString("cost_per_unit"));
                area.append("\n    Meter rent                  : "+rs.getString("meter_rent"));
                area.append("\n    Service charge            : "+rs.getString("service_charge"));
                area.append("\n    Service tax                  : "+rs.getString("service_tax"));
                area.append("\n    Swachh Bharat cess     : "+rs.getString("swachh_bharat_cess"));
                area.append("\n    Fixed tax                   : "+rs.getString("fixed_tax")); 
                area.append("\n-------------------------------------------------------------------");
                area.append("\n");
            }
            rs=c.s.executeQuery("select * from bill where meternum='"+meter+"' and month='"+smonth+"'");
            if(rs.next()){
                area.append("\n    Month                       : "+rs.getString("month"));
                area.append("\n    Units consumed                : "+rs.getString("units"));
                area.append("\n    Total bill                     : "+rs.getString("totalbill"));
                area.append("\n-------------------------------------------------------------------");
                area.append("\n\n    Total Payable            : "+rs.getString("totalbill"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new GenerateBill("");
    }
}
