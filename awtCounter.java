import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class awtCounter extends JFrame implements ActionListener {
    private JLabel l1;
    private JTextField t1;
    private JButton b1, b2, b3;
    private int sum = 0;

    public awtCounter() {
        super("AWT COUNTER");
        l1 = new JLabel("counter");
        t1 = new JTextField(10);

        b1 = new JButton("count up");
        b2 = new JButton("count down");
        b3 = new JButton("reset");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        l1.setFont(new Font("Arial", Font.PLAIN, 24)); // حجم الخط 24
        t1.setFont(new Font("Arial", Font.PLAIN, 24));

        setLayout(new FlowLayout()); // أسهل من BoxLayout
        add(l1);
        add(t1);
        add(b1);
        add(b2);
        add(b3);

        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if (x == b1)
            sum++;
        if (x == b2)
            sum--;
        if (x == b3)
            sum = 0;
        t1.setText(String.valueOf(sum));
    }

    public static void main(String[] args) {
        new awtCounter();
    }
}
