package cvbuilder.view;

import cvbuilder.model.CVData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddPanel extends JPanel implements ActionListener {
    JTextField textInput = new JTextField(15);
    String title;
    ButtonGroup buttonGroup;
    JCheckBox check = new JCheckBox("Include");
    public AddPanel(String title, ArrayList<String> items, ButtonGroup buttonGroup) {
        this.title = title;
        this.buttonGroup = buttonGroup;
        this.check = check;
        setLayout(new GridLayout(0, 1));
        setBorder(BorderFactory.createTitledBorder(title));
        if (title.equals("Title"))
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
        textInput = new JTextField(15);
        JButton addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(65, 25));
        addButton.addActionListener(this);
        addButton.setActionCommand("Add");

        inputPanel.add(textInput);
        inputPanel.add(addButton);
        this.add(inputPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            String newEntry = textInput.getText().trim();
            if (!newEntry.isEmpty()) {
                switch (title) {
                    case "Name" -> CVData.getInstance().getNames().add(newEntry);
                    case "Title" -> CVData.getInstance().getTitles().add(newEntry);
                    case "Email" -> CVData.getInstance().getEmails().add(newEntry);
                }
                this.add(new addRow(newEntry, title, buttonGroup));
                revalidate();
                repaint();
                CVData.getInstance().writeSuperCsv("data/cv_repo_3.csv");
                textInput.setText("");
            }
        }
        else if(e.getActionCommand().equals("Check")){

        }
    }
}
