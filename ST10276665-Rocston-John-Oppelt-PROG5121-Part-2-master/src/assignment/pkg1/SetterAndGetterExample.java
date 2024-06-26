package assignment.pkg1;


import javax.swing.JOptionPane;

public class SetterAndGetterExample //declaring variables
{

    private String passwordFG;
    private String usernameFG;                          
    private String newPasswordFG;
    

    public SetterAndGetterExample() //default constructer
    {

    }

    public SetterAndGetterExample(String passwordFG, String usernameFG) //Master Constructer
    {

        this.passwordFG = passwordFG;
        this.usernameFG = usernameFG;
    }

    public String getUsernameFG()           //getter for usernameFG
    {

        return usernameFG;

    }
    
    //Responsible for setting the variable UsernameFG. This checks if the user name is correct
    public void setUsernameFG()                 //setter for UsernameFG
    {
        String input = JOptionPane.showInputDialog(null, "Please enter your current username.");
        this.usernameFG = input;

        boolean validUsername = false;
        while (!validUsername)
        {
            if (usernameFG.equals(Login.username1))
            {
                JOptionPane.showMessageDialog(null, "Your username is correct");
                setPasswordFG(); // Call the method here
                validUsername = true; // Set the flag to exit the loop
            } else
            {
                JOptionPane.showMessageDialog(null, "Your username is not correct. Please try again");
            }
        }
    }

    public String getpasswordFG()                 //Getter for passwordFG
    {
        return passwordFG;
    }

    
    //This method is responesible for checking if the user entered the right password
    public void setPasswordFG()                   //setter for passwordFG
    {

        String input = JOptionPane.showInputDialog(null, "Please enter your old password");
        this.passwordFG = input;

        boolean validPassword = false;

        while (!validPassword)

        {
            if (passwordFG.equals(Login.password1))
            {
                JOptionPane.showMessageDialog(null, "Your password is correct.");
                setNewPasswordFG();
            } else
            {
                JOptionPane.showMessageDialog(null, "Your password is not the same, please try again.");
            }
        }
    }
    //Gets new passwordFG
    public String getNewPasswordFG()
    {

        return newPasswordFG;

    }

    public void setNewPasswordFG()
    {
        boolean validPassword = false;

        while (!validPassword)
        {
            String newPasswordFG = JOptionPane.showInputDialog(null, "Please create your new password");

            if (newPasswordFG.length() >= 8
                    && CreateAccount.containsCapitalLetter(newPasswordFG)
                    && CreateAccount.containsNumber(newPasswordFG)
                    && CreateAccount.containsSpecialCharacter(newPasswordFG))
            {

                this.newPasswordFG = CreateAccount.password;
                System.out.println("Password has been changed to " + newPasswordFG);
                JOptionPane.showMessageDialog(null, "Your new password is " + newPasswordFG);
                validPassword = true; // Set the flag to exit the loop
                Assignment1.showMainMenu(); 
            } else
            {
                JOptionPane.showMessageDialog(null, "Your password does not meet the conditions.");
                // Ask for new password again
            }
        }
    }
    


}
