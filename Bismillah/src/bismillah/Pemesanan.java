/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Pemesanan.java
 *
 * Created on May 10, 2017, 8:20:41 PM
 */
package bissmillah;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.text.AttributeSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Zidan
 */
public class Pemesanan extends javax.swing.JFrame {
    public DefaultTableModel tabModel;
    Connection conn;   
    
    String host="localhost";
        String db="prese";  // perpus_NimAnda
        String user="root";
        String pass=""; 

    /** Creates new form Pemesanan */
    public Pemesanan() {
        initComponents();
        setJTable();
        
 
        txtJumlah.setDocument(new JTextFieldFilter(JTextFieldFilter.numeric)); 
        txtNama.setDocument(new JTextFieldFilter(JTextFieldFilter.huruf));
        txtAlamat.setDocument(new JTextFieldFilter(JTextFieldFilter.alamat));
        txtKontak.setDocument(new JTextFieldFilter(JTextFieldFilter.numeric));
        
        
        
        String sql;
    try {
      //  conn.close();
        Class.forName("com.mysql.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass);
        sql ="Select * from tiket";
        PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs =st.executeQuery();
        
        cbKelas.removeAllItems();
        cbKelas.addItem("Pilih Jenis Tiket");
        while (rs.next()) {
          String kode = rs.getString("Jenis");
          cbKelas.addItem(kode);
          txtHarga.setText("");
          txtJumlah.setText("");
        }

      }
      catch (ClassNotFoundException se) {}  // Silahkan tambahkan sendiri informasi eksepsi
      catch (SQLException se) {} 
    } 
    void filterangka(KeyEvent b){
        if(Character.isDigit(b.getKeyChar())){
            b.consume();
            JOptionPane.showMessageDialog(null,"Hanya Bisa Memasukan Karakter Huruf");
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtKodeTiket = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtKontak = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbKelas = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        txtTotalBayar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TPesan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        bKeluar = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bTambah = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        sad = new javax.swing.JComboBox();
        txtP = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();
        bRefresh = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtCari1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(-4144960,true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtKodeTiket.setEnabled(false);
        txtKodeTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeTiketActionPerformed(evt);
            }
        });
        jPanel1.add(txtKodeTiket, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 11, 70, -1));

        txtNama.setEnabled(false);
        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaKeyTyped(evt);
            }
        });
        jPanel1.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 228, -1));

        txtHarga.setEnabled(false);
        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });
        jPanel1.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 230, -1));

        txtAlamat.setEnabled(false);
        jPanel1.add(txtAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 228, -1));

        txtKontak.setEnabled(false);
        txtKontak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKontakActionPerformed(evt);
            }
        });
        txtKontak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKontakKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKontakKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKontakKeyTyped(evt);
            }
        });
        jPanel1.add(txtKontak, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 230, -1));

        jLabel6.setText("Kode Tiket");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel1.setText("Nama");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setText("Alamat");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel4.setText("Kelas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabel5.setText("Harga");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        cbKelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Biasa ", "Gaul", "Gaul Pisan" }));
        cbKelas.setEnabled(false);
        cbKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKelasActionPerformed(evt);
            }
        });
        jPanel1.add(cbKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 110, -1));

        jLabel7.setText("Jumlah Memesan");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 100, -1));

        jLabel8.setText("Total Bayar");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        txtJumlah.setEnabled(false);
        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });
        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahKeyTyped(evt);
            }
        });
        jPanel1.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 100, -1));

        txtTotalBayar.setEnabled(false);
        txtTotalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalBayarActionPerformed(evt);
            }
        });
        jPanel1.add(txtTotalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 230, -1));

        jLabel3.setText("No Telefon");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 760, 150));

        TPesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TPesan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 570, 100));

        jPanel2.setBackground(new java.awt.Color(-4144960,true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bKeluar.setText("Keluar");
        bKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKeluarActionPerformed(evt);
            }
        });
        jPanel2.add(bKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 90, -1));

        bBatal.setText("Batal");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });
        jPanel2.add(bBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 100, -1));

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });
        jPanel2.add(bHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 100, -1));

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });
        jPanel2.add(bEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 100, -1));

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(bSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 90, -1));

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });
        jPanel2.add(bTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 760, 40));

        jLabel9.setText("Cari Berdasarkan");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        sad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode_Tiket", "Nama" }));
        sad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sadActionPerformed(evt);
            }
        });
        getContentPane().add(sad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, -1, -1));
        getContentPane().add(txtP, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 130, -1));

        bCari.setText("Cari");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });
        getContentPane().add(bCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 60, -1));

        bRefresh.setText("Refresh");
        bRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(bRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 80, -1));

        jLabel10.setText("Tanggal Pemesanan");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, 20));

        txtTanggal.setEnabled(false);
        getContentPane().add(txtTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 130, -1));

        jButton1.setText("Cetak Kwitansi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 120, 20));

        txtCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCari1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtCari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 130, -1));

        jPanel3.setBackground(new java.awt.Color(-12566464,true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Serif", 0, 24));
        jLabel11.setForeground(new java.awt.Color(-1,true));
        jLabel11.setText("PEMESANAN");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 2, -1, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 60));
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 330, 50));

        jPanel5.setBackground(new java.awt.Color(-12566464,true));
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 780, 20));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-776)/2, (screenSize.height-478)/2, 776, 478);
    }// </editor-fold>//GEN-END:initComponents

