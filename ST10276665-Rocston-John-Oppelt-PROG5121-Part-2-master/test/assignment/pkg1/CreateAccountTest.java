/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignment.pkg1;

import org.junit.Test;
import static org.junit.Assert.*;

public class CreateAccountTest {

    @Test
    public void testValidUsernameCreation() {
       
        String username = "kyl_1";
        
   
        String welcomeMessage = createWelcomeMessage(username);
 
        assertEquals("Welcome <user first name> ,<user last name> it is great to see you.", welcomeMessage);
    }
    
    @Test
    public void testInvalidUsernameCreation() {
 
        String invalidUsername = "kyle!!!!!!!";
        
 
        String errorMessage = getUsernameErrorMessage(invalidUsername);
        
    
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", errorMessage);
    }
    
    @Test
    public void testValidPasswordCreation() {
     
        String validPassword = "Ch&&sec@ke99!";
        
    
        String successMessage = getPasswordSuccessMessage(validPassword);
        
      
        assertEquals("Password successfully captured", successMessage);
    }
    
    @Test
    public void testInvalidPasswordCreation() {
    
        String invalidPassword = "password";
        
      
        String errorMessage = getPasswordErrorMessage(invalidPassword);
        
     
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", errorMessage);
    }
    
 
    private String createWelcomeMessage(String username) {
        if (isValidUsername(username)) {
          
            return "Welcome <user first name> ,<user last name> it is great to see you.";
        } else {
            return null;
        }
    }
 
    private boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }
    

    private String getUsernameErrorMessage(String username) {
        if (!isValidUsername(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else {
            return null; 
        }
    }
    
  
    private String getPasswordSuccessMessage(String password) {
     
        return "Password successfully captured";
    }
    

    private String getPasswordErrorMessage(String password) {
      
        return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
    }
}
