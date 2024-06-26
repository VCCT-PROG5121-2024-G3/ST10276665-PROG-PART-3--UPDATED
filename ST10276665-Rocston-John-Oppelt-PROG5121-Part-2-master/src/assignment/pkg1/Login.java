package assignment.pkg1;

import javax.swing.JOptionPane;

public class Login //This is the class that is responsible for allowing the user to login after creating a account
{

    public static String username1 = "";            //I made another password and username variable
    public static String password1 = "";

    //----------------------------------------------------------------------------------------------
    //I did not know what to call this method, but apple is my favourite fruit!
    public static void apple()
    {
        username1 = JOptionPane.showInputDialog("Please Enter your Username");  //Ask user to enter thier username 

        if (username1.equals(CreateAccount.username)) //if the username the user entered (username1) is the same username the user entered in the CreateAccount.java file,
        {
            // The username is correct, prompt for password
            password1 = JOptionPane.showInputDialog("Please Enter your Password"); //prompt the user to enter the password

            // Check if the password meets complexity requirements
            if (checkPasswordComplexity(password1) && password1.equals(CreateAccount.password) && checkUserName(username1)) //If the password is the same password as the password in CreateAccount, also the password meets the 
            {                                                                                                               //checkPasswordComplexity()//This checks if the password is valiadated. It will also check if the username is the same username the user entered in CreateAccount.java
                // Both username and password are correct
                JOptionPane.showMessageDialog(null, "Welcome " + CreateAccount.firstName + " " + CreateAccount.secondName + " it is great to see you again.");// Greet the user With thier full name
                registerUser();//This method is called
            } else
            {
                // Incorrect password or password complexity not met
                JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");//else prompt the user that their password or username is incorrect
                registerUser();
            }
        } else
        {
            // Incorrect username
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");

        }
    }

    //----------------------------------------------------------------------------------------------
    //this method is responsible for determinning if the username and password the user entered is valid
    public static void registerUser()
    {
        boolean validUsername = false;
        boolean validPassword = false; //we make both of these variables false so that we can 

        if (username1.length() <= 5 && username1.contains("_")) // if the username is less than or equal to 5 characters and the username contains a underscore
        {
            validUsername = true; //username is valid
            JOptionPane.showMessageDialog(null, "Username successfully captured");//prompt the user that the username has been captured

            if (password1.length() >= 8 && containsUppercase(password1) && containsNumber(password1) && containsSpecialCharacter(password1))//criteria for the password to  be validated
            {
                validPassword = true;//password is validated
                JOptionPane.showMessageDialog(null, "Password successfully captured"); //prompt the user that the password meets the criteria,else
            } else
            {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character");//prompt the user that thier password does not meet the criteria and must try again
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");//prompt the user that thier username is not valid and let them try again.
        }

        if (validUsername && validPassword)                                 //if both is username and password is validated
        {
            JOptionPane.showMessageDialog(null, "Registration complete!");  //display that the registration has been complete
            loginUser(username1, password1);
            Addtasks.easyKanBan();                                       // After successful registration, show the main menu

        } else
        {
            JOptionPane.showMessageDialog(null, "Registration canceled.");  //else prompt the user that the registration is canceled
        }

    }

    //----------------------------------------------------------------------------------------------
    //This method is responsible for giving a prompt on the terminal.
    private static boolean loginUser(String enteredUsername, String enteredPassword)
    {

        String storedUsername = CreateAccount.username;
        String storedPassword = CreateAccount.password;

        if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword))//if the username and password is the same as stored username and ppassword
        {
            System.out.println("Login details entered match the login details stored when the user registers.");//prompt in the terminal that  the login details are the same as when the user registered.
            Login.returnLoginStatus(enteredUsername, enteredPassword);//Call this method

            return true; // 
        } else
        {
            return false; // 
        }
    }

    //----------------------------------------------------------------------------------------------
    //This method is responsible for prompting the terminal if the login is succesful or unsucessful
    private static boolean returnLoginStatus(String enteredUsername, String enteredPassword)
    {

        String storedUsername1 = CreateAccount.username;
        String storedPassword1 = CreateAccount.password;
        if (enteredUsername.equals(storedUsername1) && enteredPassword.equals(storedPassword1)) // if this is the smae
        {
            System.out.println("Login Successful");//prompt the user this
            return true; // 
        } else
        {

            System.out.println("Login unsuccessful");//else prompt the user this
            return false; // 

        }
    }

    //----------------------------------------------------------------------------------------------
    //This method is responsible for checking if the username is valid, this is called while the username is being processed.
    private static boolean checkUserName(String username)
    {
        String specialCharacters = "_";
        boolean containsUnderscore = false;

        for (char c : username.toCharArray())
        {
            if (specialCharacters.contains(String.valueOf(c)))
            {
                containsUnderscore = true;
                break; // Exit the loop as soon as an underscore is found
            }
        }

        if (!containsUnderscore)
        {
            JOptionPane.showMessageDialog(null, "Your username does not contain an underscore (_)");
            return false;
        } else
        {
            return true;
        }
    }

    //----------------------------------------------------------------------------------------------
    //This method is responsible for checking if the password is complex, this called while the password is being processed.
    private static boolean checkPasswordComplexity(String password)
    {

        if (password.length() < 8 || !containsUppercase(password) || !containsNumber(password) || !containsSpecialCharacter(password))
        {
            return false;
        } else
        {
            return true;
        }
    }

    //----------------------------------------------------------------------------------------------
    //This method is responsible for checking if the password cantains a uppercase, this is called while the password is being processed.
    private static boolean containsUppercase(String password)
    {
        for (char c : password.toCharArray())
        {
            if (Character.isUpperCase(c))
            {
                return true;
            }
        }
        return false;
    }

    //----------------------------------------------------------------------------------------------
    //This method is responsible for checking if the password contains a number.This is called while the password is being processed.
    private static boolean containsNumber(String password)
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
    private static boolean containsSpecialCharacter(String password)
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

    //----------------------------------------------------------------------------------------------
    //This method is responsible for prompting the user if the login has been successful.
    public static String returnLoginStatus(boolean loginSuccessful)
    {
        if (loginSuccessful)
        {
            return "Login successful. Welcome!";
        } else
        {
            return "Login failed. Please check your username and password.";
        }
    }

}
