package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SGBAU {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SGBAU::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Open Google Link");
        JLabel linkLabel = new JLabel("<html><a href=''>SANT GADGE BABA AMRAVATI UNIVERSITY</a></html>");

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
                        "Failed to open the link: " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace(); // Optional: log the error for debugging
                }
            }
        });

        frame.add(linkLabel);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
    
    public SGBAU() {
        setTitle("SGBAU");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close this frame only
        JLabel label = new JLabel("Welcome to SGBAU", SwingConstants.CENTER);
        add(label);
        setVisible(true);
    }

    private void setTitle(String sgbau) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setSize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setDefaultCloseOperation(int DISPOSE_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void add(JLabel label) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}