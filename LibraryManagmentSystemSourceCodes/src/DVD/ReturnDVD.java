package DVD;

//importing classes from libraries
import Customer_exception.BookNotFoundException;
import Customer_exception.DVDNotAddException;
import Customer_exception.DVDNotFoundException;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ReturnDVD extends javax.swing.JFrame {
   
    DefaultTableModel tableModel;
    
        public void loadData() {      
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            Statement st=conn.createStatement();
            tableModel.setRowCount(0);  // Clear the existing rows in the table
            String dvdQuery = "select ID,Title,BorrowerName from borrowdvd"; 
            PreparedStatement dvdStmt = conn.prepareStatement(dvdQuery);
            ResultSet dvdRs = dvdStmt.executeQuery();
            
            // Fetch book data and add to table model
            while (dvdRs.next()) {
                String dvd_id = dvdRs.getString("ID");
                String Title = dvdRs.getString("Title");
                String borrowername = dvdRs.getString("BorrowerName");                
                // Add book row (with DVD-related columns empty)
                tableModel.addRow(new Object[]{dvd_id, Title, borrowername, null});
            }
             loadData(); 
            conn.close();
        }
        catch (Exception e) {
           
        }
        }
        
        void combo(){
            try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM borrowdvd");
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("ID"));
            }
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        
        }
        }

    public ReturnDVD() {
        initComponents();
         // Set up table model for jTable1
        tableModel = (DefaultTableModel) jTable1.getModel();
        loadData();
        combo();                
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Return DVD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 120, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 37, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Title");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 37, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Borrower Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 204));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 240, -1));

        jTextField1.setBackground(new java.awt.Color(255, 255, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 240, -1));

        jTextField2.setBackground(new java.awt.Color(255, 255, 204));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 240, -1));

        jTable1.setBackground(new java.awt.Color(255, 255, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Title ", "Borrower Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 640, 160));

        jButton3.setBackground(new java.awt.Color(255, 255, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Delete Row");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpackage/123456.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        setSize(new java.awt.Dimension(714, 457));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
        String selectedDVDId = (String) jComboBox1.getSelectedItem();
        if (selectedDVDId== null || selectedDVDId.isEmpty()) {
            return;
        }
        try {
            String query = "SELECT * FROM borrowdvd WHERE ID = ?";
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");             
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, selectedDVDId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jTextField1.setText(rs.getString("Title"));
                jTextField2.setText(rs.getString("BorrowerName"));
            }          
            conn.close();            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String id=(String)jComboBox1.getSelectedItem();
        String title=jTextField1.getText();
        String borrower=jTextField2.getText();

       //updating the table of this page
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            
            //select details from borrowdvd table in DB
            PreparedStatement pst0=con.prepareStatement("select Director,Duration from borrowdvd WHERE ID=?");
            pst0.setString(1,id);
            ResultSet dvdRs = pst0.executeQuery();         
            if(dvdRs.next()) {
                String director = dvdRs.getString("Director");
                String duration = dvdRs.getString("Duration");
                
                //add details to dvd table in DB
                Statement st=con.createStatement();
                int rows=st.executeUpdate("insert into dvd values('"+id+"','"+title+"','"+director+"','"+duration+"')");
                if(rows==0){
                    throw new DVDNotAddException("The DVD was not added");
                }

                //add to returndvd table in DB
                Statement st1=con.createStatement();
                int rows1=st1.executeUpdate("insert into returndvd values('"+id+"','"+title+"','"+borrower+"')");
                if(rows1==0){
                    throw new DVDNotAddException("The DVD was not added");
                }
            
            
                //delete correspoding row from the borrowdvd table in DB
                String query = "DELETE FROM borrowdvd WHERE ID = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1,id);
                int rowsDeleted = pst.executeUpdate();  //execute the above code
                if (rowsDeleted>0) {
                    JOptionPane.showMessageDialog(null,"Successfully Returned");
                }            
            }
            con.close();
        }
        catch(Exception e)
                {
                JOptionPane.showMessageDialog(jButton1,"DVD ID already exist");
                }
        
        loadData();
        new ReturnDVD().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        new AdminDVDHomePage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        new ReturnDVDDelete().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnDVD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
