package reserveTable;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class table extends JFrame implements ActionListener, MouseListener {
    Container cp;
    JLabel Date;
    JPanel buttonPanel;
    JButton confirmButton;
    JButton confirm;
    JButton check;

    private String name;
    private String phone;
    private String amount;
    private String date;
    private String time;

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
        p.setLayout(new GridLayout(5, 4, 15, 15));
        for (int i = 1; i <= 20; i++) {
            JButton b = new JButton("Table no. " + (i));
            b.setFont(new Font("Times New Roman", Font.PLAIN, 10));
            p.add(b);
        }
        p.setBounds(43, 15, 400, 400);
        cp.add(p);
    }

    public void Button() {
        confirm = new JButton("Confirm");
        confirm.setBounds(185, 425, 120, 40);
        confirm.addActionListener(this);
        confirm.setActionCommand("click_confirm");
        check = new JButton("check>>");
        check.setBounds(350, 425, 100, 40);
        check.addActionListener(this);
        check.setActionCommand("click_check");
        cp.add(check);
        cp.add(confirm);
    }

    public void Finally() {
        this.setSize(500, 510);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "click_confirm") {
            if (check.getBackground() == Color.RED)
                confirm.setBackground(Color.white);
            else
                confirm.setBackground(Color.RED);
        }
        if (e.getActionCommand() == "click_check") {
            if (check.getBackground() == Color.RED)
                check.setBackground(Color.white);
            else
                check.setBackground(Color.RED);
        }
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

}