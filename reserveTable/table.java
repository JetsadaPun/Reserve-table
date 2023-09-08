package reserveTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class table extends JFrame implements ActionListener, MouseListener {
    Container cp;
    JLabel Date;
    JPanel buttonPanel;
    JButton confirm;
    JButton check;

    // private String name;
    // private String phone;
    // private String amount;
    // private String date;
    // private String time;

    public table() { // String Name, String Phone, String Quantity, String Date, String Time
        super("Table");
        // this.name = Name;
        // this.phone = Phone;
        // this.amount = Quantity;
        // this.date = Date;
        // this.time = Time;
        Initial();
        setComponent();
        Finally();
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public void setComponent() {
        // detail();
        table();
        Button();

        BufferedImage pic;
            try{
                pic = ImageIO.read(new File("img/newreserve.jpg"));
                JLabel Ipic = new JLabel(new ImageIcon(pic));
                Ipic.setBounds(0, 0, 1000, 600);
                cp.add(Ipic);
            } catch(IOException e) {}
    }

    // public void detail() {
    // JPanel detail = new JPanel();
    // detail.setLayout(new FlowLayout());
    // JLabel nameLabel = new JLabel("Name: " + name);
    // JLabel phoneLabel = new JLabel("Phone: " + phone);
    // JLabel quantityLabel = new JLabel("Amount: " + amount);
    // JLabel dateLabel = new JLabel("Date: " + date);
    // JLabel timeLabel = new JLabel("Time: " + time);
    // detail.add(nameLabel);
    // detail.add(phoneLabel);
    // detail.add(quantityLabel);
    // detail.add(dateLabel);
    // detail.add(timeLabel);

    // cp.add(detail);
    // }

    public void table() {
        JPanel p = new JPanel();
        p.setBackground(new Color(0, 0, 0, 0));
        p.setLayout(new GridLayout(5, 4, 15, 15));
        for (int i = 1; i <= 20; i++) {
            JButton b = new JButton("Table no. " + (i));
            b.setFont(new Font("Sitka Text", Font.PLAIN, 9));
            b.setBackground(Color.WHITE);
            p.add(b);
        }
        p.setBounds(510, 60, 400, 400);
        cp.add(p);
    }

    public void Button() {
        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        confirm.setBackground(Color.WHITE);
        confirm.setBounds(810, 480, 100, 40);
        confirm.addActionListener(this);
        confirm.setActionCommand("click_confirm");
        cp.add(confirm);
    }

    public void Finally() {
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "click_confirm") {
            Book Book = new Book();
            Book.setVisible(true);
            if (check.getBackground() == Color.RED)
                confirm.setBackground(Color.white);
            else
                confirm.setBackground(Color.RED);
            
        }
    }

    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

}