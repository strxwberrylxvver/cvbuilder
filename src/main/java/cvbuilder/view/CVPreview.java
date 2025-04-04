package cvbuilder.view;

import javax.swing.*;
import java.awt.*;
import cvbuilder.model.CVData;

public class CVPreview extends JPanel {
    private JTextArea cvPreviewArea;
    private JButton saveButton;
    private JButton printButton;
    private JButton copyButton;

    public CVPreview() {
        this.setLayout(new BorderLayout());

        cvPreviewArea = new JTextArea(20, 40);
        cvPreviewArea.setEditable(false);
        cvPreviewArea.setLineWrap(true);
        cvPreviewArea.setWrapStyleWord(true);

        StringBuilder cvContent = new StringBuilder();
        cvContent.append("Name: ").append(String.join(", ", CVData.getInstance().getNames())).append("\n");
        cvContent.append("Title: ").append(String.join(", ", CVData.getInstance().getTitles())).append("\n");
        cvContent.append("Email: ").append(String.join(", ", CVData.getInstance().getEmails())).append("\n");

        cvContent.append("\nReferee 1:\n");
        for (String ref : CVData.getInstance().getReferences1()) {
            cvContent.append("- ").append(ref.replace("\n", " | ")).append("\n");
        }

        cvContent.append("\nReferee 2:\n");
        for (String ref : CVData.getInstance().getReferences2()) {
            cvContent.append("- ").append(ref.replace("\n", " | ")).append("\n");
        }

        cvPreviewArea.setText(cvContent.toString());

        JScrollPane scrollPane = new JScrollPane(cvPreviewArea);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Save CV");
        printButton = new JButton("Print CV");
        copyButton = new JButton("Copy to Clipboard");

        buttonPanel.add(saveButton);
        buttonPanel.add(printButton);
        buttonPanel.add(copyButton);
        add(buttonPanel, BorderLayout.SOUTH);

    }

}
