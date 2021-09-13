package GokaySendilEfeNerman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;


public class HomePage extends JFrame {
    private JButton addProductButton;
    private JButton DeleteButton;
    private JLabel usernamelabel;
    private JLabel companybranchlabel;
    private JLabel companynamelabel;
    private JPanel mainpanel;
    private JList productList;










    private CreateDatabase database= new CreateDatabase();


    public JList getProductList() {
        return productList;
    }

    public void setProductList(JList productList) {
        this.productList = productList;
    }

    public HomePage() throws SQLException {
        add(mainpanel);
        setSize(600,400);
        setResizable(false);
        setLocationRelativeTo(null);
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) productList.getModel();
                int selected =productList.getSelectedIndex();
                System.out.println(selected);
                if(selected>0){
                    String s = (String) productList.getSelectedValue();
                    String array[]=s.split("=>");
                    for (int i=0;i<array.length;i++){
                        System.out.println(array[i]);
                    }
                    try {
                        if (database.remove_from_products(array[0])){
                            updateList();
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }



            }
        });
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order=new Order();
                order.setHomePage((HomePage) addProductButton.getParent().getParent().getParent().getParent().getParent());
                System.out.println(order.getHomePage());
                order.setVisible(true);

            }
        });
    }




    public void updateList() throws SQLException {
        String arrayUSERNAME[]=usernamelabel.getText().split("=>");
        System.out.println(arrayUSERNAME[1]);
        ArrayList<String> products=database.get_products(database.find_inventory_id(arrayUSERNAME[1]));
        DefaultListModel model = new DefaultListModel();
        model.addElement("Products Shows as     Name =>     Description =>      Price =>    Quantity");
        for (int i =0;i<products.size();i++){
            model.addElement(products.get(i));
            System.out.println(products.get(i));
        }
        productList.setModel(model);
    }





    public JLabel getUsernamelabel() {
        return usernamelabel;
    }

    public void setUsernamelabel(JLabel usernamelabel) {
        this.usernamelabel = usernamelabel;
    }

    public JLabel getCompanybranchlabel() {
        return companybranchlabel;
    }

    public void setCompanybranchlabel(JLabel companybranchlabel) {
        this.companybranchlabel = companybranchlabel;
    }

    public JLabel getCompanynamelabel() {
        return companynamelabel;
    }

    public void setCompanynamelabel(JLabel companynamelabel) {
        this.companynamelabel = companynamelabel;
    }

    public SıgnIn getSıgnIn() {
        return sıgnIn;
    }

    public void setSıgnIn(SıgnIn sıgnIn) {
        this.sıgnIn = sıgnIn;
    }

    public SıgnUp getSıgnUp() {
        return sıgnUp;
    }

    public void setSıgnUp(SıgnUp sıgnUp) {
        this.sıgnUp = sıgnUp;
    }

    public SignInUp getSignInUp() {
        return signInUp;
    }

    public void setSignInUp(SignInUp signInUp) {
        this.signInUp = signInUp;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    private SıgnIn sıgnIn;
    private SıgnUp sıgnUp;
    private SignInUp signInUp;
    private Order order;






}