private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
// TODO add your handling code here:
    Date tgl_sekarang= new Date();
    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
    String T=format.format(tgl_sekarang);
    txtTanggal.setText(T);
    
    idoto();
    
    txtKodeTiket.setEnabled(false);
    txtNama.setEnabled(true);
    txtAlamat.setEnabled(true);
    txtKontak.setEnabled(true);
    cbKelas.setEnabled(true);
    txtHarga.setEnabled(false);
    txtJumlah.setEnabled(true);
    txtTotalBayar.setEnabled(false);
    
    bSimpan.setText("Simpan");
    
    bTambah.setEnabled(true);
    bSimpan.setEnabled(true);
    bEdit.setEnabled(true);
    bBatal.setEnabled(true);
    bHapus.setEnabled(true);
    bKeluar.setEnabled(true);
}//GEN-LAST:event_bTambahActionPerformed

private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
// TODO add your handling code here:
    
    if(bSimpan.getText().equalsIgnoreCase("Simpan"))
            
           penguranganstok();
        else
            rubahData();
    
        
        txtKodeTiket.setText(""); // txtNoAnggota Tidak Aktif
        txtNama.setText("");        
        txtAlamat.setText("");
        txtKontak.setText("");
        cbKelas.setSelectedItem("");
        txtHarga.setText("");
        txtJumlah.setText("");
        txtTotalBayar.setText("");
        
        txtKodeTiket.setEnabled(false); // txtNoAnggota Tidak Aktif
        txtNama.setEnabled(true);       // txtNama Aktif
        txtAlamat.setEnabled(true);     // txtAlamat Aktif
        txtKontak.setEnabled(true);       // txtNama Aktif
        cbKelas.setEnabled(true);       // txtNama Aktif
        txtHarga.setEnabled(true);       // txtNama Aktif
        txtJumlah.setEnabled(true);
        txtTotalBayar.setEnabled(true); 
        
        bTambah.setEnabled(true);
        bSimpan.setEnabled(true);
        bEdit.setEnabled(true);
        bBatal.setEnabled(true);
        bHapus.setEnabled(true);
        bKeluar.setEnabled(true);   
                                       
}//GEN-LAST:event_bSimpanActionPerformed

