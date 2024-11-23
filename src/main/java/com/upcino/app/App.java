package com.upcino.app;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import com.upcino.swarmintelligence.HostAgent;
import com.upcino.swarmintelligence.MainFrame;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
		// Create an instance of HostAgent
        HostAgent anfitrion = new HostAgent();
        
        // Create an instance of MainFrame with the HostAgent
        MainFrame frame = new MainFrame(anfitrion);
        
        // Initialize and display the MainFrame
        frame.inicializar();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new DimensionUIResource(800, 600));
        frame.setVisible(true);
    }
}
