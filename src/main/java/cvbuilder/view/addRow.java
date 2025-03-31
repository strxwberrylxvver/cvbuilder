package cvbuilder.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import cvbuilder.model.CVData;



public class addRow extends JPanel implements ActionListener {
    private String value = "";
    private String attribute;
    private JRadioButton j;
    private String word;

    public addRow(String word, String attribute, ButtonGroup buttonGroup) {
      this.word = word;
      this.attribute = attribute;

            if ("Name".equals(attribute)) {
                j = new JRadioButton(word);
            } else if ("Title".equals(attribute)) {
                j = new JRadioButton(word);
            } else if ("Email".equals(attribute)) {
                j = new JRadioButton(word);
            } else {
                value = "";
            }

            JButton e = new JButton("Edit");
            JButton d = new JButton("Delete");

            j.setPreferredSize(new Dimension(200, 30));
            j.addActionListener(this);
            j.setActionCommand("Choose");
            this.add(j);
            buttonGroup.add(j);

            e.setPreferredSize(new Dimension(65, 25));
            e.addActionListener(this);
            e.setActionCommand("Edit");
            this.add(e);

            d.setPreferredSize(new Dimension(70, 25));
            d.addActionListener(this);
            d.setActionCommand("Delete");
            this.add(d);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Delete":
                int response = JOptionPane.showConfirmDialog(null, "Would you like to delete?");
                if (response == JOptionPane.YES_OPTION) {
                    switch (attribute) {
                        case "Name" -> CVData.getInstance().getNames().remove(word);
                        case "Title" -> CVData.getInstance().getTitles().remove(word);
                        case "Email" -> CVData.getInstance().getEmails().remove(word);
                    }
                    Container parent = getParent();
                    if (parent != null) {
                        parent.remove(addRow.this);
                        parent.revalidate();
                        parent.repaint();
                    }
                    }
                CVData.getInstance().writeSuperCsv("data/cv_repo_3.csv");
                break;
            case "Edit":
                JButton button2 = (JButton) e.getSource();
                JPanel parentPanel2 = (JPanel) button2.getParent();
                JRadioButton radioButton2 = (JRadioButton) parentPanel2.getComponent(0);
                String input = JOptionPane.showInputDialog(null, "Enter New Text", radioButton2.getText());
                if (input != null) {
                    switch (attribute) {
                        case "Name" -> {
                            ArrayList<String> names = CVData.getInstance().getNames();
                            int index = names.indexOf(word);
                            if (index != -1) {
                                names.set(index, input);
                            }
                        }
                        case "Title" -> {
                            ArrayList<String> titles = CVData.getInstance().getTitles();
                            int index = titles.indexOf(word);
                            if (index != -1) {
                                titles.set(index, input);
                            }
                        }
                        case "Email" -> {
                            ArrayList<String> emails = CVData.getInstance().getEmails();
                            int index = emails.indexOf(word);
                            if (index != -1) {
                                emails.set(index, input);
                            }
                        }
                    }
                    radioButton2.setText(input);
                    word = input;
                    System.out.println("User input: " + input);
                }
                CVData.getInstance().writeSuperCsv("data/cv_repo_3.csv");
                break;

            case "Choose":
                if (j.isSelected()) {
                    System.out.println("Selected");
                }
        break;
        }
    }
    }

