import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LCPanel extends JPanel {
    private JTextField bankField, kursField, korespondenField, expirationField;
    private JTextField supplierField, amountField, contractField;
    private JTextField goodsField, shipmentField, destinationField;
    private JButton exportButton;

    public LCPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Judul
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("PERMINTAAN PEMBUKAAN L/C IMPOR"), gbc);

        // Form fields
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("Bank:"), gbc);
        gbc.gridx = 1;
        bankField = new JTextField("BCA", 20);
        add(bankField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Kurs:"), gbc);
        gbc.gridx = 1;
        kursField = new JTextField("6.711,15/Yen 100", 20);
        add(kursField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Koresponden:"), gbc);
        gbc.gridx = 1;
        korespondenField = new JTextField("", 20);
        add(korespondenField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Expiration Date:"), gbc);
        gbc.gridx = 1;
        expirationField = new JTextField("4-4-2016", 20);
        add(expirationField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Supplier:"), gbc);
        gbc.gridx = 1;
        supplierField = new JTextField("YAMAHA CO.LTD", 20);
        add(supplierField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Amount:"), gbc);
        gbc.gridx = 1;
        amountField = new JTextField("Yen 83,212,500", 20);
        add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Contract No:"), gbc);
        gbc.gridx = 1;
        contractField = new JTextField("028/YMH/I/16", 20);
        add(contractField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Goods Description:"), gbc);
        gbc.gridx = 1;
        goodsField = new JTextField("Yamaha Outboard Motor 40 AMS-R 40 HP", 20);
        add(goodsField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Shipment From:"), gbc);
        gbc.gridx = 1;
        shipmentField = new JTextField("Osaka, Japan", 20);
        add(shipmentField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Destination:"), gbc);
        gbc.gridx = 1;
        destinationField = new JTextField("Tg. Priok, Jakarta", 20);
        add(destinationField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        exportButton = new JButton("Ekspor ke PDF");
        add(exportButton, gbc);

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportToPDF();
            }
        });
    }

    public void exportToPDF() {
        // Implementasi ekspor ke PDF
        JOptionPane.showMessageDialog(this, "Dokumen L/C diekspor ke PDF");
    }
}