package cvbuilder.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import cvbuilder.model.CVData;



public class addRow extends JPanel implements ActionListener {
    private String attribute;
    private JRadioButton j;
    private String word;
    public addRow(String word, String attribute, ButtonGroup buttonGroup) {
      this.word = word;
      this.attribute = attribute;

      if (attribute.equals("Referee 1") || attribute.equals("Referee 2")) {
          JTextArea textArea = new JTextArea(5, 30);
          textArea.setText(word);
          textArea.setEditable(false);
          textArea.setLineWrap(true);
          textArea.setWrapStyleWord(true);
          textArea.setOpaque(false);
          textArea.setFocusable(false);
          textArea.setBorder(null);
          j = new JRadioButton();
          buttonGroup.add(j);
          this.add(j);
          this.add(textArea);
      }
      else
      {
          j = new JRadioButton(word);
          j.setPreferredSize(new Dimension(296, 30));
          this.add(j);
          buttonGroup.add(j);
      }
      j.addActionListener(this);
      j.setActionCommand("Choose");
      JButton e = new JButton("Edit");
      JButton d = new JButton("Delete");
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
                        case "Referee 1" -> CVData.getInstance().getReferences1().remove(word);
                        case "Referee 2" -> CVData.getInstance().getReferences2().remove(word);
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
                        case "Referee 1" -> {
                            CVData.getInstance().getReferences1().remove(word);
                            CVData.getInstance().getReferences1().add(input);
                        }
                        case "Referee 2" -> {
                            CVData.getInstance().getReferences2().remove(word);
                            CVData.getInstance().getReferences2().add(input);
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
                    CVData data = CVData.getInstance();
                    switch (attribute) {
                        case "Name" -> data.setSelectedName(word);
                        case "Title" -> data.setSelectedTitle(word);
                        case "Email" -> data.setSelectedEmail(word);
                        case "Referee 1" -> data.setSelectedReference1(word);
                        case "Referee 2" -> data.setSelectedReference2(word);
                    }
                    System.out.println("Selected " + attribute + ": " + word);
                }
        break;
        }
    }
    }

