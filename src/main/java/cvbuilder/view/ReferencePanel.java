package cvbuilder.view;

import cvbuilder.model.CVData;

import javax.swing.*;
import java.awt.*;

public class ReferencePanel extends JTabbedPane {
    public ReferencePanel(){
        this.setLayout(new BorderLayout());

//        ButtonGroup nameGroup = new ButtonGroup();
//        ButtonGroup titleGroup = new ButtonGroup();
//        ButtonGroup emailGroup = new ButtonGroup();
//
//        JPanel Referee = new AddPanel("Name", CVData.getInstance().getNames(), nameGroup);
//        JPanel titlePanel = new AddPanel("Title", CVData.getInstance().getTitles(), titleGroup);
//        JPanel emailPanel = new AddPanel("Email", CVData.getInstance().getEmails(), emailGroup);

        JTabbedPane referTabs = new JTabbedPane();
        referTabs.addTab("Referee 1", new JPanel());
        referTabs.addTab("Referee 2", new JPanel());

        add(referTabs, BorderLayout.CENTER);
    }
}
