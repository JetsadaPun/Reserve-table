package reserveTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class statusbar extends JFrame {
    private Container cp;
    private File f = new File("data.txt");
    private FileReader fr = null;
    private BufferedReader br = null;

    public statusbar() {
        super("Status Bar");
        Initial();
        setComponent();
        Finally();
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setComponent() {

    }

    public void Finally() {
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
