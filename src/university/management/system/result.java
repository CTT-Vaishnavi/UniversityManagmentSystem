/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;

/**
 *
 * @author shind
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class result {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Open Google Link");
        JLabel linkLabel = new JLabel("<html><a href=''>Sant Gadge baba Amravati university</a></html>");

        linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        linkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String googleLink = "https://sgbau.ac.in/";
                try {
                    Desktop.getDesktop().browse(new URI(googleLink));
                } catch (IOException | URISyntaxException ex) {
                    // Show an error dialog to the user
                    JOptionPane.showMessageDialog(frame, 
                        "Failed to open the link. Please try again later.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace(); // Optional: log the error for debugging
                }
            }
        });

        frame.add(linkLabel);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
