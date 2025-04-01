package cvbuilder.view;

import cvbuilder.model.CVData;

import javax.swing.*;
import java.awt.*;

public class ReferencePanel extends JPanel {
    public ReferencePanel(){
        this.setLayout(new BorderLayout());

        ButtonGroup bref1 = new ButtonGroup();
        ButtonGroup bref2 = new ButtonGroup();

        JPanel ref1panel = new AddPanel("Title", CVData.getInstance().getReferences1(), bref1);
        JPanel ref2panel = new AddPanel("Email", CVData.getInstance().getReferences2(), bref2);

        JTabbedPane referTabs = new JTabbedPane();
        referTabs.addTab("Referee 1", ref1panel);
        referTabs.addTab("Referee 2", ref2panel);

        add(referTabs, BorderLayout.CENTER);
    }
}
