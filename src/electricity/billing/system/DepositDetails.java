package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class DepositDetails extends JFrame implements ActionListener{

    Choice meternumber,month;
    JTable table;
    JButton search,print;
    
    DepositDetails() {
       super("Deposit Details"); 
        setSize(700,600);
        setLocation(400,100);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel lblmeter=new JLabel("Search by Meter Number");
        lblmeter.setBounds(20,20,150,20);
        add(lblmeter);
        
        meternumber=new Choice();
        meternumber.setBounds(180,20,150,20);
        add(meternumber);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                meternumber.add(rs.getString("meternum"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblmonth=new JLabel("Sort by Month");
        lblmonth.setBounds(400,20,100,20);
        add(lblmonth);
        
        month=new Choice();
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
        month.setBounds(510,20,150,20);
        add(month);
        
        table=new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from bill");
        
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jp=new JScrollPane(table);
        jp.setBounds(0,100,700,600);
        add(jp);
        
        search=new JButton("Search");
        search.setBounds(90,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(200,70,80,20);
        print.addActionListener(this);
        add(print);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from bill where meternum='"+meternumber.getSelectedItem()+"' and month='"+month.getSelectedItem()+"'  ";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        
        }else if(ae.getSource()==print){
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new DepositDetails();
    }
}
