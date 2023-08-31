package electricity.billing.system;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.sql.*;
public class CalculateBill extends JFrame implements ActionListener{
    
JTextField unitconsumed;
JButton submit,cancel;
JLabel Name,add;
Choice meternum,Month;
    CalculateBill() {
        setSize(700,500);
        setLocation(400,150);
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        JLabel heading=new JLabel("Calculate Electricity Bill");
        heading.setBounds(200,20,200,20);
        heading.setFont(new Font("calibri",Font.BOLD,20));
        p.add(heading);
        
        JLabel lblmeter=new JLabel("Meter No.");
        lblmeter.setBounds(120,70,100,25);
        p.add(lblmeter);
        
        meternum=new Choice();
        try{
            Conn c=new Conn();
           ResultSet rs= c.s.executeQuery("select *from customer");
        while(rs.next()){
            meternum.add(rs.getString("meternum"));//column name
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        meternum.setBounds(250,70,200,25);
        p.add(meternum);
        
        JLabel name=new JLabel("Name");
        name.setBounds(120,120,200,25);
        p.add(name);
        
        Name=new JLabel("");
        Name.setBounds(250,120,200,25);
        p.add(Name);
        
        JLabel Address=new JLabel("Address");
        Address.setBounds(120,170,200,25);
        p.add(Address);
        
        add=new JLabel();
        add.setBounds(250,170,200,25);
        p.add(add);
        
       
        meternum.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                 try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("select*from customer where meternum='"+meternum.getSelectedItem()+"'");
                    while(rs.next()){
                    Name.setText(rs.getString("name"));
                    add.setText(rs.getString("address"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            }
        }
        
        );
        
        JLabel units=new JLabel("Units Consumed");
        units.setBounds(120,220,200,25);
        p.add(units);
        
        unitconsumed=new JTextField();
        unitconsumed.setBounds(250,220,200,25);
        p.add(unitconsumed);
        
        JLabel month=new JLabel("Month");
        month.setBounds(120,270,100,25);
        p.add(month);
        
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
        Month.setBounds(250,270,200,25);
        p.add(Month);
        
        submit= new JButton("Submit");
        submit.setBounds(160,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        p.add(submit);
        
        cancel= new JButton("Cancel");
        cancel.setBounds(290,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        add(p,"Center");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image,"West");
        getContentPane().setBackground(Color.WHITE);
      
        setVisible(true);
    }
@Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
           String smeter=meternum.getSelectedItem();
           String sunits=unitconsumed.getText();
           String smonth=Month.getSelectedItem();
           
           int totalbill=0;
           int unit_consumed=Integer.parseInt(sunits);
           String query="select * from tax";
           try{
              Conn c=new Conn();
              ResultSet rs=c.s.executeQuery(query);
              while(rs.next()){
                 totalbill+= unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                 totalbill+=Integer.parseInt(rs.getString("meter_rent"));
                 totalbill+=Integer.parseInt(rs.getString("service_charge"));
                 totalbill+=Integer.parseInt(rs.getString("service_tax"));
                 totalbill+=Integer.parseInt(rs.getString("swachh_bharat_cess"));
                 totalbill+=Integer.parseInt(rs.getString("fixed_tax"));
              }
              
           }
           catch(Exception e){
               e.printStackTrace();
           }
          String query2="insert into bill values('"+smeter+"','"+smonth+"','"+sunits+"','"+totalbill+"','Not Paid')";
          try{
              Conn c=new Conn();
              c.s.executeUpdate(query2);
              JOptionPane.showMessageDialog(null, "Customer Bill updated Successsfully");
          }
          catch(Exception e){
              e.printStackTrace();
          }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CalculateBill();
    }
}
