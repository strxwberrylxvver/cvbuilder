package cvbuilder.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavPanel extends JPanel implements ActionListener {
    JButton prev = new JButton("Previous Section");
    JButton next = new JButton("Next Section");
    private JTabbedPane tabs;

    public NavPanel(JTabbedPane tabs){
        this.tabs= tabs;

        prev.addActionListener(this);
        prev.setActionCommand("Previous");
        next.addActionListener(this);
        next.setActionCommand("Next");
        this.add(prev);
        this.add(next);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int currentTab = tabs.getSelectedIndex();
        int totalTabs = tabs.getTabCount();

        if ("Previous".equals(e.getActionCommand()) && currentTab > 0) {
            tabs.setSelectedIndex(currentTab - 1);
        } else if ("Next".equals(e.getActionCommand()) && currentTab < totalTabs - 1) {
            tabs.setSelectedIndex(currentTab + 1);
        }
    }
}
