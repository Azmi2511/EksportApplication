import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PIBPanel extends JPanel {
    private JTextField noPibField, tglPibField, apiField, npwpField;
    private JTextField invoiceField, blField, vesselField;
    private JTextField hsCodeField, bmField, ppnField, pphField;
    private JButton exportButton;

    public PIBPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Judul
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("PEMBERITAHUAN IMPOR BARANG (PIB)"), gbc);

        // Form fields
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("No. PIB:"), gbc);
        gbc.gridx = 1;
        noPibField = new JTextField("", 20);
        add(noPibField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Tanggal PIB:"), gbc);
        gbc.gridx = 1;
        tglPibField = new JTextField("", 20);
        add(tglPibField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("API:"), gbc);
        gbc.gridx = 1;
        apiField = new JTextField("4454/N/89", 20);
        add(apiField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("NPWP:"), gbc);
        gbc.gridx = 1;
        npwpField = new JTextField("255.210.11.434", 20);
        add(npwpField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Invoice No:"), gbc);
        gbc.gridx = 1;
        invoiceField = new JTextField("11120/YMH/16", 20);
        add(invoiceField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("B/L No:"), gbc);
        gbc.gridx = 1;
        blField = new JTextField("JKT.6006", 20);
        add(blField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Vessel:"), gbc);
        gbc.gridx = 1;
        vesselField = new JTextField("MS OBL Voyage 020", 20);
        add(vesselField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("HS Code:"), gbc);
        gbc.gridx = 1;
        hsCodeField = new JTextField("8407.21.900", 20);
        add(hsCodeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Bea Masuk:"), gbc);
        gbc.gridx = 1;
        bmField = new JTextField("5%", 20);
        add(bmField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("PPN:"), gbc);
        gbc.gridx = 1;
        ppnField = new JTextField("10%", 20);
        add(ppnField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("PPh Pasal 22:"), gbc);
        gbc.gridx = 1;
        pphField = new JTextField("2.5%", 20);
        add(pphField, gbc);

        // Tombol ekspor
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
        JOptionPane.showMessageDialog(this, "Dokumen PIB diekspor ke PDF");
    }
}