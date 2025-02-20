package cvbuilder.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

import cvbuilder.model.CVData;



//public class addRow implements ActionListener {
//    String value = "";
//    ButtonGroup bg = new ButtonGroup();
//    JPanel row;
//
//    public addRow(String attribute, JPanel panel, int jsize) {
//
//            if ("name".equals(attribute)) {
//                value = u.getName();
//            } else if ("title".equals(attribute)) {
//                value = u.getTitle();
//            } else if ("email".equals(attribute)) {
//                value = u.getEMail();
//            } else {
//                value = "";
//            }
//
//            row = new JPanel();
//            JRadioButton j = new JRadioButton(value);
//            JButton e = new JButton("Edit");
//            JButton d = new JButton("Delete");
//            row.setBorder(BorderFactory.createTitledBorder(u.getUserProfileID()));
//
//            j.setPreferredSize(new Dimension(jsize, 30));
//            j.addActionListener(this);
//            j.setActionCommand("Choose");
//            row.add(j);
//
//            e.setPreferredSize(new Dimension(65, 25));
//            e.addActionListener(this);
//            e.setActionCommand("Edit");
//            row.add(e);
//
//            d.setPreferredSize(new Dimension(70, 25));
//            d.addActionListener(this);
//            d.setActionCommand("Delete");
//            row.add(d);
//
//            bg.add(j);
//            row.repaint();
//            panel.add(row, BorderLayout.CENTER);
//    }
//
//    //@Override
//    public void actionPerformed(ActionEvent e) {
//
//        switch (e.getActionCommand()) {
//
//            case "Delete":
//                JButton button = (JButton) e.getSource();
//                JPanel parentPanel = (JPanel) button.getParent();
//                JRadioButton radioButton = (JRadioButton) parentPanel.getComponent(0);
//                int response = JOptionPane.showConfirmDialog(null, "Would you like to delete?");
//                if (response == JOptionPane.YES_OPTION) {
////                    for (User u : CVData.getInstance().getUsers()) {
////                        if (u.getName().equals(value) || u.getEMail().equals(value) || u.getTitle().equals(value)) {
////                            CVData.getInstance().getUsers().remove(u);
////                            JPanel parentContainer = (JPanel) parentPanel.getParent();
////                            parentContainer.remove(parentPanel);
////
////                            parentContainer.revalidate();
////                            parentContainer.repaint();
////                            System.out.println("User deleted: " + u.getName());
////                            break;
////                        }
////                    }
//                }
//                //MainViewer.getInstance().addPanel();
//                //CVData.getInstance().writeSuperCsv("userprofile.csv");
//                //CVData.getInstance().setSelectedUser(null);
//                break;
//
//            case "Edit":
//                JButton button2 = (JButton) e.getSource();
//                JPanel parentPanel2 = (JPanel) button2.getParent();
//                JRadioButton radioButton2 = (JRadioButton) parentPanel2.getComponent(0);
//                String input = JOptionPane.showInputDialog(null, "Enter New Text", radioButton2.getText());
//                if (input != null) {
//                    radioButton2.setText(input);
//                    System.out.println("User input: " + input);
////                    for (User u : CVData.getInstance().getUsers()) {
////                        if (u.getName().equals(radioButton2.getText())) {
////                            u.setName(input);
////                        }
////                        if (u.getEMail().equals(radioButton2.getText())) {
////                            u.setEMail(input);
////                        }
////                        if (u.getUserProfileID().equals(radioButton2.getText())) {
////                            u.setUserProfileID(input);
////                        }
////                        if (u.getTitle().equals(radioButton2.getText())) {
////                            u.setTitle(input);
////                        }
////                    }
//                }
//                else {
//                    System.out.println("User has cancelled");
//                }
//                //CVData.getInstance().writeSuperCsv("userprofile.csv");
//                break;
//
//            case "Choose":
////                String selected = ((JRadioButton) e.getSource()).getText();
////                int index= CVData.getInstance().getUsers().indexOf(u);
////                for (JPanel panel : Arrays.asList(MainViewer.getInstance().getNamePanel(),
////                           MainViewer.getInstance().getTitlePanel(),
////                            MainViewer.getInstance().getEmailPanel()))
////                    {
////                        for (Component comp : panel.getComponents())
////                        {
////                                JPanel rowPanel = (JPanel) comp;
////                                JRadioButton radioButton3 = (JRadioButton) rowPanel.getComponent(0);
////                            if (radioButton3.getText().equals(selected)) {
////                                radioButton3.setSelected(true);
////                            }
////                        }
////                    }
//                break;
//        }
//    }
//
