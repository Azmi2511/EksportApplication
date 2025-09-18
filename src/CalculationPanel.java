import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CalculationPanel extends JPanel {
    private JTextField fobField, freightField, insuranceField;
    private JTextField bmField, ppnField, pphField;
    private JTextField totalField;
    private JButton calculateButton;

    public CalculationPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Judul
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("PERHITUNGAN BIAYA IMPOR"), gbc);

        // Input fields
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("Nilai FOB (Yen):"), gbc);
        gbc.gridx = 1;
        fobField = new JTextField("83212500", 15);
        add(fobField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Freight (Yen):"), gbc);
        gbc.gridx = 1;
        freightField = new JTextField("133500", 15);
        add(freightField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Asuransi (%):"), gbc);
        gbc.gridx = 1;
        insuranceField = new JTextField("0.45", 15);
        add(insuranceField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Bea Masuk (%):"), gbc);
        gbc.gridx = 1;
        bmField = new JTextField("5", 15);
        add(bmField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("PPN (%):"), gbc);
        gbc.gridx = 1;
        ppnField = new JTextField("10", 15);
        add(ppnField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("PPh Pasal 22 (%):"), gbc);
        gbc.gridx = 1;
        pphField = new JTextField("2.5", 15);
        add(pphField, gbc);

        // Tombol hitung
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        calculateButton = new JButton("Hitung");
        add(calculateButton, gbc);

        // Hasil
        gbc.gridy++;
        add(new JLabel("Total Biaya Impor (Rp):"), gbc);
        gbc.gridy++;
        totalField = new JTextField(15);
        totalField.setEditable(false);
        add(totalField, gbc);

        // Action listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateImportCosts();
            }
        });
    }

    private void calculateImportCosts() {
        try {
            double fob = Double.parseDouble(fobField.getText());
            double freight = Double.parseDouble(freightField.getText());
            double insuranceRate = Double.parseDouble(insuranceField.getText()) / 100;
            double bmRate = Double.parseDouble(bmField.getText()) / 100;
            double ppnRate = Double.parseDouble(ppnField.getText()) / 100;
            double pphRate = Double.parseDouble(pphField.getText()) / 100;

            // Kurs dari ketentuan
            double kurs = 6677.38; // NDPBM

            // Hitung CIF
            double insurance = fob * insuranceRate;
            double cif = fob + freight + insurance;

            // Hitung Bea Masuk
            double bm = cif * bmRate;

            // Hitung nilai impor
            double nilaiImpor = cif + bm;

            // Hitung PPN
            double ppn = nilaiImpor * ppnRate;

            // Hitung PPh
            double pph = nilaiImpor * pphRate;

            // Total dalam Yen
            double totalYen = cif + bm + ppn + pph;

            // Konversi ke Rupiah
            double totalRp = totalYen * kurs / 100; // Karena kurs adalah Rp per 100 Yen

            DecimalFormat df = new DecimalFormat("#,##0.00");
            totalField.setText(df.format(totalRp));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid");
        }
    }

    public void exportToPDF() {
        // Implementasi ekspor ke PDF
        JOptionPane.showMessageDialog(this, "Perhitungan diekspor ke PDF");
    }
}