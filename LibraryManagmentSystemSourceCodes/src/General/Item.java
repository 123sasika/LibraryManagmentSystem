
package General;
//importing classes from libraries
import Customer_exception.BookNotFoundException;
import Customer_exception.DVDNotFoundException;
import Customer_exception.ItemNotBorrowException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Item {
     public String ID;
     public String Title;

    // Constructor of superclass
    public Item(String ID1, String Title1) {
        ID= ID1;
        Title=Title1;
    }
    public Item() {
        
    }
    // Superclass methods
    public String ID2() {
        return ID;
    }
    public String Title2(){
        return Title;
    }
    
    
    
    public void borrow(String selectedID,String Title,String borrowerName,String TBName) {       
        //checking borrowerName is empty
        if (borrowerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Borrower name cannot be empty.");
            return;
        }        
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
          
            //checking TBName value is equal to book
             if (TBName.equals("book")) {
                 
                //getting correspoding details from book table in DB
                PreparedStatement pst0=conn.prepareStatement("select*from book WHERE ID=?");
                pst0.setString(1,selectedID);
                ResultSet bookRs = pst0.executeQuery();  
                bookRs.next();
                String author = bookRs.getString("Author");
                String genre = bookRs.getString("Genre");
                String isbn = bookRs.getString("ISBN"); 
                 
                //inserting data to borrowbook table in DB
                PreparedStatement pst = conn.prepareStatement( "INSERT INTO borrowbook (ID, Title,Author,Genre,ISBN,BorrowerName) VALUES (?,?,?,?,?,?)");
                pst.setString(1,selectedID);
                pst.setString(2,Title);
                pst.setString(3,author);
                pst.setString(4,genre);
                pst.setString(5,isbn);
                pst.setString(6,borrowerName);
                int rows=pst.executeUpdate();
                
                 if (rows== 0) {
                //custom exception
                throw new ItemNotBorrowException("Book "+selectedID+" was not found");
            } else {
                JOptionPane.showMessageDialog(null, "Book borrowed successfully!");
            }
                 
                //delete corresponding row from book table in DB
                String query = "DELETE FROM book WHERE ID = ?";
                PreparedStatement pst1 = conn.prepareStatement(query);
                pst1.setString(1,selectedID);
                int rowsDeleted = pst1.executeUpdate();  //execute the above code
                if (rowsDeleted== 0) {
                    throw new BookNotFoundException("Book "+selectedID+" was not found");
                }
            } 
            else if (TBName.equals("DVD")) {
                
                //getting correspoding details from dvd table in DB
                PreparedStatement pst00=conn.prepareStatement("select*from dvd WHERE ID=?");
                pst00.setString(1,selectedID);
                ResultSet dvdRs = pst00.executeQuery();         
                dvdRs.next();
                String director = dvdRs.getString("Director");
                String duration = dvdRs.getString("Duration");
                          
                //inserting data to borrowdvd table in DB
                PreparedStatement pst = conn.prepareStatement( "INSERT INTO borrowdvd (ID, Title,Director,Duration,BorrowerName) VALUES (?,?,?,?,?)");
                pst.setString(1, selectedID);
                pst.setString(2, Title);
                pst.setString(3, director);
                pst.setString(4, duration);
                pst.setString(5, borrowerName);
                int rowsDeleted=pst.executeUpdate();
               
                if (rowsDeleted== 0) {
                //custom exception
                throw new ItemNotBorrowException("DVD "+selectedID+" was not found");
                } else {
                JOptionPane.showMessageDialog(null, "DVD borrowed successfully!");
                }
                
                //delete corresponding row from dvd table in DB
                String query = "DELETE FROM dvd WHERE ID = ?";
                PreparedStatement pst2 = conn.prepareStatement(query);
                pst2.setString(1,selectedID);
                int rowsDeleted1 = pst2.executeUpdate();
                //custom exception
                if (rowsDeleted1== 0) {
                    throw new DVDNotFoundException("DVD "+selectedID+" was not found");
                }
               
            }
            
            else {
                throw new IllegalArgumentException("Invalid table name");
            }
           conn.close();
           
        } 
        catch(ItemNotBorrowException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch(BookNotFoundException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch(DVDNotFoundException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to borrow Item.");
        }
 
        }

}





