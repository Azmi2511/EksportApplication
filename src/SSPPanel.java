import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SSPPanel extends JPanel {
    private JTextField noSspField, tglSspField, npwpField;
    private JTextField namaField, alamatField, masaPajakField;
    private JTextField jenisPajakField, jumlahField;
    private JButton exportButton;

    public SSPPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Judul
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("SURAT SETORAN PAJAK (SSP)"), gbc);

        // Form fields
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("No. SSP:"), gbc);
        gbc.gridx = 1;
        noSspField = new JTextField("", 20);
        add(noSspField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Tanggal SSP:"), gbc);
        gbc.gridx = 1;
        tglSspField = new JTextField("", 20);
        add(tglSspField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("NPWP:"), gbc);
        gbc.gridx = 1;
        npwpField = new JTextField("255.210.11.434", 20);
        add(npwpField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        namaField = new JTextField("PT AGUNG SEDAYU MANDIRI", 20);
        add(namaField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1;
        alamatField = new JTextField("Jl. Jend. Sudirman Kav. 45, Jakarta", 20);
        add(alamatField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Masa Pajak:"), gbc);
        gbc.gridx = 1;
        masaPajakField = new JTextField("Januari 2016", 20);
        add(masaPajakField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Jenis Pajak:"), gbc);
        gbc.gridx = 1;
        jenisPajakField = new JTextField("PPh Pasal 22 Impor", 20);
        add(jenisPajakField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Jumlah:"), gbc);
        gbc.gridx = 1;
        jumlahField = new JTextField("", 20);
        add(jumlahField, gbc);

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
        JOptionPane.showMessageDialog(this, "Dokumen SSP diekspor ke PDF");
    }
}