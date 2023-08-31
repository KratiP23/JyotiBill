package electricity.billing.system;
import electricity.billing.system.Conn;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class MeterInformation extends JFrame implements ActionListener{
JButton submit,cancel;
Choice meterlocation,metertype,phasecode,billtype;
String meternumber;
    MeterInformation(String meternumber) 
    {
        this.meternumber=meternumber;
        setSize(700,550);
        setLocation(400,200);
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(220,20,200,20);
        heading.setFont(new Font("calibri",Font.BOLD,20));
        p.add(heading);
        
        JLabel meternum=new JLabel("Meter Number");
        meternum.setBounds(120,70,100,25);
        p.add(meternum);
        
        JLabel lblmeter=new JLabel(meternumber);
        lblmeter.setBounds(250,70,200,25);
        p.add(lblmeter);
        
        JLabel Meterloc=new JLabel("Meter Location");
        Meterloc.setBounds(120,120,100,25);
        p.add(Meterloc);
        
        meterlocation=new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(250,120,200,25);
        p.add(meterlocation);
        
        JLabel mtype=new JLabel("Meter Type");
        mtype.setBounds(120,170,100,25);
        p.add(mtype);
        
        metertype=new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(250,170,200,25);
        p.add(metertype);
        
        JLabel pcode=new JLabel("Phase Code");
        pcode.setBounds(120,210,100,25);
        p.add(pcode);
        
        phasecode=new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(250,210,200,25);
        p.add(phasecode);
        
        JLabel btype=new JLabel("Bill Type");
        btype.setBounds(120,260,100,25);
        p.add(btype);
        
        billtype=new Choice();
        billtype.add("Normal");
        billtype.add("Industrial Meter");
        billtype.setBounds(250,260,200,25);
        p.add(billtype);
        
        JLabel days=new JLabel("Days");
        days.setBounds(120,310,100,25);
        p.add(days);
        
        JLabel Days=new JLabel("30 Days");
        Days.setBounds(250,310,200,25);
        p.add(Days);
        
        JLabel note=new JLabel("Note");
        note.setBounds(120,360,100,25);
        p.add(note);
        
        JLabel Note=new JLabel("By default bill is calculated for 30 days");
        Note.setBounds(250,360,220,25);
        p.add(Note);
        
        submit= new JButton("Submit");
        submit.setBounds(160,420,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        p.add(submit);
        
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
        if(ae.getSource()==submit){
           String meter=meternumber;
           String smeterloc=meterlocation.getSelectedItem();
           String smetertype=metertype.getSelectedItem();
           String sphase=phasecode.getSelectedItem();
           String sbill=billtype.getSelectedItem();
           String days="30";
           
           String query="insert into meterinformation values('"+meter+"','"+smeterloc+"','"+smetertype+"','"+sphase+"','"+sbill+"','"+days+"')";
        try{
          Conn c=new Conn();
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null, "Meter Information added successfully");
            setVisible(false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new MeterInformation("");
    }
 
}