private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
// TODO add your handling code here:
     txtKodeTiket.setEnabled(false); // txtNoAnggota Tidak Aktif
        txtNama.setEnabled(true);       // txtNama Aktif
        txtAlamat.setEnabled(true);     // txtAlamat Aktif
        txtKontak.setEnabled(true);       // txtNama Aktif
        cbKelas.setEnabled(true);       // txtNama Aktif
        txtHarga.setEnabled(true);       // txtNama Aktif
        txtJumlah.setEnabled(true);
        txtTotalBayar.setEnabled(true); 

        bSimpan.setText("Update"); // Merubah Teks Tombol Simpan
        
        bTambah.setEnabled(true);
        bSimpan.setEnabled(true);
        bEdit.setEnabled(true);
        bBatal.setEnabled(true);
        bHapus.setEnabled(true);
        bKeluar.setEnabled(true);  

        // Memanggil Method  ambilData_dari_JTable()
        ambilData_dari_JTable();
                                         
}//GEN-LAST:event_bEditActionPerformed

private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
// TODO add your handling code here:
    hapus_Data();
}//GEN-LAST:event_bHapusActionPerformed

private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
// TODO add your handling code here:
    txtKodeTiket.setText(""); // txtNoAnggota Tidak Aktif
        txtNama.setText("");        // txtNama          Aktif
        txtAlamat.setText("");
        txtKontak.setText("");
        cbKelas.setSelectedItem("");
        txtHarga.setText("");
        txtJumlah.setText("");
        txtTotalBayar.setText("");
        txtTanggal.setText("");

       // Mengatur  Enable Tombol Dan Textfield  
        txtKodeTiket.setEnabled(false);
        txtNama.setEnabled(false);
        txtAlamat.setEnabled(false);
        txtKontak.setEnabled(false);
        cbKelas.setEnabled(false);
        txtHarga.setEnabled(false);
        txtJumlah.setEnabled(false);
        txtTotalBayar.setEnabled(false);
        txtTanggal.setEnabled(false);
        

        bTambah.setEnabled(true);
        bSimpan.setEnabled(true);
        bEdit.setEnabled(true);
        bBatal.setEnabled(true);
        bHapus.setEnabled(true);
        bKeluar.setEnabled(true);
                                         

}//GEN-LAST:event_bBatalActionPerformed

private void bKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKeluarActionPerformed
// TODO add your handling code here:
                  dispose();
}//GEN-LAST:event_bKeluarActionPerformed

private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
// TODO add your handling code here: 
     String sql;
        int pilih = sad.getSelectedIndex();
        String cari = txtCari1.getText();
    try {
        conn.close();
         Class.forName("com.mysql.jdbc.Driver");
        conn  = (Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass); 
        if(pilih==0)
        sql ="Select * from pemesanan WHERE Kode_Tiket ='" +txtCari1.getText() + "'";
        else
        sql ="Select * from pemesanan WHERE Nama Like '%" +txtCari1.getText() + "%'";

        PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs =st.executeQuery();

        hapusIsiJTable();
        int no=0;
        while (rs.next()) {
            no++;
             String Kode_Tiket = rs.getString("Kode_Tiket");
             String Nama = rs.getString("Nama");
             String Alamat = rs.getString("Alamat");
             String Kontak = rs.getString("Kontak");
             String Kelas = rs.getString("Jenis");
             String Harga = rs.getString("Harga");
             String Jumlah = rs.getString("Jumlah");
             String TotalBayar = rs.getString("TotalBayar");
             String Tanggal = rs.getString("Tanggal");
             Object [] data = {no,Kode_Tiket, Nama, Alamat, Kontak, Kelas, Harga, Jumlah, TotalBayar, Tanggal};
             tabModel.addRow(data);
        }

         if(tabModel.getRowCount()>0)         
           JOptionPane.showMessageDialog(this,"Ditemukan ");        
        else
            JOptionPane.showMessageDialog(this,"Tidak Ditemukan.. ");

      }
      catch (ClassNotFoundException se) {}  // Silahkan tambahkan sendiri informasi eksepsi
      catch (SQLException se) {}                                      
}//GEN-LAST:event_bCariActionPerformed

