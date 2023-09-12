package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author krati
 */
public class Login extends JFrame implements ActionListener{

    JButton login,signup,cancel;//globally declared
    JTextField username;
    JPasswordField password;
    Choice loginin;
    public Login(){
        super("Login Page");//super must be the first statement in the constructor
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        username=new JTextField();
        username.setBounds(400,20,150,20);
        add(username);
        password=new JPasswordField();
        password.setBounds(400,60,150,20);
        add(password);
        
        login=new JButton("Login");
        login.setBounds(330,160,100,20);
        login.addActionListener(this);
        add(login);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(450,160,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        signup=new JButton("Signup");
        signup.setBounds(380,200,100,20);
        signup.addActionListener(this);
        add(signup);
        
        loginin=new Choice();
        loginin.add("Admin");
        loginin.add("Customer");
        loginin.setBounds(400,100,150,20);
        add(loginin);
        
        JLabel name=new JLabel("Username");
        name.setBounds(300,20,100,20);//wrt frame
        add(name);
        JLabel pass=new JLabel("Password");
        pass.setBounds(300,60,100,20);//wrt frame
        add(pass);
        JLabel logininas=new JLabel("Login in as");
        logininas.setBounds(300,100,100,20);//wrt frame
        add(logininas);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/final.jpeg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,250,250);
        add(image);
        
        setSize(640,300);
        setLocation(400,200);//wrt screen
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){  //function
        if(ae.getSource()==login){
            String susername=username.getText();
            String spassword=password.getText();
            String suser=loginin.getSelectedItem();
            try{
                Conn c=new Conn();
                String query="select*from login where username='"+susername+"'and passsword='"+spassword+"'and user='"+suser+"'";
           
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    String meter=rs.getString("meternum");
                    setVisible(false);
                    new ProjectMain(suser,meter);
                }else{
                   JOptionPane.showMessageDialog(null, "Invalid Login");
                   username.setText(null);
                   password.setText("");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
