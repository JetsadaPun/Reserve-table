package reserveTable;

import reserveTable.table;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Form2 extends JFrame implements MouseListener, ActionListener {
    Container cp;
    JLabel Booker, Phone, Quantity, Date, Time;
    JTextField t1, t2, t3, t4, t5;
    JButton b1;
    JComboBox<String> c1, c2;

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
        Date = new JLabel("Date : ");
        Time = new JLabel("Time : ");
        b1 = new JButton("Save");

        Booker.setBounds(55, 25, 65, 25);
        t1.setBounds(100, 25, 145, 22);
        Phone.setBounds(50, 50, 65, 25);
        t2.setBounds(100, 50, 145, 22);
        Quantity.setBounds(40, 75, 65, 25);
        t3.setBounds(100, 75, 145, 22);
        Date.setBounds(20, 100, 120, 22);
        Time.setBounds(150, 100, 50, 22);
        dropdown();
        b1.setBounds(100, 130, 100, 35);

        cp.add(Booker);
        cp.add(t1);
        cp.add(Phone);
        cp.add(t2);
        cp.add(Quantity);
        cp.add(t3);
        cp.add(Date);
        cp.add(Time);
        cp.add(b1);
        b1.addActionListener(this);
    }

    public void dropdown() {
        JComboBox<String> c1 = new JComboBox<>();
        c1.addItem("01/08/65");
        c1.addItem("02/08/65");
        c1.addItem("03/08/65");
        c1.setBounds(60, 100, 80, 22);
        cp.add(c1);

        JComboBox<String> c2 = new JComboBox<>();
        c2.addItem("09.00");
        c2.addItem("10.00");
        c2.addItem("11.00");
        c2.addItem("12.00");
        c2.addItem("13.00");
        c2.addItem("14.00");
        c2.addItem("15.00");
        c2.addItem("16.00");
        c2.addItem("17.00");
        c2.addItem("18.00");
        c2.addItem("19.00");
        c2.addItem("20.00");
        c2.setBounds(190, 100, 80, 22);
        cp.add(c2);
    }

    public void Finally() {
        this.setSize(300, 220);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // String name = t1.getName();
        // String phone = t2.getText();
        // String quantity = t3.getText();
        // String date = (String) c1.getSelectedItem();
        // String time = (String) c2.getSelectedItem();
        table table = new table(); // name, phone, quantity, date, time
        table.setVisible(true);
        dispose();
    }
}