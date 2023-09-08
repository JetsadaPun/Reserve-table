package reserveTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Form extends JFrame implements KeyListener, MouseListener, ActionListener {
    Container cp, cp2;
    JLabel Name, Password;
    JPasswordField t2;
    JTextField t1;
    JButton b1;
    int i = 0;
    String s;
    boolean test;
    Color backup;
    File f;
    FileReader fr;
    BufferedReader br;

    public Form() {
        Initial();
        setComponent();
        Finally();
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public void setComponent() {
        Name = new JLabel("Name : ");
        t1 = new JTextField(20);
        Password = new JLabel("Password : ");
        t2 = new JPasswordField(20);
        b1 = new JButton("Sign in");

        Name.setBounds(40, 20, 65, 25);
        t1.setBounds(65, 20, 120, 20);
        Password.setBounds(20, 45, 65, 25);
        t2.setBounds(65, 50, 160, 20);
        b1.setBounds(40, 80, 70, 25);

        b1.setBackground(Color.WHITE);

        cp.add(Name);
        cp.add(t1);
        cp.add(Password);
        cp.add(t2);
        cp.add(b1);
        t1.addKeyListener(this);
        t2.addKeyListener(this);

        b1.setActionCommand("b1");
        b1.addActionListener(this);

        b1.addMouseListener(this);
    }

    public void Check(boolean x) {
        JDialog D = new JDialog();
        cp2 = D.getContentPane();
        cp2.setLayout(new FlowLayout());
        if (x == true) {
            try {
                f = new File("text1.csv");
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("ID : " + t1.getText() + "," + "Name : " + t2.getPassword() + "," + "\n");
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            JLabel Complete = new JLabel("Complete.");
            cp2.add(Complete);
        } else if (test == false) {
            JLabel Wrong = new JLabel("Wrong.");
            cp2.add(Wrong);
        }
        D.pack();
        D.setVisible(true);
        D.setLocationRelativeTo(null);
    }

    public void Finally() {
        this.setSize(250, 190);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("b1")) {
            for (int i = 0; i < t1.getText().length(); i++) {
                char c = t1.getText().charAt(i);
                if (c == ' ')
                    test = false;
                else
                    test = true;
            }
            Check(test);

        }
        Login Form1 = new Login();
        Form1.setVisible(true);
        dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == t1) {
            if (!Character.isDigit(e.getKeyChar()))
                e.consume();
        } else if (e.getSource() == t2) {
            if (!Character.isAlphabetic(e.getKeyChar()))
                e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == b1) {
            backup = b1.getBackground();
            b1.setBackground(Color.PINK);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == b1) {
            b1.setBackground(backup);
        }
    }

}
