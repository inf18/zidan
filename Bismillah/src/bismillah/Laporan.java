/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Laporan.java
 *
 * Created on May 18, 2017, 8:35:40 AM
 */
package bissmillah;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
public class Laporan extends javax.swing.JFrame {
     public DefaultTableModel tabModel;
    Connection conn;   
    
    String host="localhost";
        String db="prese";  // perpus_NimAnda
        String user="root";
        String pass=""; 

    /** Creates new form Laporan */
    public Laporan() {
        initComponents();
        setJTable();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtKK = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TPesan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Laporan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 100, -1));
        getContentPane().add(txtKK, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, 0));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 540, 100));

        jPanel1.setBackground(new java.awt.Color(-12566464,true));

        jLabel1.setFont(new java.awt.Font("Serif", 0, 18));
        jLabel1.setForeground(new java.awt.Color(-1,true));
        jLabel1.setText("LAPORAN");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 40));

        jButton2.setText("CLose");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 100, -1));

        jPanel2.setBackground(new java.awt.Color(-4144960,true));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 270));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-580)/2, (screenSize.height-273)/2, 580, 273);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    JasperReport jasRep;
     JasperPrint jasPri;
     Map<String, Object> no = new HashMap<String, Object>();
     JasperDesign jasDes;
     
     try{
      Class.forName("com.mysql.jdbc.Driver");
        conn  =(Connection) DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass);
         
         File report = new File("Laporan/Allahuakbar.jrxml");
         jasDes = JRXmlLoader.load(report);
         no.clear();
         HashMap hashMap = new HashMap();
         hashMap.put("pemesanan",txtKK.getText());
         jasRep = JasperCompileManager.compileReport(jasDes);
         jasPri = JasperFillManager.fillReport(jasRep, hashMap, conn);
         JasperViewer.viewReport(jasPri, false);
         
     }catch (Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         
     }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    dispose();
}//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TPesan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtKK;
    // End of variables declaration//GEN-END:variables
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
    
    
    
private void setJTable(){
    String [] JudulKolom={"No","Kode Tiket","Nama","Alamat","Kontak","Jenis","Harga","Jumlah Memesan","Total Bayar","Tanggal"};
    tabModel = new DefaultTableModel(null, JudulKolom){
                  boolean[] canEdit = new boolean [] { false, false, false, false, false, false, false, false, false};
                  
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
}

}
