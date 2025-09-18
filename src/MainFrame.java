import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private LCPanel lcPanel;
    private PIBPanel pibPanel;
    private SSBCPanel ssbcPanel;
    private SSPPanel sspPanel;
    private CalculationPanel calculationPanel;

    public MainFrame() {
        setTitle("Sistem Pengisian Dokumen Impor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        // Inisialisasi komponen
        tabbedPane = new JTabbedPane();
        lcPanel = new LCPanel();
        pibPanel = new PIBPanel();
        ssbcPanel = new SSBCPanel();
        sspPanel = new SSPPanel();
        calculationPanel = new CalculationPanel();

        // Tambahkan tab
        tabbedPane.addTab("Perhitungan Impor", calculationPanel);
        tabbedPane.addTab("Permintaan L/C", lcPanel);
        tabbedPane.addTab("PIB", pibPanel);
        tabbedPane.addTab("SSBC", ssbcPanel);
        tabbedPane.addTab("SSP", sspPanel);

        // Panel untuk tombol ekspor
        JPanel buttonPanel = new JPanel();
        JButton exportButton = new JButton("Ekspor Semua ke PDF");
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportAllToPDF();
            }
        });
        buttonPanel.add(exportButton);

        // Layout
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void exportAllToPDF() {
        calculationPanel.exportToPDF();
        lcPanel.exportToPDF();
        pibPanel.exportToPDF();
        ssbcPanel.exportToPDF();
        sspPanel.exportToPDF();

        JOptionPane.showMessageDialog(this, "Semua dokumen berhasil diekspor ke PDF");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}