private void bRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshActionPerformed
// TODO add your handling code here:
    String sql;
        try {
            conn.close();
            Class.forName("com.mysql.jdbc.Driver");
        conn  =(Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass); 

            sql ="Select * from pemesanan";

            PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs =st.executeQuery();

            hapusIsiJTable();
            int no=0;
            while (rs.next()) {
                no++;
              String Kode_Tiket = rs.getString("Kode_Tiket");
             String Nama = rs.getString("Nama");
             String Alamat = rs.getString("Alamat");
             String Kontak = rs.getString("Kontak");
             String Kelas = rs.getString("Jenis");
             String Harga = rs.getString("Harga");
             String Jumlah = rs.getString("Jumlah");
             String TotalBayar = rs.getString("TotalBayar");
             String Tanggal = rs.getString("Tanggal");
             Object [] data = {no,Kode_Tiket, Nama, Alamat, Kontak, Kelas, Harga, Jumlah, TotalBayar, Tanggal};
             tabModel.addRow(data);
            }

            if(tabModel.getRowCount()>0)
            JOptionPane.showMessageDialog(this," Berhasil refresh ");
            else
            JOptionPane.showMessageDialog(this," Gagal ");

        }
        catch (ClassNotFoundException se) {}  // Silahkan tambahkan send
        catch (SQLException se) {}
   
}//GEN-LAST:event_bRefreshActionPerformed

private void cbKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKelasActionPerformed
// TODO add your handling code here:
   String sql;
     try{
        Class.forName("com.mysql.jdbc.Driver");
        conn  =(Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass);
            sql="select * from tiket where Jenis='" + cbKelas.getSelectedItem() + "'";
            PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            
            while (rs.next()){
                String harga = rs.getString("Harga");
                txtHarga.setText(harga);
            }
     }
      catch (ClassNotFoundException se) {}
     catch (SQLException se){}
}//GEN-LAST:event_cbKelasActionPerformed

private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
  
         
}//GEN-LAST:event_txtJumlahActionPerformed

private void txtJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyReleased
// TODO add your handling code here:
       String input = txtJumlah.getText();
if (input.matches("[0-9]*")) {
    bSimpan.setEnabled(true);
} else {
     bSimpan.setEnabled(false);
       }
    int firstNo = Integer.parseInt(txtHarga.getText());
         int secNo = Integer.parseInt(txtJumlah.getText());
         
         int resultValue = firstNo * secNo;
         
         txtTotalBayar.setText(String.valueOf(resultValue));
    
}//GEN-LAST:event_txtJumlahKeyReleased

private void txtKontakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKontakActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtKontakActionPerformed

private void txtKontakKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKontakKeyReleased
// TODO add your handling code here:
      //       bSimpan.setEnabled(true);
   //    } catch(NumberFormatException e) {
   //        bSimpan.setEnabled(false);
  //     }    
  // String input = txtKontak.getText();
//if (input.matches("[0-9]*")) {
  //  bSimpan.setEnabled(true);
//} else {
  //   bSimpan.setEnabled(false);
    //   }
     String input = txtKontak.getText();
if (input.matches("[0-9]*")) {
    bSimpan.setEnabled(true);
} else {
     bSimpan.setEnabled(false);
       }
  
}//GEN-LAST:event_txtKontakKeyReleased

private void txtTotalBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalBayarActionPerformed
// TODO add your handling code here:
    int firstNo = Integer.parseInt(txtHarga.getText());
         int secNo = Integer.parseInt(txtJumlah.getText());
         
         int resultValue = firstNo * secNo;
         
         txtTotalBayar.setText(String.valueOf(resultValue));
}//GEN-LAST:event_txtTotalBayarActionPerformed

private void txtKodeTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeTiketActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtKodeTiketActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    cetuk();
}//GEN-LAST:event_jButton1ActionPerformed

private void txtKontakKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKontakKeyPressed
// TODO add your handling code here:
    
}//GEN-LAST:event_txtKontakKeyPressed

private void txtNamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyTyped
// TODO add your handling code here:
   filterangka(evt);
}//GEN-LAST:event_txtNamaKeyTyped

private void txtKontakKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKontakKeyTyped
// TODO add your handling code here:
    
}//GEN-LAST:event_txtKontakKeyTyped

private void txtJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyTyped
// TODO add your handling code here:
    
    
}//GEN-LAST:event_txtJumlahKeyTyped

