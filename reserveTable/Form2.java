package reserveTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Form2 extends JFrame {
    Container cp;
    JLabel Booker, Phone, Quantity, Date, Time;
    JTextField t1, t2, t3, t4, t5;
    JButton b1;

    public Form2() {
        super("Booking");
        Initial();
        setComponent();
        Finally();
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public void setComponent() {
        Booker = new JLabel("Name : ");
        t1 = new JTextField(20);
        Phone = new JLabel("Phone : ");
        t2 = new JTextField(20);
        Quantity = new JLabel("Quantity : ");
        t3 = new JTextField(20);

        Booker.setBounds(55, 25, 65, 25);
        t1.setBounds(100, 25, 145, 22);
        Phone.setBounds(50, 50, 65, 25);
        t2.setBounds(100, 50, 145, 22);
        Quantity.setBounds(40, 75, 65, 25);
        t3.setBounds(100, 75, 145, 22);

        cp.add(Booker);
        cp.add(t1);
        cp.add(Phone);
        cp.add(t2);
        cp.add(Quantity);
        cp.add(t3);
    }

    public void Finally() {
        this.setSize(300, 250);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
