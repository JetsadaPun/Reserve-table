package reserveTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Register extends JFrame implements ActionListener{
    Container cp;
    JLabel Register,Username,Email,Password,ConfirmPassword;
    JPasswordField t3,t4;
    JTextField t1,t2;
    JButton b1,b2;
    JPanel p;

    public Register() {
        super("Register");
        Initial();
        setComponent();
        Finally();
    }

    public void setComponent() {
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(350, 80, 300, 410);
        p.setBackground(new Color(0, 0, 0, 150));

        Register = new JLabel("Register");
        Register.setFont(new Font("Sitka Text", Font.BOLD , 30));
        Register.setForeground(Color.white);

        Username = new JLabel("Username");
        Username.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        Username.setForeground(Color.white);
        t1 = new JTextField(20);

        Email = new JLabel("Email");
        Email.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        Email.setForeground(Color.white);
        t2 = new JTextField(20);

        Password = new JLabel("Password");
        Password.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        Password.setForeground(Color.white);
        t3 = new JPasswordField(20);

        ConfirmPassword = new JLabel("Confirm Password");
        ConfirmPassword.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        ConfirmPassword.setForeground(Color.white);
        t4 = new JPasswordField(20);

        b1 = new JButton("Submit");
        b1.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        b1.setBackground(Color.WHITE);
        b2 = new JButton("Back");
        b2.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        b2.setBackground(Color.WHITE);

        Register.setBounds(90, 30, 140,40);
        Username.setBounds(50, 80, 70, 25);
        t1.setBounds(50, 105, 200, 25);
        Email.setBounds(50, 135, 70, 25);
        t2.setBounds(50,160, 200, 25);
        Password.setBounds(50, 190, 65, 25);
        t3.setBounds(50,215, 200, 25);
        ConfirmPassword.setBounds(50, 245, 150, 25);
        t4.setBounds(50,270, 200, 25);
        b1.setBounds(50, 315, 200, 25);
        b2.setBounds(50, 350, 200, 25);

        p.add(Register); p.add(Username); p.add(Email); p.add(Password); p.add(ConfirmPassword);
        p.add(t1); p.add(t2); p.add(t3); p.add(t4); p.add(b1); p.add(b2);
        cp.add(p);

        b1.setActionCommand("Submit");
        b1.addActionListener(this);
        b2.setActionCommand("Back");
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
        if(e.getActionCommand() == "Submit"){
            Login Login = new Login();
            Login.setVisible(true);
        }else if(e.getActionCommand() == "Back"){
            Login Login = new Login();
            Login.setVisible(true);
        } //ส่งข้อมูลกลับไปดาต้าเบส กีต้ายะฮู้ว
        dispose();
    } 
}