private void txtNamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyReleased
// TODO add your handling code here:
    
}//GEN-LAST:event_txtNamaKeyReleased

private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtHargaActionPerformed

private void sadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sadActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_sadActionPerformed

private void txtCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCari1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtCari1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Pemesanan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TPesan;
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bKeluar;
    private javax.swing.JButton bRefresh;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bTambah;
    private javax.swing.JComboBox cbKelas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox sad;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtCari1;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKodeTiket;
    private javax.swing.JTextField txtKontak;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtP;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTotalBayar;
    // End of variables declaration//GEN-END:variables
class JTextFieldFilter extends PlainDocument { 

    public static final String numeric = "0123456789"; 
    public static final String huruf = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXXYZ"; 
    public static final String alamat = " 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXXYZ.-()"; 
    protected String acceptedChars = null; 
    protected boolean negativeAccepted = false; 

    public JTextFieldFilter(String acceptedchars) { 
    acceptedChars = acceptedchars; 
    } 

    public void setNegativeAccepted(boolean negativeaccepted) { 
    if (acceptedChars.equals(numeric) || (acceptedChars.equals(huruf))){ 
    negativeAccepted = negativeaccepted; 
    acceptedChars += "-"; 
    } 

    } 

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException { 
    if (str == null) 
    return; 

    for (int i = 0; i < str.length(); i++) { 
    if (acceptedChars.indexOf(String.valueOf(str.charAt(i))) == -1) 
    return; 
    } 

    if (negativeAccepted && str.indexOf("-") != -1) { 
    if (str.indexOf("-") != 0 || offset != 0) { 
    return; 
    } 
    } 

    super.insertString(offset, str, attr); 
    } 
    }
    
    private void getData(){   // import java.sql.connection
  try{
         Class.forName("com.mysql.jdbc.Driver");
        conn  =(Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass); 
        //Membuat Variabel bertipe kelas  PreparedStatement
        //Kelas PreparedStatement berfungsi mengirimkan statement Query Ke Database
        String sql="Select * from pemesanan";
        PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);  // import java.sql.PreparedStatement
        //Membuat Variabel Bertipe ResulSet
        //Kelas Resultset Berfungsi Menyimpan Dataset(Sekumpulan Data) hasil prepareStatement Query
        ResultSet rs=st.executeQuery();   // import java.sql.ResultSet;

       // Menampilkan ke JTable  melalui tabModel
        String Kode_Tiket,Nama,Alamat,Kontak,Jenis,Harga,Jumlah,TotalBayar,Tanggal;
        int no=0;
        while(rs.next()){
         no=no+1;
         Kode_Tiket=rs.getString("Kode_Tiket");
         Nama=rs.getString("Nama");
         Alamat=rs.getString("Alamat");
         Kontak=rs.getString("Kontak");
         Jenis=rs.getString("Jenis");
         Harga=rs.getString("Harga");
         Jumlah=rs.getString("Jumlah");
         TotalBayar=rs.getString("TotalBayar");
         Tanggal=rs.getString("Tanggal");

         Object Data[]={no,Kode_Tiket,Nama,Alamat,Kontak,Jenis,Harga,Jumlah,TotalBayar,Tanggal};
         tabModel.addRow(Data);
        }
          // Tutup Koneksi
          st.close();
          conn.close();
    }
    catch (ClassNotFoundException cnfe) {         // Ketika Gagal Memanggil Driver
           System.out.println("Class Driver tidak ditemukan.. : " + cnfe);
           System.exit(0);
    }
    catch (SQLException sqle) {                   // Ketika Gagal Sql   // import java.sql.SQLException
           System.out.println("Proses Query Gagal = " + sqle);
           System.exit(0);
    }
    catch(Exception e){
           System.out.println("Koneksi Access Gagal " +e.getMessage());
           System.exit(0);
    }

    }// Akhir Method getData
    
    public void idoto() {
        String sql;
     try{
        Class.forName("com.mysql.jdbc.Driver");
        conn  =(Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass); 
        //Membuat Variabel bertipe kelas  PreparedStatement
        //Kelas PreparedStatement berfungsi mengirimkan statement Query Ke Database
        sql = "SELECT * FROM pemesanan ORDER BY Kode_Tiket DESC";
        PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);  // import java.sql.PreparedStatement
        //Membuat Variabel Bertipe ResulSet
        //Kelas Resultset Berfungsi Menyimpan Dataset(Sekumpulan Data) hasil prepareStatement Query
        ResultSet rs=st.executeQuery();   // import java.sql.ResultSet;
            
            if (rs.next()) {
                String KodeTiket = rs.getString("Kode_Tiket").substring(1);
                String AN = "" + (Integer.parseInt(KodeTiket) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "00";}
                else if(AN.length()==2)
                {Nol = "0";}
                else if(AN.length()==3)
                {Nol = "";}
                txtKodeTiket.setText("A" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                txtKodeTiket.setText("A001");//sesuaikan dengan variable namenya
            }
            rs.close();
        } catch (Exception e) {
        }
    }
