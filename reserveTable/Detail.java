package reserveTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Detail extends JFrame implements ActionListener{
    Container cp;
    JLabel detail;
    JButton b1;
    JPanel p;
    int Number = 1;
    String Name = "NongPun narak";
    String Phone = "0962518548";
    String Time = "09.00";
    String Date = "01/09/2023";

    public Detail() {
        super("Reservation Details");
        Initial();
        setComponent();
        Finally();
    }

    public void setComponent() {
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(350, 110, 300, 340);
        p.setBackground(new Color(0, 0, 0, 150));

        detail = new JLabel("Reservation Details");
        detail.setFont(new Font("Sitka Text", Font.BOLD , 20));
        detail.setForeground(Color.white);

        JLabel number = new JLabel("Table No. "+Number);
        number.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        number.setForeground(Color.white);

        JLabel name = new JLabel("Name : "+Name);
        name.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        name.setForeground(Color.white);

        JLabel phone = new JLabel("Phone : "+Phone);
        phone.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        phone.setForeground(Color.white);

        JLabel date = new JLabel("Date : "+Date);
        date.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        date.setForeground(Color.white);

        JLabel time = new JLabel("Time : "+Time);
        time.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        time.setForeground(Color.white);

        b1 = new JButton("Cancel Reservation");
        b1.setFont(new Font("Sitka Text", Font.PLAIN , 13));
        b1.setBackground(Color.WHITE);

        detail.setBounds(52, 40, 200,40);
        number.setBounds(52, 90, 200, 25);
        name.setBounds(52, 120, 200,25);
        phone.setBounds(52,150, 200, 25);
        date.setBounds(52,180, 200, 25);
        time.setBounds(52,210, 200, 25);
        b1.setBounds(52,250, 200, 35);

        b1.setActionCommand("Cancel Reservation");
        b1.addActionListener(this);

        p.add(detail); p.add(number); p.add(name); p.add(phone); p.add(date); p.add(time);
        p.add(b1); cp.add(p);
 
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
        Book Book = new Book();
        Book.setVisible(true);
        dispose();
    } 
}


