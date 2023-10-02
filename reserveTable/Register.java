package reserveTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Register extends JFrame implements ActionListener, Complete, Finally, setComponent, Initial, Wrong {
    Container cp;
    Container cp2;
    JLabel Register, Username, Email, Password, ConfirmPassword;
    JPasswordField t3, t4;
    JTextField t1, t2;
    JButton b1, b2;
    JPanel p;

    public Register() {
        super("Register");
        Initial();
        setComponent();
        BufferedImage pic; 
        try {
            pic = ImageIO.read(new File("reserveTable/img/newreserve.jpg")); //อ่านรูปจากไฟล์ด้วย ImageIO.read() และเก็บรูปไว้ในตัวแปร pic
            JLabel Ipic = new JLabel(new ImageIcon(pic)); //นำรูปที่อ่านได้มาเป็น ImageIcon แล้วใส่ลงใน JLabel
            Ipic.setBounds(0, 0, 1000, 600);
            cp.add(Ipic); //นำ Ipic ไปแสดงบน Container
        } catch (IOException e) {
        }
        Finally();
    }

    public void setComponent() {
       
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(350, 80, 300, 410);
        p.setBackground(new Color(0, 0, 0, 150));
        
        Register = new JLabel("Register");
        Register.setFont(new Font("Sitka Text", Font.BOLD, 30));
        Register.setForeground(Color.white);
        
        Username = new JLabel("Username");
        Username.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        Username.setForeground(Color.white);
        t1 = new JTextField(20);
        
        Email = new JLabel("Email");
        Email.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        Email.setForeground(Color.white);
        t2 = new JTextField(20);
        
        Password = new JLabel("Password five or more characters");
        Password.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        Password.setForeground(Color.white);
        t3 = new JPasswordField(20);
        
        ConfirmPassword = new JLabel("Confirm Password");
        ConfirmPassword.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        ConfirmPassword.setForeground(Color.white);
        t4 = new JPasswordField(20);
        
        b1 = new JButton("Submit");
        b1.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        b1.setBackground(Color.WHITE);
        b2 = new JButton("Back");
        b2.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        b2.setBackground(Color.WHITE);

        Register.setBounds(90, 30, 140, 40);
        Username.setBounds(50, 80, 70, 25);
        t1.setBounds(50, 105, 200, 25);
        Email.setBounds(50, 135, 70, 25);
        t2.setBounds(50, 160, 200, 25);
        Password.setBounds(50, 190, 220, 25);
        t3.setBounds(50, 215, 200, 25);
        ConfirmPassword.setBounds(50, 245, 150, 25);
        t4.setBounds(50, 270, 200, 25);
        b1.setBounds(50, 315, 200, 25);
        b2.setBounds(50, 350, 200, 25);

        p.add(Register); p.add(Username); p.add(Email); p.add(Password); p.add(ConfirmPassword); //เพิ่มข้อความเข้าไปในพาแนล
        p.add(t1); p.add(t2); p.add(t3); p.add(t4); p.add(b1); p.add(b2); //เพิ่มกล่องใส่ข้อความ/รหัสผ่าน และปุ่มลงในพาแนล
        cp.add(p); //เพิ่มพาแนลเข้าไปใน container
        
        b1.setActionCommand("Submit");
        b1.addActionListener(this);
        b2.setActionCommand("Back");
        b2.addActionListener(this);
    }

    public void wrong() { //ฟังก์ชันแสดงข้อความแจ้งเตือนให้ผู้ใช้ทราบว่ามีข้อผิดพลาดเกิดขึ้น
        JDialog Di = new JDialog();
        cp2 = Di.getContentPane();
        cp2.setLayout(new FlowLayout());
        JLabel c = new JLabel("Something Wrong please check again.");
        c.setFont(new Font("Sitka Text", Font.BOLD, 15));
        cp2.add(c);
        Di.setVisible(true);
        Di.setResizable(false);
        Di.setLocationRelativeTo(null);
        Di.pack();
    }

    public void Complete() { //ฟังก์ชันแสดงข้อความบอกผู้ใช้ว่าลงทะเบียนเรียบร้อยแล้ว
        try {
            File f = new File("Information.txt");
            FileWriter fw = new FileWriter(f, true);  
            BufferedWriter bw = new BufferedWriter(fw);
            char[] passwordChar = t3.getPassword(); //ดึงรหัสผ่านจาก t3 เก็บในตัวแปร passwordChar
            String password = new String(passwordChar); //แปลงข้อมูลจาก char array เป็น string
            bw.write("Username :" + t1.getText() + "," + 
                    "Email :" + t2.getText() + "," +
                    "Password :" + password + ",\n"); //เขียนชื่อผู้ใช้ อีเมล รหัสผ่านลงในไฟล์ Information.txt
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        JDialog Di = new JDialog();
        cp2 = Di.getContentPane();
        cp2.setLayout(new FlowLayout());
        JLabel c = new JLabel("Complete.");
        c.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cp2.add(c);
        Di.setVisible(true);
        Di.setLocationRelativeTo(null);
        Di.pack();
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public void Finally() { //ฟังก์ชันแสดงหน้าแสดงผล
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) { 
        char[] passwordChars = t3.getPassword(); //ดึงรหัสผ่านจาก t3 เก็บไว้ในตัวแปร passwordChars
        char[] confirmPasswordChars = t4.getPassword(); //ดึงยืนยันรหัสผ่านจาก t4 เก็บไว้ในตัวแปร confirmPasswordChars

        String password = new String(passwordChars); //แปลงข้อมูลรหัสผ่านจาก char array เป็น string เก็บไว้ในตัวแปร password
        String confirmPassword = new String(confirmPasswordChars); //แปลงข้อมูลยืนยันรหัสผ่านจาก char array เป็น string เก็บไว้ในตัวแปร confirmPassword
        if (e.getActionCommand() == "Submit") { //ถ้ากดปุ่ม Submit จะตรวจสอบเงื่อนไขต่าง ๆ
            if (t1 != null && t2 != null && // ตรวจสอบว่าทุกรายการที่ผู้ใช้กรอกไม่ใช่ค่าว่าง และรหัสผ่านตรงกัน โดยต้องเป็นจริงทั้งหมด
                    t3 != null && t4 != null
                    && password.equals(confirmPassword) && !password.isEmpty() && password.length() >= 5) {
                Login Login = new Login(); 
                Login.setVisible(true); //ถ้าเงื่อนไขถูกต้อง จะแสดงหน้า Login 
                Complete(); //และเรียกใช้เมธอดเพื่อแจ้งว่าสมัครสมาชิกเสร็จสิ้น
                dispose(); //ปิดหน้าต่าง Register
            } else
                wrong(); //ถ้าเงื่อนไขไม่ถูกต้อง จะเรียกใช้เมธอดเพื่อเตือนว่ามีข้อผิดพลาด
        } else if (e.getActionCommand() == "Back") { //ถ้ากดปุ่ม Back จะแสดงหน้า Login และปิดหน้าต่าง Register
            Login Login = new Login(); 
            Login.setVisible(true); 
            dispose(); 
        }
    }
}