private void setJTable(){
    String [] JudulKolom={"No","Kode Tiket","Nama","Alamat","Kontak","Jenis","Harga","Jumlah Memesan","Total Bayar","Tanggal"};
    tabModel = new DefaultTableModel(null, JudulKolom){
                  boolean[] canEdit = new boolean [] { false, false, false, false, false, false, false, false, false};
                  @Override
                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                   return canEdit [columnIndex];
                  }
              };
    TPesan.setModel(tabModel);
    TPesan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    TPesan.getColumnModel().getColumn(0).setPreferredWidth(30);
    TPesan.getColumnModel().getColumn(1).setPreferredWidth(100);
    TPesan.getColumnModel().getColumn(2).setPreferredWidth(160);
    TPesan.getColumnModel().getColumn(3).setPreferredWidth(300);
    TPesan.getColumnModel().getColumn(4).setPreferredWidth(250);
    TPesan.getColumnModel().getColumn(5).setPreferredWidth(100);
    TPesan.getColumnModel().getColumn(6).setPreferredWidth(100);
    TPesan.getColumnModel().getColumn(7).setPreferredWidth(100);
    TPesan.getColumnModel().getColumn(8).setPreferredWidth(100);
    TPesan.getColumnModel().getColumn(9).setPreferredWidth(100);
    
    

    getData();
}// Akhir Method setJTable
public void simpanData(){
//Connection conn;
     try{
            Class.forName("com.mysql.jdbc.Driver");
        conn  =(Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass);
            String sql="Insert into pemesanan values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
           //valdas
            
                st.setString(1, txtKodeTiket.getText());
                st.setString(2, txtNama.getText());
                st.setString(3, txtAlamat.getText());
                st.setString(4, txtKontak.getText());
                st.setObject(5, cbKelas.getSelectedItem());
                st.setString(6, txtHarga.getText());
                st.setString(7, txtJumlah.getText());
                st.setString(8, txtTotalBayar.getText());
                st.setString(9, txtTanggal.getText());
            int rs=st.executeUpdate();

            if(rs>0){
            JOptionPane.showMessageDialog(this,"Berhasil");
      	    tampilDataKeJTable();
            }
            st.close();
            conn.close();
        }
        catch (ClassNotFoundException cnfe) {
           System.out.println("Class Driver tidak ditemukan.. : " + cnfe);
        }
        catch (SQLException sqle) {
           System.out.println("Input  Gagal = " + sqle.getMessage());
        }
        catch(Exception e){
           System.out.println("Gagal " +e.getMessage());
        }
  }
    public void rubahData() {
    // Konfirmasi sebelum melakukan perubahan data
    int ok = JOptionPane.showConfirmDialog(this,
        "Anda Yakin Ingin Mengubah Data\n Dengan No Resi = '" + txtKodeTiket.getText() +
        "'", "Konfirmasi ",JOptionPane.YES_NO_OPTION);
    // Apabila tombol Yes ditekan
    if (ok == 0) {
      try {
        Class.forName("com.mysql.jdbc.Driver");
        conn  =(Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass);
        String sql ="UPDATE pemesanan SET Nama = ?, Alamat= ?, Kontak= ?, Jenis= ?, Harga= ?, Jumlah= ?, TotalBayar= ?, Tanggal= ? WHERE Kode_Tiket = ?";
        PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
        try {
          st.setString(1, txtNama.getText());
          st.setString(2, txtAlamat.getText());
          st.setString(3, txtKontak.getText());
          st.setString(4, (String) cbKelas.getSelectedItem());
          st.setString(5, txtHarga.getText());
          st.setString(6, txtJumlah.getText());
          st.setString(7, txtTotalBayar.getText());
          st.setString(8, txtTanggal.getText());
          st.setString(9, txtKodeTiket.getText());
          
          
          st.executeUpdate();

         // Memanggil Method   tampilDataKeJTable();
          tampilDataKeJTable();

          txtKodeTiket.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtKontak.setText("");
        cbKelas.setSelectedItem("");
        txtHarga.setText("");
        txtJumlah.setText("");
        txtTotalBayar.setText("");
        txtTanggal.setText("");
          
          
        } catch (SQLException se) { }     // Silahkan tambahkan Sendiri informasi Eksepsi
      } catch (ClassNotFoundException se) {} // Silahkan tambahkan Sendiri informasi Eksepsi
      catch (SQLException se) {}  // Silahkan tambahkan Sendiri informasi Eksepsi
    }
    }
  
