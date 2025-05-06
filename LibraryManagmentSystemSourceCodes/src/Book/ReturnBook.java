
package Book;

//importing classes from libraries
import Customer_exception.BookNotAddException;
import Customer_exception.BookNotFoundException;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ReturnBook extends javax.swing.JFrame {

    DefaultTableModel tableModel;
      
    public ReturnBook() {
    initComponents();    
    tableModel = (DefaultTableModel) jTable1.getModel();
    loadData();
    combo();
    }
      
    public void loadData() {
       
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            tableModel.setRowCount(0);// Clear the existing rows in the table
            String bookQuery = "select ID,Title,BorrowerName from borrowbook";  // Query for books table
            PreparedStatement bookpst = conn.prepareStatement(bookQuery);
            ResultSet bookRs = bookpst.executeQuery();
           
            // Fetch book data and add to table model
            while (bookRs.next()) {
                String book_id = bookRs.getString("ID");
                String Title = bookRs.getString("Title");
                String borrowername = bookRs.getString("BorrowerName");
                
                // Add book row (with DVD-related columns empty)
                tableModel.addRow(new Object[]{book_id, Title, borrowername, null});
            }
            conn.close();
        } 
        catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Something Wrong"); 
        }
    }
    
    void combo(){
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            String details="SELECT ID FROM borrowbook";
            PreparedStatement detailspst = conn.prepareStatement(details);            
            ResultSet rs = detailspst.executeQuery();
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("ID"));
            }         
            conn.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 37, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Title");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 37, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Borrower Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 110, 50));

        jTextField1.setBackground(new java.awt.Color(255, 255, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 250, -1));

        jTextField2.setBackground(new java.awt.Color(255, 255, 204));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 250, -1));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 204));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 250, -1));

        jTable1.setBackground(new java.awt.Color(255, 255, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Title", "BorrowerName"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 600, 160));

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Delete Row");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Book/123456.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        setSize(new java.awt.Dimension(714, 457));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        String selectedBookId = (String) jComboBox1.getSelectedItem();

        if (selectedBookId == null || selectedBookId.isEmpty()) {
            return;
        }

        try {
              Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
              String query = "SELECT * FROM borrowbook WHERE ID = ?";
              PreparedStatement pst = conn.prepareStatement(query);
              pst.setString(1,selectedBookId);
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String id=(String)jComboBox1.getSelectedItem();
    String title=jTextField1.getText();
    String borrower=jTextField2.getText();

    try{  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");

        //select details from borrowbook table in DB
        PreparedStatement pstt=con.prepareStatement("select Author,Genre,ISBN from borrowbook WHERE ID=?");
        pstt.setString(1,id);
        ResultSet bookRss = pstt.executeQuery();  
        bookRss.next();
        String author = bookRss.getString("Author");
        String genre = bookRss.getString("Genre");
        String isbn = bookRss.getString("ISBN");
        
        //add details to book table in DB
        String query="insert into book values('"+id+"','"+title+"','"+author+"','"+genre+"','"+isbn+"')";
        PreparedStatement pst=con.prepareStatement(query);
        int Result=pst.executeUpdate();
        if(Result==0){
            throw new BookNotAddException("The book was not added");
        }
                
        //add to returnbook table in DB
        Statement st=con.createStatement();
        int Update=st.executeUpdate("insert into returnbook values('"+id+"','"+title+"','"+borrower+"')");
        //custom exception
        if (Update== 0) {
            throw new BookNotFoundException("Book was not found");
        }
        
        //delete corresponding row from borrowbook table in DB
        String query00 = "DELETE FROM borrowbook WHERE ID =?";
        PreparedStatement pst00 = con.prepareStatement(query00);
        pst00.setString(1,id);
        int rowsDeleted = pst00.executeUpdate();  //execute the above code
        if (rowsDeleted== 0) {
            throw new BookNotFoundException("Book "+id+" was not found");
        }else{
            JOptionPane.showMessageDialog(null, "Successfully Returned");
        }
        con.close();
        }
    
    catch(BookNotFoundException e){
            JOptionPane.showMessageDialog(null,e.getMessage());   
    }     
    catch(Exception e)
            {
            JOptionPane.showMessageDialog(null,"");
            }
                  
        loadData();
      
        new ReturnBook().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        new AdminBookHomePage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
         new ReturnBookDelete().setVisible(true);
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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
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
