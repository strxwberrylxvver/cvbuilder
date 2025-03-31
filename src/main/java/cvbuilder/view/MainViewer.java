/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import java.awt.*;
import javax.swing.*;

public class MainViewer extends JFrame {
private static MainViewer instance;
    public static MainViewer getInstance(){
        if (instance == null)
        {instance = new MainViewer();
        }
        return instance;
    }

    private MainViewer() {
        this.setTitle("User Profile Builder");
        this.setSize(500, 400);
        this.setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("User",new UserPanel());
        tabs.addTab("References", new ReferencePanel());

        this.add(tabs, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}