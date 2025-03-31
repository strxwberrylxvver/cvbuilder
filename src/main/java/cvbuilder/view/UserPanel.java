package cvbuilder.view;

import cvbuilder.model.CVData;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    public UserPanel(){
        this.setLayout(new BorderLayout());

        ButtonGroup nameGroup = new ButtonGroup();
        ButtonGroup titleGroup = new ButtonGroup();
        ButtonGroup emailGroup = new ButtonGroup();

        JPanel namePanel = new AddPanel("Name", CVData.getInstance().getNames(), nameGroup);
        JPanel titlePanel = new AddPanel("Title", CVData.getInstance().getTitles(), titleGroup);
        JPanel emailPanel = new AddPanel("Email", CVData.getInstance().getEmails(), emailGroup);

        JTabbedPane userTabs = new JTabbedPane();
        userTabs.addTab("User Name", namePanel);
        userTabs.addTab("User Title", titlePanel);
        userTabs.addTab("User Email", emailPanel);

        add(userTabs, BorderLayout.CENTER);
    }
}
