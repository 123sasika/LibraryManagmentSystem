/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer_exception;

/**
 *
 * @author USER
 */
public class DVDNotFoundException extends Exception {
    public DVDNotFoundException(String message){
        super(message);
    }
}
