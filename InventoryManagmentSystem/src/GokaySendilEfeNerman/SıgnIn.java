package GokaySendilEfeNerman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class SıgnIn extends JFrame{
    private JPanel panel1;
    private JTextField usernameField;
    private JTextField passwordField;
    private JLabel UserNameLabel;
    private JLabel PasswordLabel;
    private JButton signinButton;
    public SignInUp getSignInUp() {
        return signInUp;
    }

    public void setSignInUp(SignInUp signInUp) {
        this.signInUp = signInUp;
    }

    public SıgnUp getSıgnUp() {
        return sıgnUp;
    }

    public void setSıgnUp(SıgnUp sıgnUp) {
        this.sıgnUp = sıgnUp;
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

    private SignInUp signInUp;
    private SıgnUp sıgnUp;
    private HomePage homePage;
    private Order order;



    private CreateDatabase database = new CreateDatabase();



    private String uname;
    private String pass;


    public SıgnIn(){
        add(panel1);
        setSize(360,240);
        setResizable(false);
        setLocationRelativeTo(null);
        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((usernameField.getText().equals("") && passwordField.getText().equals(""))==false){
                    uname=usernameField.getText();
                    pass=passwordField.getText();
                    try {
                        if (database.log_in(uname,pass)==true){

                            JOptionPane.showMessageDialog(null, "Welcome to Inventory Management");
                            dispose();
                            homePage= new HomePage();
                            homePage.setSıgnIn((SıgnIn) signinButton.getParent().getParent().getParent().getParent().getParent());
                            JLabel label = homePage.getUsernamelabel();
                            label.setText("Username =>"+uname);
                            homePage.setUsernamelabel(label);
                            ArrayList<String> infos= database.company_infos(uname);
                            label=homePage.getCompanynamelabel();
                            label.setText("Company Name => "+infos.get(0).toString());
                            homePage.setCompanynamelabel(label);
                            label=homePage.getCompanybranchlabel();
                            label.setText("Company Branch => "+infos.get(1).toString());
                            homePage.setCompanybranchlabel(label);
                            homePage.setVisible(true);

                            // fill the InventoryList
                            homePage.updateList();
                           /* ArrayList<String> products=database.get_products(database.find_inventory_id(uname));
                            DefaultListModel model = new DefaultListModel();
                            model.addElement("Products Shows as     Name =>     Description =>      Price =>    Quantity");
                            for (int i =0;i<products.size();i++){
                                model.addElement(products.get(i));
                                System.out.println(products.get(i));
                            }
                            JList home = homePage.getProductList();
                            home.setModel(model);
                            homePage.setProductList(home); */





                        }
                        else if(database.log_in(uname,pass)==false){
                            JOptionPane.showMessageDialog(null, "Username&Password not match.Please check account information");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }


            }
        });
    }
}
