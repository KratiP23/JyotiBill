
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
public class SplashScreen extends JFrame implements Runnable{

    public SplashScreen() {
        Thread t;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2=i1.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        setVisible(true);
        int x=1;
        for(int i=2;i<600;i+=4,x+=1){
            setSize(i+x,i);
        setLocation(700-((i+x)/2), 400-(i/2));
      
        }
      t=new Thread(this);
      t.start();
    }
    public void run(){
        try{
            Thread.sleep(5000);//7 seconds baad frame close ho jayega
             setVisible(false);    
             //login frame
             new Login();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new SplashScreen();//object constructor ko call karta hai 
 
    }
    
}
