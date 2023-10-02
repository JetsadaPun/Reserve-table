package reserveTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.*;

public class table extends JFrame implements ActionListener, MouseListener, Button, createtable, Finally, setComponent, Initial {
    Container cp3;
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
    boolean color = true;
    JButton prevBT = null;

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
        Createtable();
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

    public void Createtable() { 
        JPanel p = new JPanel();
        p.setBackground(new Color(0, 0, 0, 0));
        p.setLayout(new GridLayout(5, 4, 15, 15));
        b = new JButton[20];

        for (int i = 0; i < 20; i++) { //ลูปทำงาน 20 รอบ
            b[i] = new JButton("Table no. " + (i + 1)); //สร้างปุ่มที่บอกว่าเป็นโต๊ะที่i+1(เลขโต๊ะที่ถูกสร้างขึ้นในรอบนั้น ๆ ของลูป)
            try { //อ่านไฟล์ DayTable.txt เพื่อตรวจสอบว่ามีการจองโต๊ะหรือไม่
                File fi = new File("DayTable.txt");
                FileReader fr = new FileReader(fi); 
                BufferedReader br = new BufferedReader(fr);
                String s;
                while ((s = br.readLine()) != null) { 
                    String[] parts = s.split(","); //ใช้ , แยกข้อมูลในบรรทัด
                    if (parts.length >= 3) { //ตรวจสอบว่ามีข้อมูลอย่าวน้อย 3 ส่วนหรือไม่
                        String tableDate = parts[0].trim(); //ดึงวันที่จาก parts เก็บในตัวแปร tableDate
                        String tableTime = parts[1].trim(); //ดึงเวลาจาก parts เก็บในตัวแปร tableTime
                        int tableNumber = Integer.parseInt(parts[2].trim()); //แปลงข้อมูลตัวเลขเป็น integer และเก็บใน tableNumber
                        System.out.println(tableDate); 
                        System.out.println(tableTime);
                        System.out.println(tableNumber);
                        if (tableDate.equals(date) && tableTime.equals(time) && tableNumber == (i + 1)) { //ตรวจสอบว่าข้อมูลการจองในไฟล์ DayTable.txt ตรงกับวันที่ เวลา และเลขโต๊ะ
                            color = false; //ถ้าตรงกำหนด color เป็น false(ไม่สามารถจองได้)
                            continue; //ข้ามการตรวจสอบต่อไป
                        }
                    }
                }
                br.close();
                fr.close();
            } catch (Exception e) { 
                System.out.println(e);
            }
            if (color) { //ถ้า color เป็น true ปุ่มจะเป็นสีขาว
                b[i].setBackground(Color.WHITE);
            } else if (!color) { //ถ้า color เป็น false ปุ่มจะเป็นสีแดง 
                b[i].setBackground(Color.RED);
                color = true; //ปุ่มถัดไปพื้นหลังจะเป็นสีขาว
            }
            b[i].setFont(new Font("Sitka Text", Font.PLAIN, 9));
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
        if (e.getActionCommand() == "click_confirm") { //ถ้ากดปุ่ม Confirm 
            for (int i = 0; i < 20; i++) { //วนลูปตรวจสถานะของปุ่มโต๊ะ 20 ปุ่ม
                if (b[i].getBackground() == Color.GREEN) { //ตรวจสอบว่าปุ่มโต๊ะเป็นสีเขียวหรือไม่ ถ้าเป็นสีเขียว จะแสดงหน้า Detail และปิดหน้า table
                    Detail Detail = new Detail(i + 1, this.name, this.phone, this.partySize, this.date, this.time);
                    Detail.setVisible(true);
                    dispose();
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < 20; i++) { //วนลูปตรวจสอบการคลิกปุ่มโต๊ะ 20 ปุ่ม
            if (e.getSource() == b[i] && b[i].getBackground() != Color.RED) { //ตรวจสอบว่าปุ่มที่ i ไม่ใช่สีแดง
                if (b[i].getBackground() == Color.WHITE) { //ตรวจสอบว่าปุ่มเป็นสีขาวหรือไม่
                    if (prevBT != null) { //ถ้าปุ่มก่อนหน้าไม่เท่ากับ null จะขึ้นเป็นสีขาว
                        prevBT.setBackground(Color.WHITE);
                    }
                    b[i].setBackground(Color.GREEN); //กำหนดพื้นหลังของปุ่มที่ i เป็นสีเขียว
                    prevBT = b[i]; //สั่งให้ prev เป็นปุ่มที่ i
                    break;
                }
            }
        }
    }
    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
}