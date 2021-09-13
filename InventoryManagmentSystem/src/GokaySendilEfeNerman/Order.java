package GokaySendilEfeNerman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order extends JFrame {
    private JPanel mainPanel;
    private JLabel productName;
    private JTextField ProductNameTextField;
    private JTextField ProductDescTextField;
    private JTextField orderCountTextField;
    private JButton orderButton;
    private JLabel productDescription;
    private JLabel orderCount;
    private JLabel orderDate;
    private JLabel Date;



    private String name;
    private String desc;
    private int    quantity;
    CreateDatabase database= new CreateDatabase();



    public Order(){
        add(mainPanel);
        setSize(361,400);
        setResizable(false);
        setLocationRelativeTo(null);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        Date.setText(dtf.format(now));



        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((ProductNameTextField.getText().equals("") &&ProductDescTextField.getText().equals("") && orderCountTextField.getText().equals(""))==false){

                    name=ProductNameTextField.getText();
                    desc=ProductDescTextField.getText();
                    quantity=Integer.parseInt(orderCountTextField.getText());
                    try {
                        if (database.find_product(name)){
                            if (database.update_quantity(name,database.get_product_quantity(name)+quantity)){


                                       /* DefaultListModel model= new DefaultListModel();
                                        ArrayList<String> products= new ArrayList<>();
                                        JList list = homePage.getProductList();
                                        String arrayUSERNAME[]=homePage.getUsernamelabel().getText().split("=>");
                                        products=database.get_products(database.find_inventory_id(arrayUSERNAME[1]));
                                        for (int j=0;j<products.size();j++){
                                            model.addElement(products.get(j));
                                        }
                                        list.setModel(model); */

                                        homePage.updateList();
                                    JOptionPane.showMessageDialog(null, "Quantity Updated");
                                    dispose();




                            }
                        }
                        if(database.find_product(name)==false){
                            String arrayUSERNAME[]=homePage.getUsernamelabel().getText().split("=>");
                            String arrayCOMPANYBRANCH[]=homePage.getCompanybranchlabel().getText().split("=>");
                            int inventory =database.find_inventory_id(arrayUSERNAME[1]);
                            if (database.update_order(name,desc,quantity,inventory)){
                                if (database.add_product(name,desc,arrayCOMPANYBRANCH[1],quantity,inventory));
                                JOptionPane.showMessageDialog(null, "Order Completed");
                                homePage.updateList();
                            }
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }
            }
        });
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

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public SignInUp getSignInUp() {
        return signInUp;
    }

    public void setSignInUp(SignInUp signInUp) {
        this.signInUp = signInUp;
    }

    private SıgnIn sıgnIn;
    private SıgnUp sıgnUp;
    private HomePage homePage;
    private SignInUp signInUp;
}
