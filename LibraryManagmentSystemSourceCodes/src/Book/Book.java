
package Book;

import General.Item;

public class Book extends Item {
    
    //creating the constructor 
    Book(String ID, String Title, String Author1, String Genre1, String ISBN) {
        
        super(ID,Title);  //passing data to the super class constructor  
        //passing data to the variables of Book class
        Author=Author1;
        Genre=Genre1;
        this.ISBN=ISBN;
    }

    //creating variables
   public String Author;
   public String Genre;
   public String ISBN;

   
   //passing data to the AddBook class
    public String Author2(){
        return Author;
    }
    public String Genre2(){
        return Genre;
    }
    public String ISBN1(){
        return ISBN;
    }
}
