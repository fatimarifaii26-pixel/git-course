import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AWTACCUMULATOR extends JFrame implements ActionListener {
    private JLabel lbinput;
    private JLabel lboutput;
    private JTextField tfinput;
    private JTextField tfoutput;
    private int sum = 0;

    public AWTACCUMULATOR() {
        super("AWT ACCUMULATOR");
        setLayout(new FlowLayout());
        Container cp = getContentPane();

        lbinput = new JLabel("Enter an integer:");
        cp.add(lbinput);

        tfinput = new JTextField(10);
        cp.add(tfinput);
        tfinput.addActionListener(this);

        lboutput = new JLabel("Accumulated sum:");
        cp.add(lboutput);

        tfoutput = new JTextField(10);
        tfoutput.setEditable(false);
        cp.add(tfoutput);

        setSize(350, 120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        int num = Integer.parseInt(tfinput.getText());
        sum += num;
        tfinput.setText("");
        tfoutput.setText(String.valueOf(sum));
    }

    public static void main(String[] args) {
        new AWTACCUMULATOR();
    }
}
