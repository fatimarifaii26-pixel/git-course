# git-course
simple code application
[comboboxi.java](https://github.com/user-attachments/files/30390335/comboboxi.java)

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class comboboxi extends JFrame implements ActionListener {
    public JComboBox<String> cmb;
    JTextField t1;
    JButton b1;

    public comboboxi() {
        super("Combobox Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cmb = new JComboBox<>();
        t1 = new JTextField(10);
        b1 = new JButton("Add");

        b1.addActionListener(this);

        setLayout(new FlowLayout());
        add(cmb);
        add(t1);
        add(b1);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new comboboxi();
    }

    public void actionPerformed(ActionEvent e) {
        cmb.addItem(t1.getText());
        t1.setText("");
    }
}