public void tampilDataKeJTable() {
    hapusIsiJTable();
    try {
        conn.close();
        Class.forName("com.mysql.jdbc.Driver");
        conn  =(Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass);  
        String sql="Select * from pemesanan";
        PreparedStatement st=(PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        String Kode_Tiket,Nama,Alamat,Kontak,Kelas,Harga,Jumlah,TotalBayar,Tanggal;
        int no=0;
        while(rs.next()){
         no=no+1;
         Kode_Tiket=rs.getString("Kode_Tiket");
         Nama=rs.getString("Nama");
         Alamat=rs.getString("Alamat");
         Kontak=rs.getString("Kontak");
         Kelas=rs.getString("Jenis");
         Harga=rs.getString("Harga");
         Jumlah=rs.getString("Jumlah");
         TotalBayar=rs.getString("TotalBayar");
         Tanggal=rs.getString("Tanggal");
         Object Data[]={no,Kode_Tiket,Nama,Alamat,Kontak,Kelas,Harga,Jumlah,TotalBayar,Tanggal};
         tabModel.addRow(Data);
      }
  }
    catch (Exception e) {}
}
public void hapusIsiJTable() {
    int row = tabModel.getRowCount();
    for (int i = 0; i < row; i++) {
      tabModel.removeRow(0);
    }
  }
void ambilData_dari_JTable() {
    int row = TPesan.getSelectedRow();

    // Mengambil data yang dipilih pada JTable
    String Kode_Tiket = tabModel.getValueAt(row, 1).toString();
    String Nama = tabModel.getValueAt(row, 2).toString();
    String Alamat = tabModel.getValueAt(row, 3).toString();
    String Kontak = tabModel.getValueAt(row, 4).toString();
    String Jenis = tabModel.getValueAt(row, 5).toString();
    String Harga = tabModel.getValueAt(row, 6).toString();
    String Jumlah = tabModel.getValueAt(row, 7).toString();
    String TotalBayar = tabModel.getValueAt(row, 8).toString();
    String Tanggal = tabModel.getValueAt(row, 9).toString();
    
    txtKodeTiket.setText(Kode_Tiket);
    txtNama.setText(Nama);
    txtAlamat.setText(Alamat);
    txtKontak.setText(Kontak);
    cbKelas.setSelectedItem(Jenis);
    txtHarga.setText(Harga);
    txtJumlah.setText(Jumlah);
    txtTotalBayar.setText(TotalBayar);
    txtTanggal.setText(Tanggal);
  }
public void hapus_Data() {
    // Konfirmasi sebelum melakukan penghapusan data
    ambilData_dari_JTable();
    int ok = JOptionPane.showConfirmDialog(this,
        "Anda Yakin Ingin Menghapus Data\nDengan Kode Tiket = '" + txtKodeTiket.getText() +
        "'", "Konfirmasi Menghapus Data",JOptionPane.YES_NO_OPTION);
    if (ok == 0) {     // Apabila tombol OK ditekan
      try {
       Class.forName("com.mysql.jdbc.Driver");
        conn  =(Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass);  
        String sql = "DELETE FROM pemesanan WHERE Kode_Tiket = ?";
        PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
        st.setString(1, txtKodeTiket.getText());
        int rs=st.executeUpdate();
        if(rs>0){
        tampilDataKeJTable();
        JOptionPane.showMessageDialog(this,"Sudah dihapus");
        }
        txtKodeTiket.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtKontak.setText("");
        cbKelas.setSelectedItem("");
        txtHarga.setText("");
        txtJumlah.setText("");
        txtTotalBayar.setText("");
        txtTanggal.setText("");
      } catch (Exception se) {  // Silahkan tambahkan catch Exception yang lain
         JOptionPane.showMessageDialog(this,"Gagal Hapus Data.. ");
       }
    }
  }
    public void penguranganstok(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass); 
            
        //ini ngambil stocknya, terus dikurangin sama banyaknya pembelian
        int dikurang = 0;
        String sto="select*from tiket where Jenis='" + cbKelas.getSelectedItem() + "'";
        PreparedStatement sr = (PreparedStatement) conn.prepareStatement(sto);
        ResultSet rz =sr.executeQuery();
        while (rz.next()) {
            int stock = Integer.valueOf(rz.getString("stock"));
            int jumlah = Integer.valueOf(txtJumlah.getText()); 
            dikurang = stock - jumlah;
        }
        conn.close();
        Class.forName("com.mysql.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass); 
        
        //stock barang diupdate
        String di_kurang = Integer.toString(dikurang);
        if(dikurang<0){
        JOptionPane.showMessageDialog(this,"stock kurang");
        }else{
            String ba="update tiket set stock=? where Jenis='" + cbKelas.getSelectedItem() + "'";
        PreparedStatement be = (PreparedStatement) conn.prepareStatement(ba);
        try {
            be.setString(1, di_kurang);
            be.executeUpdate();
        } catch (SQLException se) { }
        
        be.close();
        conn.close();
        Class.forName("com.mysql.jdbc.Driver");
        conn =  (Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass); 
        
        simpanData();
        }
        //masukin ke table transaksi
        }catch (ClassNotFoundException cnfe) {
           System.out.println("Class Driver tidak ditemukan.. : " + cnfe);
        }
        catch (SQLException sqle) {
           System.out.println("Input  Gagal = " + sqle.getMessage());
        }
        catch(Exception e){
           System.out.println("Gagal Tuh..  " +e.getMessage());
        }
    }
    void cetuk(){
    JasperReport jasRep;
     JasperPrint jasPri;
     Map<String, Object> no = new HashMap<String, Object>();
     JasperDesign jasDes;
     
     try{
      Class.forName("com.mysql.jdbc.Driver");
        conn  =(Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass);
         
         File report = new File("Laporan/Laporan.jrxml");
         jasDes = JRXmlLoader.load(report);
         no.clear();
         HashMap hashMap = new HashMap();
         hashMap.put("param", txtP.getText());
         jasRep = JasperCompileManager.compileReport(jasDes);
         jasPri = JasperFillManager.fillReport(jasRep, hashMap, conn);
         JasperViewer.viewReport(jasPri, false);
         
     }catch (Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
    }
         void valdas(){
             if(txtKodeTiket.getText().isEmpty() || txtNama.getText().isEmpty() || txtAlamat.getText().isEmpty() || txtKontak.getText().isEmpty() || txtHarga.getText().isEmpty() || txtJumlah.getText().isEmpty() || txtTotalBayar.getText().isEmpty() || txtTanggal.getText().isEmpty()  ){
            JOptionPane.showMessageDialog(this,"Isi dengan benar");
           }else{
                simpanData();
         }
         }
}
