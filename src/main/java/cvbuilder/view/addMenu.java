/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import cvbuilder.model.CVData;

public class addMenu extends JMenuBar implements ActionListener{
    JMenu fileMenu;
    JMenuItem openFile;
    JMenuItem quit;
    JMenuItem saveFile;
    public addMenu(JFrame frame){
        fileMenu = new JMenu("File");
        openFile = new JMenuItem("Open File");
        quit = new JMenuItem("Quit");
        saveFile = new JMenuItem("Save File");

        openFile.addActionListener(this);
        openFile.setActionCommand("OpenFile");
        quit.addActionListener(this);
        quit.setActionCommand("QuitFile");
        saveFile.addActionListener(this);
        saveFile.setActionCommand("saveFile");

        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(quit);
        this.add(fileMenu);
        frame.add(this,BorderLayout.NORTH);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand()){

            case "OpenFile":
                System.out.println("Open File");
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "CSV Files", "csv");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: ");
                            chooser.getSelectedFile();
                }
                break;

            case "saveFile":
                System.out.println("Save File");
                JFileChooser choose = new JFileChooser();
                FileNameExtensionFilter filte = new FileNameExtensionFilter(
                        "CSV Files", "csv");
                choose.setFileFilter(filte);
                int returnval = choose.showSaveDialog(null);
                if(returnval == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to save this file: ");
                           // choose.getSelectedFile().getName());
                    //CVData.getInstance().writeSuperCsv(choose.getSelectedFile().getName());
                }
                break;

            case "QuitFile":
                System.out.println("Quit");
                System.exit(0);
                break;
                }
    }
}
