package reserveTable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;

public class table extends JFrame {
    Container cp;
    JLabel Date;
    JButton[][] buttons;
    JPanel buttonPanel;
    JButton confirmButton;

    public table() {
        super("Table");
        Initial();
        setComponent();
        setConfirmButton();
        Finally();
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
    }

    public void setComponent() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 5, 10, 10));
        buttons = new JButton[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new JButton("A" + (i * 5 + j + 1)); // Create a new JButton
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Handle button click event here
                        JButton clickedButton = (JButton) e.getSource();
                        String buttonText = clickedButton.getText();
                        // Perform the desired action when a button is clicked
                        System.out.println("Button clicked: " + buttonText);
                    }
                });
                cp.add(buttons[i][j]); // Add the button to the content pane
            }
        }
    }

    public void setConfirmButton() {
        // สร้างปุ่มยืนยัน
        confirmButton = new JButton("ยืนยัน");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Confirm button clicked");
                // เพิ่มโค้ดการดำเนินการเมื่อปุ่มยืนยันถูกคลิกที่นี่
            }
        });

        cp.add(confirmButton, BorderLayout.SOUTH);
    }

    public void Finally() {
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}