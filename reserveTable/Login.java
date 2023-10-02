package reserveTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Login extends JFrame implements ActionListener, Wrong, Finally, setComponent, Initial {
    Container cp;
    Container cp2;
    JLabel Login, Username, Password;
    JPasswordField t2;
    JTextField t1;
    JButton b1, b2;
    JPanel p;
    String username, password;

    public Login() {
        super("Login");
        Initial();
        setComponent();
        BufferedImage pic;
        try {
            pic = ImageIO.read(new File("reserveTable/img/newreserve.jpg"));
            JLabel Ipic = new JLabel(new ImageIcon(pic));
            Ipic.setBounds(0, 0, 1000, 600);
            cp.add(Ipic);
        } catch (IOException e) {
        }
        Finally();
    }

    public void setComponent() {
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(350, 110, 300, 330);
        p.setBackground(new Color(0, 0, 0, 150));

        Login = new JLabel("Login");
        Login.setFont(new Font("Sitka Text", Font.BOLD, 35));
        Login.setForeground(Color.white);

        Username = new JLabel("Username");
        Username.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        Username.setForeground(Color.white);
        t1 = new JTextField(20);

        Password = new JLabel("Password");
        Password.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        Password.setForeground(Color.white);
        t2 = new JPasswordField(20);

        b1 = new JButton("Login");
        b1.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        b1.setBackground(Color.WHITE);
        b2 = new JButton("Register");
        b2.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        b2.setBackground(Color.WHITE);

        Login.setBounds(100, 60, 100, 40);
        Username.setBounds(50, 115, 70, 25);
        t1.setBounds(50, 140, 200, 25);
        Password.setBounds(50, 175, 65, 25);
        t2.setBounds(50, 200, 200, 25);
        b1.setBounds(165, 245, 85, 25);
        b2.setBounds(50, 245, 85, 25);

        p.add(Username); p.add(Password); p.add(Login);
        p.add(t1); p.add(t2); p.add(b1); p.add(b2);
        cp.add(p);

        b1.setActionCommand("Login");
        b1.addActionListener(this);
        b2.setActionCommand("Register");
        b2.addActionListener(this);

    }

    public void wrong() { //ฟังก์ชันแจ้งเตือนว่ามีข้อผิดพลาดให้ผู้ใช้ทำการตรวจสอบข้อมูลอีกครั้ง
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

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public void Finally() {
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Login") { //ถ้ากดปุ่ม Login 
            String Name = t1.getText(); //ดึงชื่อผู้ใช้จาก t1 มาเก็บในตัวแปร Name
            char[] Pass = t2.getPassword(); //ดึงรหัสผ่านจาก t2 มาเก็บในตัวแปร Pass
            String Password = new String(Pass); //แปลงรหัสผ่านจาก char array เป็น string และเก็บในตัวแปร Password

            if (!Name.isEmpty() && Password.length() >= 5) { //ตรวจสอบว่าชื่อผู้ใช้ไม่เป็นค่าว่าง และรหัสผ่านมีความยาวอย่างน้อย 5 ตัว
                try { //ถ้าเงื่อนไขถูกต้องจะตรวจสอบข้อมูลการเข้าสู่ระบบจากไฟล์ Information.txt ว่าตรงกับชื่อผู้ใช้และรหัสผ่านที่ผู้ใช้กรอกหรือไม่
                    File f = new File("Information.txt");
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);

                    String line; //เก็บข้อมูลทีละบรรทัดจากไฟล์
                    String[] parts; //สร้างอาเรย์ เพื่อเก็บข้อมูลที่ถูกแยกเป็นคู่ key-value
                    boolean found = false; 

                    while ((line = br.readLine()) != null) { //วนลูปอ่านไฟล์ทีละบรรทัด 
                        String[] keyValuePairs = line.split(",");  
                        String username = null;
                        String password = null;

                        for (String pair : keyValuePairs) { //ลูปค้นหา key-value ที่ตรงกัน
                            parts = pair.split(":"); //ใช้ : แยก key-value 
                            if (parts.length == 2) { //ตรวจสอบว่ามี key-value ที่ถูกแยกเป็น 2 ส่วน
                                String key = parts[0].trim(); //นำ key ออกมาและลบช่องว่างที่อาจจะมีด้านหน้าหรือด้านหลัง
                                String value = parts[1].trim(); //นำ value ออกมาและลบช่องว่างที่อาจจะมีด้านหน้าหรือด้านหลัง

                                if ("Username".equals(key)) { //ตรวจสอบว่า key มีค่าเท่ากับ Username หรือไม่
                                    username = value;
                                } else if ("Password".equals(key)) { //ตรวจสอบว่า key มีค่าเท่ากับ Password หรือไม่
                                    password = value;
                                }
                            }
                        }

                        if (username != null && password != null) { //ตรวจสอบว่าชื่อผู้ใช้และรหัสผ่านไม่เป็นค่าว่าง
                            if (Name.equals(username) && Password.equals(password)) {  
                                found = true;
                                break;
                            }
                        }
                    }

                    br.close();
                    if (found) { //ถ้าเจอข้อมูลที่ตรงกับชื่อผู้ใช้และรหัสผ่านจะแสดงผลหน้า Book และปิดหน้า Login
                        Book Book = new Book();
                        Book.setVisible(true);
                        dispose();
                    } else if (!found) { //ถ้าไม่เจอข้อมูลที่ตรงกับชื่อผู้ใช้และรหัสผ่าน จะเรียกใช้เมธอด wrong เพื่อแจ้งเตือนว่ามีข้อผิดพลาด
                        wrong();
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else
                wrong();
        } else if (e.getActionCommand() == "Register") { //ถ้ากดปุ่ม Register จะทำให้หน้าต่าง Register แสดงผล และปิดหน้า Login
            Register Register = new Register(); 
            Register.setVisible(true);
            dispose();
        }
    }
}
