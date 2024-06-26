package assignment.pkg1;

import javax.swing.JOptionPane;

public class Assignment1 {

    public static void main(String[] args) {
        showMainMenu();                     //Calls MainMenu() to be called when the program starts
    }

    //This method is responsible for displaying the main menu to the user
    public static void showMainMenu() {
        Object[] options
                = {
                    "Create a account", "Login", "Forgot Password "//This is what the 3 options will diaplay as. This is so we can navigate the user properly.
                };
        int choice = JOptionPane.showOptionDialog(
                null,
                "Please choose an option:",
                "Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        System.out.println("Choice: " + choice);        //This was used for testing. To help me understand how I was going to go about navaigation when I started this assisngment.             

        if (choice == 0) {
            CreateAccount.full_name();                  //Option 0, which is the first option, will take the user to the CreateAccount process.
        } else if (choice == 1) {
            Login.apple();                              //Option 1, which is the second option, will take the user to the Login process.
        } else if (choice == 2) {
                              //Option 2, which is the second option, will take the user to the forgot password process.
        } else {
            JOptionPane.showMessageDialog(null, "You didn't choose any option.");       //If the user decides to exit the program via the JOptionPane GUI. This will display.
            System.exit(0);
        }
    }

    

   
}



//........................................................................................................End Of File......................................................................................................//
