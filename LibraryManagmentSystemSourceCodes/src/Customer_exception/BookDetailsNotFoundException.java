/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer_exception;

/**
 *
 * @author USER
 */
public class BookDetailsNotFoundException extends Exception {
    public BookDetailsNotFoundException(String message){
        super(message);
    }
}
