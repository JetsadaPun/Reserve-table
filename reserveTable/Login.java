package reserveTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Login extends JFrame implements ActionListener {
    Container cp;
    JLabel Login,Username, Password;
    JPasswordField t2;
    JTextField t1;
    JButton b1,b2;
    JPanel p;

    public Login() {
        super("Login");
        Initial();
        setComponent();
        Finally();
    }

    public void setComponent() {
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(350, 110, 300, 330);
        p.setBackground(new Color(0, 0, 0, 150));

        Login = new JLabel("Login");
        Login.setFont(new Font("Sitka Text", Font.BOLD , 35));
        Login.setForeground(Color.white);

        Username = new JLabel("Username");
        Username.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        Username.setForeground(Color.white);
        t1 = new JTextField(20);

        Password = new JLabel("Password");
        Password.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        Password.setForeground(Color.white);
        t2 = new JPasswordField(20);

        b1 = new JButton("Login");
        b1.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        b1.setBackground(Color.WHITE);
        b2 = new JButton("Register");
        b2.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        b2.setBackground(Color.WHITE);

        Login.setBounds(100, 60, 100,40);
        Username.setBounds(50, 115, 70, 25);
        t1.setBounds(50, 140, 200, 25);
        Password.setBounds(50, 175, 65, 25);
        t2.setBounds(50,200, 200, 25);
        b1.setBounds(165, 245, 85, 25);
        b2.setBounds(50, 245, 85, 25);
        
        p.add(Username); p.add(Password); p.add(Login);
        p.add(t1); p.add(t2); p.add(b1); p.add(b2);
        cp.add(p);
 
        b1.setActionCommand("Login");
        b1.addActionListener(this);
        b2.setActionCommand("Register");
        b2.addActionListener(this);
        
        BufferedImage pic;
            try{
                pic = ImageIO.read(new File("img/newreserve.jpg"));
                JLabel Ipic = new JLabel(new ImageIcon(pic));
                Ipic.setBounds(0, 0, 1000, 600);
                cp.add(Ipic);
            } catch(IOException e) {}
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public void Finally() {
        this.setSize(1000,600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Login"){
            table table = new table();
            table.setVisible(true);
        }else if(e.getActionCommand() == "Register"){
            Register Register = new Register();
            Register.setVisible(true);
        }
        dispose();
    } 
}
