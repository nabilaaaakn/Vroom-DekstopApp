import Vroom_UAS.Mobil;
import Vroom_UAS.MobilManager;
import Vroom_UAS.MobilService;
import java.awt.Menu;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.sql.*;

public class TambahMobil extends javax.swing.JFrame {
    private void isiDataAwalMobil() {
    MobilManager mobilManager = MobilManager.getInstance();

    mobilManager.tambahMobil(new Mobil("001", "Toyota", "Avanza", 2020, "B 1234 CD", 250000, "Tersedia"));
    mobilManager.tambahMobil(new Mobil("002", "Honda", "Brio", 2021, "D 5678 EF", 300000, "Tersedia"));
    mobilManager.tambahMobil(new Mobil("003", "Suzuki", "Ertiga", 2019, "F 9999 GH", 270000, "Tersedia"));
    mobilManager.tambahMobil(new Mobil("004", "Daihatsu", "Xenia", 2020, "E 1122 IJ", 240000, "Tersedia"));
    mobilManager.tambahMobil(new Mobil("005", "Mitsubishi", "Xpander", 2022, "G 3344 KL", 320000, "Tersedia"));
    mobilManager.tambahMobil(new Mobil("006", "Wuling", "Confero", 2021, "H 5566 MN", 280000, "Tersedia"));
    mobilManager.tambahMobil(new Mobil("007", "Nissan", "Livina", 2020, "L 7788 OP", 290000, "Tersedia"));
    mobilManager.tambahMobil(new Mobil("008", "Kia", "Rio", 2023, "Z 9900 QR", 310000, "Tersedia"));
}
    
    private void tambahMobil() {
    try {
        String id = txtIdMobil.getText();
        String merek = txtMerekMobil.getText();
        String tipe = txtTipeMobil.getText();
        int tahun = Integer.parseInt(cbTahunProduksi.getSelectedItem().toString());
        String nopol = txtNomorPolisi.getText();
        double harga = Double.parseDouble(txtHargaSewa.getText());
        String status = cbStatus.getSelectedItem().toString();

        Mobil mobilBaru = new Mobil(id, merek, tipe, tahun, nopol, harga, status);
        MobilManager.getInstance().tambahMobil(mobilBaru);

        tampilkanDataKeTabel(); // Update tabel setelah tambah

        JOptionPane.showMessageDialog(this, "Mobil berhasil ditambahkan!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Data tidak valid atau kosong!");
    }
}

    private void tampilkanDataKeTabel() {
    DefaultTableModel model = (DefaultTableModel) tabelMobil.getModel();
    model.setRowCount(0); // Bersihkan tabel

    for (Mobil mobil : MobilManager.getInstance().getAllMobil()) {
        Object[] row = new Object[] {
            mobil.getId(),
            mobil.getMerek(),
            mobil.getTipe(),
            mobil.getTahun(),
            mobil.getNomorPolisi(),
            mobil.getHarga(),
            mobil.getStatus()
        };
        model.addRow(row);
    }
}

private final MobilService mobilService = MobilManager.getInstance();

