import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SSBCPanel extends JPanel {
    private JTextField noSsbcField, tglSsbcField, penerimaField;
    private JTextField jumlahField, mataUangField, keteranganField;
    private JButton exportButton;

    public SSBCPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Judul
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("SURAT SETORAN BEA CUKAI (SSBC)"), gbc);

        // Form fields
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("No. SSBC:"), gbc);
        gbc.gridx = 1;
        noSsbcField = new JTextField("", 20);
        add(noSsbcField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Tanggal SSBC:"), gbc);
        gbc.gridx = 1;
        tglSsbcField = new JTextField("", 20);
        add(tglSsbcField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Penerima:"), gbc);
        gbc.gridx = 1;
        penerimaField = new JTextField("DJBC", 20);
        add(penerimaField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Jumlah:"), gbc);
        gbc.gridx = 1;
        jumlahField = new JTextField("", 20);
        add(jumlahField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Mata Uang:"), gbc);
        gbc.gridx = 1;
        mataUangField = new JTextField("IDR", 20);
        add(mataUangField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Keterangan:"), gbc);
        gbc.gridx = 1;
        keteranganField = new JTextField("Pembayaran Bea Masuk", 20);
        add(keteranganField, gbc);

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
        JOptionPane.showMessageDialog(this, "Dokumen SSBC diekspor ke PDF");
    }
}