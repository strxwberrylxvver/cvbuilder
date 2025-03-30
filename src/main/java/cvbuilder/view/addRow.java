package cvbuilder.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

import cvbuilder.model.CVData;



public class addRow implements ActionListener {
    private String value = "";
    private String attribute;
    private ButtonGroup bg = new ButtonGroup();
    private JPanel row;
    private JRadioButton j;
    private String word;

    public addRow(String word, String attribute, JPanel panel, int jsize) {
      this.word = word;
      this.attribute = attribute;

            if ("name".equals(attribute)) {
                j = new JRadioButton(word);
            } else if ("title".equals(attribute)) {
                j = new JRadioButton(word);
            } else if ("email".equals(attribute)) {
                j = new JRadioButton(word);
            } else {
                value = "";
            }

            row = new JPanel();
            JButton e = new JButton("Edit");
            JButton d = new JButton("Delete");

            j.setPreferredSize(new Dimension(jsize, 30));
            j.addActionListener(this);
            j.setActionCommand("Choose");
            row.add(j);

            e.setPreferredSize(new Dimension(65, 25));
            e.addActionListener(this);
            e.setActionCommand("Edit");
            row.add(e);

            d.setPreferredSize(new Dimension(70, 25));
            d.addActionListener(this);
            d.setActionCommand("Delete");
            row.add(d);

            bg.add(j);
            row.repaint();
            panel.add(row, BorderLayout.CENTER);

}
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Delete":
                JButton button = (JButton) e.getSource();
                JPanel parentPanel = (JPanel) button.getParent();
                int response = JOptionPane.showConfirmDialog(null, "Would you like to delete?");
                if (response == JOptionPane.YES_OPTION) {
                    switch (attribute) {
                        case "name" -> CVData.getInstance().getNames().remove(value);
                        case "title" -> CVData.getInstance().getTitles().remove(value);
                        case "email" -> CVData.getInstance().getEmails().remove(value);
                    }
                    JPanel parentContainer = (JPanel) row.getParent();
                    parentContainer.remove(row);
                    parentContainer.revalidate();
                    parentContainer.repaint();
                            break;
                    }

                MainViewer.getInstance().addPanel();
              //  CVData.getInstance().writeSuperCsv("userprofile.csv");
                break;

            case "Edit":
                JButton button2 = (JButton) e.getSource();
                JPanel parentPanel2 = (JPanel) button2.getParent();
                JRadioButton radioButton2 = (JRadioButton) parentPanel2.getComponent(0);
                String input = JOptionPane.showInputDialog(null, "Enter New Text", radioButton2.getText());
                if (input != null) {
                    radioButton2.setText(input);
                    System.out.println("User input: " + input);


                }
                //CVData.getInstance().writeSuperCsv("userprofile.csv");
                break;

            case "Choose":
                if (j.isSelected()) {
                    System.out.println("Selected");
                }
        break;
        }
    }
    }

