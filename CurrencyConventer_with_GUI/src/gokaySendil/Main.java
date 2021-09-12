package gokaySendil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       JFrame frame= new JFrame();
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       frame.setContentPane(new Conventer().getPlane());
       frame.setResizable(false);
       frame.setPreferredSize(new Dimension(400,300));
       frame.setVisible(true);
       frame.pack();

    }
}
