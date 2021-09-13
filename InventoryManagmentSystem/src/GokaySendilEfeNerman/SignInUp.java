package GokaySendilEfeNerman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInUp extends JFrame {
    private JButton signInButton;
    private JButton sıgnUpButton;
    private JPanel panel1;
    private JLabel welcomeToTheInventoryManagementSystemLabel;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // forms
    private SıgnIn sıgnIn;
    private SıgnUp sıgnUp;
    private HomePage homePage;
    private Order order;



    public SignInUp(){
        add(panel1);
        setSize(480,300);
        setResizable(false);
        setLocationRelativeTo(null);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                sıgnIn= new SıgnIn();
                sıgnIn.setSignInUp((SignInUp) signInButton.getParent().getParent().getParent().getParent().getParent());
                sıgnIn.setVisible(true);

            }
        });
        sıgnUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                sıgnUp = new SıgnUp();
                sıgnUp.setSignInUp((SignInUp) signInButton.getParent().getParent().getParent().getParent().getParent());
                sıgnUp.setVisible(true);
            }
        });
    }
}