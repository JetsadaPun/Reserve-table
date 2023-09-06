package reserveTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Form1 extends JFrame implements ActionListener {
    Container cp, cp2;
    JLabel Name, Password;
    JPasswordField t2;
    JTextField t1;
    JButton b1;

    public Form1() {
        super("Login");
        Initial();
        setComponent();
        Finally();
    }

    public void setComponent() {

        Name = new JLabel("Name : ");
        t1 = new JTextField(20);
        Password = new JLabel("Password : ");
        t2 = new JPasswordField(20);
        b1 = new JButton("Sign in");

        Name.setBounds(35, 20, 65, 25);
        t1.setBounds(80, 20, 145, 22);
        Password.setBounds(12, 47, 65, 25);
        t2.setBounds(80, 50, 145, 22);
        b1.setBounds(80, 80, 90, 25);

        b1.setBackground(Color.WHITE);

        cp.add(Name);
        cp.add(t1);
        cp.add(Password);
        cp.add(t2);
        cp.add(b1);

        b1.setActionCommand("b1");
        b1.addActionListener(this);
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public void Finally() {
        this.setSize(250, 160);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Form2 Form2 = new Form2();
        Form2.setVisible(true);
        dispose();
    }
}
