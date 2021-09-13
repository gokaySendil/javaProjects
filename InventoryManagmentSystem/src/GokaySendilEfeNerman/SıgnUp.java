package GokaySendilEfeNerman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SıgnUp extends JFrame{
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField emailField;
    private JTextField BirthDateField;
    private JTextField AddressField;
    private JPanel userInformation;
    private JPanel InventoryInformation;
    private JTextField CompanyNameField;
    private JTextField CompanyBranchField;
    private JTextField CompanyLocationField;
    private JTextField CompanySloganField;
    private JLabel company_name;
    private JLabel company_branch;
    private JLabel company_location;
    private JLabel company_slogan;
    private JLabel username;
    private JLabel password;
    private JLabel email;
    private JLabel birthdate;
    private JLabel address;
    private JButton signUpButton;
    private JPanel mainpanel;


    public SıgnIn getSıgnIn() {
        return sıgnIn;
    }

    public void setSıgnIn(SıgnIn sıgnIn) {
        this.sıgnIn = sıgnIn;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public SignInUp getSignInUp() {
        return signInUp;
    }

    public void setSignInUp(SignInUp signInUp) {
        this.signInUp = signInUp;
    }

    private SıgnIn sıgnIn;
    private HomePage homePage;
    private Order order;
    private SignInUp signInUp;



    private CreateDatabase database = new CreateDatabase();


    private String uname;
    private String pass;
    private String mail;
    private String DateB;
    private String Address;
    private String cname;
    private String c_branch;
    private String c_location;
    private String c_slogan;





    public SıgnUp(){
        add(mainpanel);
        setSize(640,300);
        setResizable(false);
        setLocationRelativeTo(null);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(usernameField.getText().equals("") && passwordField.getText().equals("")&& emailField.getText().equals("")
                        && BirthDateField.getText().equals("") && AddressField.getText().equals("") && CompanyNameField.getText().equals("")
                        && CompanyBranchField.getText().equals("") && CompanyLocationField.getText().equals("") && CompanySloganField.getText().equals(""))){


                    cname=CompanyNameField.getText();
                    c_branch=CompanyBranchField.getText();
                    c_location= CompanyLocationField.getText();
                    c_slogan=CompanySloganField.getText();

                    uname=usernameField.getText();
                    pass=passwordField.getText();
                    mail=emailField.getText();
                    DateB=BirthDateField.getText();
                    Address=AddressField.getText();




                    try {
                        if (database.username_isvalid(uname) && (database.companyname_isValid(cname))){
                            if (database.SAVE_COMPANY(cname,c_branch,c_location,c_slogan)){
                                if(database.SAVE_USER(uname,pass,mail,DateB,Address)){
                                    JOptionPane.showMessageDialog(null, "You are succesfully signed up");
                                    dispose();
                                    signInUp.setVisible(true);

                                }
                            }

                        }
                        if(database.companyname_isValid(cname)==false){
                            JOptionPane.showMessageDialog(null, "Company Already in Database");
                        }

                        if(database.companyname_isValid(cname)==false){
                            JOptionPane.showMessageDialog(null, "Username is already Taken");
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }
            }
        });
    }
}
