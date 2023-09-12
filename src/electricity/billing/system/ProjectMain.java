package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author krati
 */
public class ProjectMain extends JFrame implements ActionListener{
    String suser,meter;
    public ProjectMain(String suser,String meter) {
        this.suser=suser;
        this.meter=meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/et.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 850,Image.SCALE_DEFAULT );
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);        
        JMenu master=new JMenu("Master");
        master.setForeground(Color.DARK_GRAY);
        
        
        JMenuItem newcustomer=new JMenuItem("New Customer");
        newcustomer.setFont(new Font("calibri",Font.PLAIN,12));
        newcustomer.setBackground(Color.white);
        master.add(newcustomer); 
        newcustomer.addActionListener(this);
        newcustomer.setMnemonic('D');
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        
        JMenuItem customerdetails=new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("calibri",Font.PLAIN,12));
        customerdetails.setBackground(Color.white);
        master.add(customerdetails);
        customerdetails.addActionListener(this);        
        customerdetails.setMnemonic('M');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        
        JMenuItem depositdetails=new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("calibri",Font.PLAIN,12));
        depositdetails.setBackground(Color.white);
        master.add(depositdetails);        
        depositdetails.addActionListener(this);
        depositdetails.setMnemonic('N');
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        
        JMenuItem calculatebill=new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("calibri",Font.PLAIN,12));
        calculatebill.setBackground(Color.white);
        master.add(calculatebill);  
        calculatebill.addActionListener(this);
        calculatebill.setMnemonic('Z');
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
        
        JMenu info=new JMenu("Information");
        info.setForeground(Color.red);

        JMenuItem updateinfo=new JMenuItem("Update Information");
        updateinfo.setFont(new Font("calibri",Font.PLAIN,12));
        updateinfo.setBackground(Color.white);
        info.add(updateinfo);  
        updateinfo.addActionListener(this);
        updateinfo.setMnemonic('L');
        updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        
        JMenuItem viewinfo=new JMenuItem("View Information");
        viewinfo.setFont(new Font("calibri",Font.PLAIN,12));
        viewinfo.setBackground(Color.white);
        info.add(viewinfo);  
        viewinfo.addActionListener(this);
        viewinfo.setMnemonic('K');
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
        
        JMenu user=new JMenu("User");
        user.setForeground(Color.DARK_GRAY);
        
        JMenuItem paybill=new JMenuItem("Pay bill");
        paybill.setFont(new Font("calibri",Font.PLAIN,12));
        paybill.setBackground(Color.white);
        paybill.addActionListener(this);
        user.add(paybill);        
        paybill.setMnemonic('P');
        
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        
        JMenuItem billdetails=new JMenuItem("Bill Details");
        billdetails.setFont(new Font("calibri",Font.PLAIN,12));
        billdetails.setBackground(Color.white);
        user.add(billdetails);  
        billdetails.addActionListener(this);
        billdetails.setMnemonic('B');
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        
        JMenu report=new JMenu("Report");
        report.setForeground(Color.red);
        
        JMenuItem generatebill=new JMenuItem("Generate bill");
        generatebill.setFont(new Font("calibri",Font.PLAIN,12));
        generatebill.setBackground(Color.white);
        report.add(generatebill); 
        generatebill.addActionListener(this);
        generatebill.setMnemonic('R');
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.DARK_GRAY);
        
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setFont(new Font("calibri",Font.PLAIN,12));
        notepad.setBackground(Color.white);
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image1=icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image1));
        utility.add(notepad);   
        notepad.addActionListener(this);
        notepad.setMnemonic('O');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        
        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setFont(new Font("calibri",Font.PLAIN,12));
        calculator.setBackground(Color.white);
        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image2=icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image2));
        utility.add(calculator);
        calculator.addActionListener(this);
        calculator.setMnemonic('C');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        
        JMenuItem web=new JMenuItem("Web Browser");
        web.setFont(new Font("calibri",Font.PLAIN,12));
        web.setBackground(Color.white);
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon10.png"));
        Image image3=icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        web.setIcon(new ImageIcon(image3));
        utility.add(web); 
        web.addActionListener(this);
        web.setMnemonic('W');
        web.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        
        JMenu mexit=new JMenu("Exit");
        mexit.setForeground(Color.red);
        
        JMenuItem exit=new JMenuItem("Exit");
        exit.setFont(new Font("calibri",Font.PLAIN,12));
        exit.setBackground(Color.white);
        mexit.add(exit);    
        exit.addActionListener(this);
        exit.setMnemonic('E');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        
        if(suser.equals("Admin")){
        mb.add(master);
        }
        else if(suser.equals("Customer")){
        mb.add(info);
        mb.add(user);
        mb.add(report);
        }
        mb.add(utility);
        mb.add(mexit);
        
        setLayout(new FlowLayout());
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
        }else if(msg.equals("Customer Details")){
            new CustomerDetails();
        }else if(msg.equals("Deposit Details")){
            new DepositDetails();
        }else if(msg.equals("Calculate Bill")){
           new CalculateBill();
        }
        else if(msg.equals("View Information")){
            new ViewInformation(meter);
        }else if(msg.equals("Update Information")){
            new UpdateInfo(meter);
        }else if(msg.equals("Bill Details")){
            new BillDetails(meter);
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.endsWith("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        }else if(msg.equals("Pay bill")){
            new PayBill(meter);
        }else if(msg.equals("Generate bill")){
            new GenerateBill(meter);
        }
        
    }
      public static void main(String[] args) {
        new ProjectMain("","");
    }
}
