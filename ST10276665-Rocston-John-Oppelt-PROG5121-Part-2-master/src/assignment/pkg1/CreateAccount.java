package assignment.pkg1;

import javax.swing.JOptionPane;

public class CreateAccount
{
//These are the variables which will be used in the file. These Variables were made public so that we are able to use it again in other methods.
    public static String username;          //This makes it really convenient and easy for me to use this data.
    public static String password;
    public static String firstName;
    public static String secondName;
    public static boolean validUsername;
    
    
    //----------------------------------------------------------------------------------------------
    //When this method is being runned, the user will be prompt to enter thier first and second name,
    public static void full_name() //  
                                   //I was comtemplating whether to change secondName in the surName seeing my second name is John.
    {
       
        
        
        
        
        firstName = JOptionPane.showInputDialog("Please enter your First Name");            
        secondName = JOptionPane.showInputDialog("Please enter your Second Name");

        usernameCreation();         //Once the user has inputed thier FIrst and Second name, the usernameCreation() method will be called.

    }

    //----------------------------------------------------------------------------------------------
    // Username creation method: This is where the user will be able to make a Username. The username will be processed to see if it is validated.
    public static void usernameCreation()   
    {
        boolean validUsername = false;  //We made validUsername false, so when the users ,username meets the criteria, validUsername will be true. 
                                        

        while (!validUsername) //A while loop is used to that when the user enters a invalid username, they are able to try again.
        {
            username = JOptionPane.showInputDialog(null, "Please give a Username"); //prompt the user to enter a Username
            if (username.length() >= 5 && username.contains("_"))                   //Username will be proceseed to she if it is valid.
            {
                validUsername = true;  //if the username meets the criteria , validUsername will be true so that the while loop ends
                JOptionPane.showMessageDialog(null, "Username successfully captured");
                
                CreateAccount.passwordCreation();

            } else
            {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, "
                +"please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }
    }

    //----------------------------------------------------------------------------------------------
    //This method is responsible for creating the password
    public static void passwordCreation() 
    {
        boolean validPassword = false; //While valid password is false

        while (!validPassword)
        {
            password = JOptionPane.showInputDialog(null, "Please create a password"); //prompt the user to enter a password

            if (password.length() >= 8 && containsCapitalLetter(password) && containsNumber(password) && containsSpecialCharacter(password))//Check the password if it is validated, if it is validated
            {
                validPassword = true;
                JOptionPane.showMessageDialog(null, "Password successfully captured");//prompt the user that it is secessfully captured, if else the user did not enter a validated password
                
                System.out.println("Username details\n"
                    + "Username: " + username
                    + "\nPassword: " + password);
                Assignment1.showMainMenu();

            } else
            {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special characterS");
            }                                 //prompt the user that the user is not valid, allow them to try again
        }
    }
    //----------------------------------------------------------------------------------------------
    //This method is responsible for checking if the password cantains a uppercase, this is called while the password is being processed.
    public static boolean containsCapitalLetter(String password)
    {
        for (char c : password.toCharArray())  //turns each character in the string into a element in a array
        {
            if (Character.isUpperCase(c))      // for (char c is a for-each loop,  it iterates over each character in the array
            {                                   // char c :, c is the variable and char is the type, makes all the  elements into characters
                return true;
            }
        }
        return false;
    }

    
    //----------------------------------------------------------------------------------------------
     //This method is responsible for checking if the password contains a number.This is called while the password is being processed.       
    public static boolean containsNumber(String password)         
    {
        for (char c : password.toCharArray())
        {
            if (Character.isDigit(c)) 
            {
                return true;
            }
        }
        return false;
    }
    
    //----------------------------------------------------------------------------------------------
    //This method is responsibe for checking the password if it containa a special character, this method is called while the password is being processed.
    public static boolean containsSpecialCharacter(String password)
    {
        String specialCharacters = "!@#$%^&*()-_=+<>?";

        for (char c : password.toCharArray())
        {
            if (specialCharacters.contains(String.valueOf(c)))
            {
                return true;
            }
        }
        return false;
    }
    
    
}
//.........................................................................................................End Of File.......................................................................................//