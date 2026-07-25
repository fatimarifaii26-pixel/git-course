import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

class BankAccount implements Serializable {
    private int accountID;
    private static int ID;
    private String accountType;
    private double balance;

    public BankAccount(String accountType, double balance) {
        ID++;
        accountID = ID;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return accountType + " Account " + accountID + " : Balance= $" + balance;
    }
}

// GUI Application
public class BankApp extends JFrame implements ActionListener {
    JList<BankAccount> accountList;
    DefaultListModel<BankAccount> listModel;
    JLabel amountLbl, messageLbl;
    JTextField amountField;
    JButton transactionBtn;
    JRadioButton depositRd, withdrawRd;
    ButtonGroup bg;

    public BankApp() {
        super("Bank Account System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Accounts
        listModel = new DefaultListModel<>();
        listModel.addElement(new BankAccount("Savings", 500));
        listModel.addElement(new BankAccount("Checking", 300));
        accountList = new JList<>(listModel);
        add(new JScrollPane(accountList), BorderLayout.WEST);

        // Center panel
        JPanel center = new JPanel(new GridLayout(3, 2));
        amountLbl = new JLabel("Amount:");
        amountField = new JTextField();
        depositRd = new JRadioButton("Deposit");
        withdrawRd = new JRadioButton("Withdraw");
        bg = new ButtonGroup();
        bg.add(depositRd);
        bg.add(withdrawRd);
        center.add(amountLbl);
        center.add(amountField);
        center.add(depositRd);
        center.add(withdrawRd);
        add(center, BorderLayout.CENTER);

        // South panel
        JPanel south = new JPanel(new GridLayout(2, 1));
        transactionBtn = new JButton("Transaction");
        transactionBtn.addActionListener(this);
        messageLbl = new JLabel("Message will appear here");
        south.add(transactionBtn);
        south.add(messageLbl);
        add(south, BorderLayout.SOUTH);

        setSize(500, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleTransaction();
    }

    // Method required by the exercise
    public void handleTransaction() {
        BankAccount selected = accountList.getSelectedValue();
        if (selected == null) {
            messageLbl.setText("Please select an account!");
            return;
        }
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (depositRd.isSelected()) {
                selected.deposit(amount);
                messageLbl.setText("Deposit successful!");
            } else if (withdrawRd.isSelected()) {
                if (selected.withdraw(amount)) {
                    messageLbl.setText("Withdraw successful!");
                } else {
                    messageLbl.setText("Insufficient balance!");
                }
            } else {
                messageLbl.setText("Select Deposit or Withdraw!");
            }
            accountList.repaint(); // refresh list to show updated balance
        } catch (NumberFormatException ex) {
            messageLbl.setText("Enter a valid number!");
        }
    }

    public static void main(String[] args) {
        new BankApp();
    }
}
