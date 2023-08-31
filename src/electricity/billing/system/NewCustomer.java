package electricity.billing.system;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
public class NewCustomer extends JFrame implements ActionListener{
JTextField name,add,City,State,Email,phonenum;
JButton next,cancel;
JLabel lblMeter;
    NewCustomer() {
        setSize(700,550);
        setLocation(400,150);
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        JLabel heading=new JLabel("New Customer");
        heading.setBounds(220,20,200,20);
        heading.setFont(new Font("calibri",Font.BOLD,20));
        p.add(heading);
        
        JLabel lblname=new JLabel("Customer Name");
        lblname.setBounds(120,70,200,25);
        p.add(lblname);
        
        name=new JTextField();
        name.setBounds(250,70,200,25);
        p.add(name);
        
        JLabel Meterno=new JLabel("Meter No.");
        Meterno.setBounds(120,120,200,25);
        p.add(Meterno);
        
        lblMeter=new JLabel("");
        lblMeter.setBounds(250,120,200,25);
        p.add(lblMeter);
        Random r=new Random();
        long number=r.nextLong()%1000000;
        lblMeter.setText(""+Math.abs(number));
        
        JLabel Address=new JLabel("Address");
        Address.setBounds(120,170,200,25);
        p.add(Address);
        
        add=new JTextField();
        add.setBounds(250,170,200,25);
        p.add(add);
        
        JLabel city=new JLabel("City");
        city.setBounds(120,210,200,25);
        p.add(city);
        
        City=new JTextField();
        City.setBounds(250,210,200,25);
        p.add(City);
        
        JLabel state=new JLabel("State");
        state.setBounds(120,260,200,25);
        p.add(state);
        
        State=new JTextField();
        State.setBounds(250,260,200,25);
        p.add(State);
        
        JLabel email=new JLabel("Email");
        email.setBounds(120,310,200,25);
        p.add(email);
        
        Email=new JTextField();
        Email.setBounds(250,310,200,25);
        p.add(Email);
        
        JLabel phone=new JLabel("Phone Number");
        phone.setBounds(120,360,200,25);
        p.add(phone);
        
        phonenum=new JTextField();
        phonenum.setBounds(250,360,200,25);
        p.add(phonenum);
        
        next= new JButton("Next");
        next.setBounds(160,420,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel= new JButton("Cancel");
        cancel.setBounds(290,420,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        add(p,"Center");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image,"West");
        getContentPane().setBackground(Color.WHITE);
      
        setVisible(true);
    }
@Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
           String sname=name.getText();
           String smeter=lblMeter.getText();
           String saddress=add.getText();
           String scity=City.getText();
           String sstate=State.getText();
           String semail=Email.getText();
           String snum=phonenum.getText();
           
           String query1="insert into customer values('"+sname+"','"+smeter+"','"+saddress+"','"+scity+"','"+sstate+"','"+semail+"','"+snum+"')";
           String query2 = "insert into login values('" + smeter + "','','" + sname + "', '', '')";
           try{
               Conn c=new Conn();
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(null, "Customer details added successfully");
               setVisible(false);
               new MeterInformation(smeter);
           }
           catch(Exception e){
               e.printStackTrace();
           }
        
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new NewCustomer();
    }
 
}