     public TambahMobil() {
        initComponents();
        isiDataAwalMobil();       // ⬅️ ini HARUS DIPANGGIL LEBIH DULU!
        tampilkanDataKeTabel();   // baru isi ke tabel
        // loadTableData();       // ini bisa dihapus atau digabung ke atas
        
    btnMenuUtama.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        FormMenu menu = new FormMenu(); // buka halaman Menu utama
        menu.setVisible(true);
        dispose(); // tutup frame TambahMobil
    }
});
     }
     
     public void simpanMobilKeDatabase(Mobil mobil) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vroom", "root", "");

            String sql = "INSERT INTO mobil (merek, tipe, tahun, nomor_polisi, harga, status) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, mobil.getMerek());
            pstmt.setString(2, mobil.getTipe());
            pstmt.setInt(3, mobil.getTahun());
            pstmt.setString(4, mobil.getNomorPolisi());
            pstmt.setDouble(5, mobil.getHarga());
            pstmt.setString(6, mobil.getStatus());

            pstmt.executeUpdate();

            System.out.println("Data mobil berhasil ditambahkan ke database.");
        } catch (Exception e) {
            System.out.println("Error saat menyimpan mobil: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
 // Metode untuk memuat data dari MobilManager ke JTable
    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) tabelMobil.getModel();
        model.setRowCount(0); // Bersihkan tabel sebelum mengisi ulang

        List<Mobil> allMobil = mobilService.getAllMobil();
        for (Mobil mobil : allMobil) {
            model.addRow(new Object[]{
                mobil.getId(), mobil.getMerek(), mobil.getTipe(),
                mobil.getTahun(), mobil.getNomorPolisi(), mobil.getHarga(), mobil.getStatus()
            });
        }
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdMobil = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMerekMobil = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTipeMobil = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbTahunProduksi = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtNomorPolisi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHargaSewa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMobil = new javax.swing.JTable();
        Button1 = new javax.swing.JButton();
        btnMenuUtama = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(186, 152, 145));

        jLabel1.setFont(new java.awt.Font("Calisto MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 42, 76));
        jLabel1.setText("Form Tambah Mobil");

        jLabel2.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(23, 42, 76));
        jLabel2.setText("ID Mobil: * ");

        txtIdMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMobilActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(23, 42, 76));
        jLabel3.setText("Merek Mobil: *");

        txtMerekMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMerekMobilActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(23, 42, 76));
        jLabel4.setText("Tipe Mobil: *");

        txtTipeMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipeMobilActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(23, 42, 76));
        jLabel5.setText("Tahun Produksi: *");

        cbTahunProduksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", " " }));

        jLabel6.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(23, 42, 76));
        jLabel6.setText("Nomor Polisi: *");

        jLabel7.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(23, 42, 76));
        jLabel7.setText("Harga Sewa: *");

        txtHargaSewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaSewaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(23, 42, 76));
        jLabel8.setText("Status: *");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tersedia", "Sewa", "Perawatan", " " }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        tabelMobil.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        tabelMobil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Mobil", "Merek Mobil", "Tipe Mobil", "Tahun Produksi", "Nomor Polisi", "Harga Sewa", "Status"
            }
        ));
        jScrollPane1.setViewportView(tabelMobil);
        if (tabelMobil.getColumnModel().getColumnCount() > 0) {
            tabelMobil.getColumnModel().getColumn(0).setHeaderValue("ID Mobil");
            tabelMobil.getColumnModel().getColumn(1).setHeaderValue("Merek Mobil");
            tabelMobil.getColumnModel().getColumn(2).setHeaderValue("Tipe Mobil");
            tabelMobil.getColumnModel().getColumn(3).setHeaderValue("Tahun Produksi");
            tabelMobil.getColumnModel().getColumn(4).setHeaderValue("Nomor Polisi");
            tabelMobil.getColumnModel().getColumn(5).setHeaderValue("Harga Sewa");
            tabelMobil.getColumnModel().getColumn(6).setHeaderValue("Status");
        }

        Button1.setBackground(new java.awt.Color(23, 42, 76));
        Button1.setFont(new java.awt.Font("Calisto MT", 1, 12)); // NOI18N
        Button1.setForeground(new java.awt.Color(131, 147, 187));
        Button1.setText("Tambah");
        Button1.setActionCommand("");
        Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button1ActionPerformed(evt);
            }
        });

        btnMenuUtama.setBackground(new java.awt.Color(23, 42, 76));
        btnMenuUtama.setFont(new java.awt.Font("Calisto MT", 1, 12)); // NOI18N
        btnMenuUtama.setForeground(new java.awt.Color(131, 147, 187));
        btnMenuUtama.setActionCommand("");
        btnMenuUtama.setLabel("Kembali ke Menu Utama");
        btnMenuUtama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuUtamaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMerekMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipeMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(Button1)
                                        .addGap(53, 53, 53)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMenuUtama)
                                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHargaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomorPolisi, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTahunProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 407, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMerekMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTipeMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbTahunProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNomorPolisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtHargaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMobilActionPerformed

    private void txtMerekMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMerekMobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMerekMobilActionPerformed

    private void txtTipeMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipeMobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipeMobilActionPerformed

    private void txtHargaSewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaSewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaSewaActionPerformed

    private void Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button1ActionPerformed
                                        
    // Validasi input
        String id = txtIdMobil.getText().trim();
        String merek = txtMerekMobil.getText().trim();
        String tipe = txtTipeMobil.getText().trim();
        String nomorPolisi = txtNomorPolisi.getText().trim().toUpperCase();
        String polaNopol = "^[A-Z]{1,2} [0-9]{1,4} [A-Z]{1,3}$";

        if (!nomorPolisi.matches(polaNopol)) {
    JOptionPane.showMessageDialog(null, "Format nomor polisi tidak valid!\nContoh: B 1234 CD");
    return;
}        
        String status = cbStatus.getSelectedItem().toString();

        int tahun;
        double harga;
        
        try {
        tahun = Integer.parseInt(cbTahunProduksi.getSelectedItem().toString());
        harga = Double.parseDouble(txtHargaSewa.getText().trim());
        if (harga < 0) {
        JOptionPane.showMessageDialog(null, "Harga sewa tidak boleh negatif!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Tahun dan Harga harus berupa angka!", "Input Error", JOptionPane.WARNING_MESSAGE);
    return;
}
    // Validasi input kosong
if (txtIdMobil.getText().trim().isEmpty() ||
    txtMerekMobil.getText().trim().isEmpty() ||
    txtTipeMobil.getText().trim().isEmpty() ||
    txtNomorPolisi.getText().trim().isEmpty() ||
    txtHargaSewa.getText().trim().isEmpty()) {
    
    JOptionPane.showMessageDialog(null, "Semua field bertanda '*' harus diisi!", "Input Error", JOptionPane.WARNING_MESSAGE);
    return;
}

        // Cek ID duplikat (opsional, tergantung kebutuhan)
        for (Mobil m : mobilService.getAllMobil()) {
            if (m.getId().equalsIgnoreCase(id)) {
                JOptionPane.showMessageDialog(null, "ID Mobil sudah ada! Gunakan ID lain.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // Buat objek Mobil baru
        Mobil mobil = new Mobil(id, merek, tipe, tahun, nomorPolisi, harga, status);
        mobilService.tambahMobil(mobil);
        simpanMobilKeDatabase(mobil);

        // Tambahkan data ke tabel
        DefaultTableModel model = (DefaultTableModel) tabelMobil.getModel();
        model.addRow(new Object[]{
            mobil.getId(), mobil.getMerek(), mobil.getTipe(),
            mobil.getTahun(), mobil.getNomorPolisi(), mobil.getHarga(), mobil.getStatus()
        });


    bersihkanForm(); // Panggil method untuk membersihkan form
}
    private void bersihkanForm() {
    txtIdMobil.setText("");
    txtMerekMobil.setText("");
    txtTipeMobil.setText("");
    txtNomorPolisi.setText("");
    txtHargaSewa.setText("");
    cbTahunProduksi.setSelectedIndex(0);
    cbStatus.setSelectedIndex(0);
    }//GEN-LAST:event_Button1ActionPerformed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusActionPerformed

    private void btnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuUtamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuUtamaActionPerformed
                                       
public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        java.util.logging.Logger.getLogger(TambahMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(() -> {
        new TambahMobil().setVisible(true);
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button1;
    private javax.swing.JButton btnMenuUtama;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbTahunProduksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelMobil;
    private javax.swing.JTextField txtHargaSewa;
    private javax.swing.JTextField txtIdMobil;
    private javax.swing.JTextField txtMerekMobil;
    private javax.swing.JTextField txtNomorPolisi;
    private javax.swing.JTextField txtTipeMobil;
    // End of variables declaration//GEN-END:variables
}