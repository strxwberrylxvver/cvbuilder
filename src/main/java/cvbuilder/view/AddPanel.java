package cvbuilder.view;

import cvbuilder.model.CVData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddPanel extends JPanel implements ActionListener {
    JTextField textInput = new JTextField(15);
    JTextArea textAreaInput = new JTextArea();
    String title;
    ButtonGroup buttonGroup;
    JCheckBox check = new JCheckBox("Include");

    public AddPanel(String title, ArrayList<String> items, ButtonGroup buttonGroup) {
        this.title = title;
        this.buttonGroup = buttonGroup;
        this.check = check;
        this.setLayout(new GridLayout(0,1));
        this.setBorder(BorderFactory.createTitledBorder(title));

        if (title.equals("Title")||title.equals("Referee 2"))
        {
            this.add(check);
            check.setSelected(true);
        }

        for (String item : items) {
            add(new addRow(item, title, buttonGroup));
        }
        check.addActionListener(this);
        check.setActionCommand("Check");

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(65, 25));
        addButton.addActionListener(this);
        addButton.setActionCommand("Add");

        if (title.equals("Referee 1") || title.equals("Referee 2")) {
            textAreaInput = new JTextArea(4, 30);
            textAreaInput.setLineWrap(true);
            textAreaInput.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(textAreaInput);
            inputPanel.add(scrollPane);
        } else {
            textInput = new JTextField(15);
            inputPanel.add(textInput);
        }

        inputPanel.add(addButton);
        this.add(inputPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            String newEntry = "";

            if (title.equals("Referee 1") || title.equals("Referee 2")) {
                newEntry = textAreaInput.getText().trim();
                textAreaInput.setText("");
            } else {
                newEntry = textInput.getText().trim();
                textInput.setText("");
            }

            if (!newEntry.isEmpty()) {
                switch (title) {
                    case "Name" -> CVData.getInstance().getNames().add(newEntry);
                    case "Title" -> CVData.getInstance().getTitles().add(newEntry);
                    case "Email" -> CVData.getInstance().getEmails().add(newEntry);
                    case "Referee 1" -> CVData.getInstance().getReferences1().add(newEntry);
                    case "Referee 2" -> CVData.getInstance().getReferences2().add(newEntry);
                }
                this.add(new addRow(newEntry, title, buttonGroup));
                this.revalidate();
                this.repaint();
                CVData.getInstance().writeSuperCsv("data/cv_repo_3.csv");
            }
        }
        else if(e.getActionCommand().equals("Check")){

        }
    }
}
