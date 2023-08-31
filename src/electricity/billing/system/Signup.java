package electricity.billing.system;

import java.awt.Choice;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.border.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author krati
 */
public class Signup extends JFrame implements ActionListener{
JButton create,back;
Choice accountType;
JTextField meternum,username,password,name;
    Signup(){
       setBounds(450,150,725,400);
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       //panel is just like a frame
       JPanel panel=new JPanel();
       panel.setBounds(30,30,650,300);
       panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(173,216,230)));
       panel.setBackground(Color.white);
       panel.setLayout(null);
       panel.setForeground(new Color(34,139,34));
       add(panel);
       
       JLabel heading=new JLabel("Create Account as");
       heading.setBounds(100, 50, 140, 20);
       heading.setForeground(Color.gray);
       heading.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(heading);
       
       accountType = new Choice();
       accountType.add("Admin");
       accountType.add("Customer");
       accountType.setBounds(260,50,150,20);
       panel.add(accountType);
       
       JLabel meter=new JLabel("Meter Number");
       meter.setBounds(100, 90, 140, 20);
       meter.setForeground(Color.gray);
       meter.setFont(new Font("Tahoma",Font.BOLD,14));
       meter.setVisible(false);
       panel.add(meter);
       
       meternum=new JTextField();
       meternum.setBounds(260,90,150,20);
       meternum.setVisible(false);
       panel.add(meternum);
       
       
       JLabel user=new JLabel("Username");
       user.setBounds(100, 130, 140, 20);
       user.setForeground(Color.gray);
       user.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(user);
       
       username=new JTextField();
       username.setBounds(260,130,150,20);
       panel.add(username);
       
       JLabel fullname=new JLabel("Name");
       fullname.setBounds(100,170,140,20);
       fullname.setForeground(Color.gray);
       fullname.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(fullname);
       
       name=new JTextField();
       name.setBounds(260,170,150,20);
       panel.add(name);
       
       meternum.addFocusListener(new FocusListener() {
           @Override
           public void focusGained(FocusEvent fe) {
               
           }

           @Override
           public void focusLost(FocusEvent fe) {
               try{
                  Conn c=new Conn();
                  ResultSet rs=c.s.executeQuery("select*from login where meternum='"+meternum.getText()+"'");
                  while(rs.next()){
                      name.setText(rs.getString("name"));
                  }
               }
               catch(Exception e){
                   e.printStackTrace();
               }
           }
       });
       
       
       JLabel pass=new JLabel("Password");
       pass.setBounds(100, 210, 140, 20);
       pass.setForeground(Color.gray);
       pass.setFont(new Font("Tahoma",Font.BOLD,14));
       panel.add(pass);
       
       password=new JTextField();
       password.setBounds(260,210,150,20);
       panel.add(password);
       
       accountType.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent ie){
               String user=accountType.getSelectedItem();
               if(user.equals("Customer")){
                   meter.setVisible(true);
                   meternum.setVisible(true);
                   name.setEditable(false);
                   
               }else{
                   meternum.setVisible(false);
                   meter.setVisible(false);
                   name.setEditable(true);
               }
           }
       }
       );
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(420,20,250,250);
        panel.add(image);
        
        create= new JButton("Create");
        create.setBounds(140,250,120,20);
        create.addActionListener(this);
        panel.add(create);
        
        
        back= new JButton("Back");
        back.setBounds(300,250,120,20);
        back.addActionListener(this);
        panel.add(back);
        
        setVisible(true);
        
    }
@Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            String atype=accountType.getSelectedItem();
            String suser=username.getText();
            String sname=name.getText();
            String spass=password.getText();         
            String smeter=meternum.getText();
            //string ko break karke concat
            try{
               Conn c=new Conn();
               String query=null;
               if(accountType.equals("Admin")){
                   query="insert into login values('"+smeter+"','"+suser+"','"+sname+"','"+spass+"','"+atype+"')";
               }
               else{
                   query="update login set username='"+suser+"',passsword='"+spass+"',user='"+atype+"' where meternum='"+smeter+"' ";
               }
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Account created successfully");
                setVisible(false);
                new Login();
            
            }catch(Exception e){
                e.printStackTrace();
            }
            
        } else if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Signup();
    }
}
