import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupermarketBillingSystem {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField itemField, priceField, quantityField;
    private JLabel totalLabel;
    private double totalAmount = 0.0;
    
    public SupermarketBillingSystem() {
        frame = new JFrame("Supermarket Billing System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Table Setup
        String[] columns = {"Item", "Price", "Quantity", "Total"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Input Fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 4));
        itemField = new JTextField();
        priceField = new JTextField();
        quantityField = new JTextField();
        JButton addButton = new JButton("Add Item");
        inputPanel.add(new JLabel("Item:"));
        inputPanel.add(itemField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(addButton);

        // Total Label
        totalLabel = new JLabel("Total: $0.0");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(totalLabel);

        // Add Action Listener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        // Adding Components to Frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addItem() {
        String item = itemField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());
        double total = price * quantity;
        totalAmount += total;
        
        model.addRow(new Object[]{item, price, quantity, total});
        totalLabel.setText("Total: $" + totalAmount);
        
        itemField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }

    public static void main(String[] args) {
        new SupermarketBillingSystem();
    }
}
