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
    JButton[] b;
    private String name;
    private String phone;
    private String partySize;
    private String date;
    private String time;

    public table() {
        super("Table");
        Initial();
        setComponent();
        Finally();
    }

    public table(String Name, String Phone, String Size, String Date, String Time) {
        this.name = Name;
        this.phone = Phone;
        this.partySize = Size;
        this.date = Date;
        this.time = Time;
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
        createtable();
        Button();
        BufferedImage pic;
        try {
            pic = ImageIO.read(new File("reserveTable/img/newreserve.jpg"));
            JLabel Ipic = new JLabel(new ImageIcon(pic));
            Ipic.setBounds(0, 0, 1000, 600);
            cp.add(Ipic);
        } catch (IOException e) {
        }
    }

    public void createtable() {
        JPanel p = new JPanel();
        p.setBackground(new Color(0, 0, 0, 0));
        p.setLayout(new GridLayout(5, 4, 15, 15));
        b = new JButton[20];
        for (int i = 0; i < 20; i++) {
            b[i] = new JButton("Table no. " + (i + 1));
            b[i].setFont(new Font("Sitka Text", Font.PLAIN, 9));
            b[i].setBackground(Color.WHITE);
            b[i].addMouseListener(this);
            p.add(b[i]);
        }
        p.setBounds(510, 60, 400, 400);
        cp.add(p);
    }

    public void Button() {
        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Sitka Text", Font.PLAIN, 13));
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
            for (int i = 0; i < 20; i++) {
                if (b[i].getBackground() == Color.GREEN) {
                    Detail Detail = new Detail(i + 1, this.name,
                            this.phone, this.partySize, this.date, this.time);
                    Detail.setVisible(true);
                    dispose();
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < 20; i++) {
            if (e.getSource() == b[i] && b[i].getBackground() != Color.RED) {
                for (int j = 0; j < 20; j++) {
                    b[j].setBackground(Color.WHITE);
                }
                if (b[i].getBackground() == Color.WHITE) {
                    b[i].setBackground(Color.GREEN);
                    break;
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}