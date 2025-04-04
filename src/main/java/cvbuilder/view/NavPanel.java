package cvbuilder.view;

import javax.swing.*;
import java.awt.*;
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

        switch (e.getActionCommand()) {
            case "Previous":
                if (tabs.getTitleAt(currentTab).equals("Preview")) {
                    tabs.removeTabAt(currentTab);
                }
                if (currentTab > 0) {
                    tabs.setSelectedIndex(currentTab - 1);
                }
                break;

            case "Next":
                int currentTabIndex = tabs.getSelectedIndex();
                int nextTabIndex = currentTabIndex + 1;

                if (nextTabIndex == tabs.getTabCount()) {
                    int result = JOptionPane.showConfirmDialog(
                            this,
                            "Are you ready to preview your CV?",
                            "Confirm Preview",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (result == JOptionPane.YES_OPTION) {
                        tabs.addTab("Preview", new CVPreview());
                        tabs.setSelectedIndex(tabs.getTabCount() - 1);
                    }
                } else {

                    JPanel currentPanel = (JPanel) tabs.getComponentAt(currentTabIndex);
                    boolean hasSelected = false;

                    for (Component comp : currentPanel.getComponents()) {
                        if (comp instanceof addRow row) {
                            if (row.getRadioButton().isSelected()) {
                                hasSelected = true;
                                break;
                            }
                        }
                    }


                        tabs.setSelectedIndex(nextTabIndex);
                }
                break;
        }
    }
}
