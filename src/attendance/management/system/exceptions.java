/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.management.system;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author ok
 */
public class exceptions extends Exception implements Serializable{
    public exceptions() {
        super();
    }

    public exceptions(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "My Exception";
    }

    int checkPositive(String x) {
        int number;
        do {
            number = Integer.parseInt(JOptionPane.showInputDialog("Enter Positive Number for " + x + " !"));
            if (number <= 0) {
                JOptionPane.showMessageDialog(null, "Not valid Input for Positive Int Try Again :(");
            }
        } while (number <= 0);

        return number;
    }

    String checkEmail(String x) {
        String email;
        do {
            email = JOptionPane.showInputDialog("Enter Valid input for " + x + " !");
            if (!email.contains("@") || !email.contains(".")) {
                JOptionPane.showMessageDialog(null, "Not valid Input for Email Try Again :(");
            }
        } while (!email.contains("@") || !email.contains("."));

        return email;
    }

    String checkPassLength(String x) {
        String pass;
        do {
            pass = JOptionPane.showInputDialog("Enter more than 8 char for " + x + " !");
            if (pass.length() < 8) {
                JOptionPane.showMessageDialog(null, "Not valid Password length Try Again :(");
            }
        } while (pass.length() < 8);

        return pass;
    }
    
}
