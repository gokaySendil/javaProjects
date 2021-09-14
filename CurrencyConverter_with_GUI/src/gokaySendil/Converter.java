package gokaySendil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Converter {
    private JLabel CurrencyText;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JButton CalculalteButton;
    private JPanel plane;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JLabel result;

    public Converter(){
        add_items();
        CalculalteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String amount = textField1.getText();
                    ComboItem from = (ComboItem) comboBox1.getSelectedItem();
                    ComboItem to = (ComboItem) comboBox2.getSelectedItem();
                    CurrencyConverter conventer = new CurrencyConverter(from.getKey(),to.getKey(),amount);
                    result.setText(conventer.connect());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    public void add_items(){
        comboBox1.addItem(new ComboItem("1","USD"));
        comboBox1.addItem(new ComboItem("2","CAD"));
        comboBox1.addItem(new ComboItem("3","EUR"));
        comboBox1.addItem(new ComboItem("4","HKD"));
        comboBox1.addItem(new ComboItem("5","INR"));
        comboBox1.addItem(new ComboItem("6","TRY"));
        comboBox2.addItem(new ComboItem("1","USD"));
        comboBox2.addItem(new ComboItem("2","CAD"));
        comboBox2.addItem(new ComboItem("3","EUR"));
        comboBox2.addItem(new ComboItem("4","HKD"));
        comboBox2.addItem(new ComboItem("5","INR"));
        comboBox2.addItem(new ComboItem("6","TRY"));
    }




    public JLabel getCurrencyText() {
        return CurrencyText;
    }

    public void setCurrencyText(JLabel currencyText) {
        CurrencyText = currencyText;
    }

    public JSpinner getSpinner1() {
        return spinner1;
    }

    public void setSpinner1(JSpinner spinner1) {
        this.spinner1 = spinner1;
    }

    public JSpinner getSpinner2() {
        return spinner2;
    }

    public void setSpinner2(JSpinner spinner2) {
        this.spinner2 = spinner2;
    }

    public JButton getButton1() {
        return CalculalteButton;
    }

    public void setButton1(JButton button1) {
        this.CalculalteButton = button1;
    }

    public JPanel getPlane() {
        return plane;
    }

    public void setPlane(JPanel plane) {
        this.plane = plane;
    }
}
