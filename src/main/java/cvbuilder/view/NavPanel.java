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

        switch (e.getActionCommand()) {
            case "Previous":
                if (currentTab > 0) {
                    tabs.setSelectedIndex(currentTab - 1);
                }
                break;

            case "Next":
                int result = JOptionPane.showConfirmDialog(
                        this,
                        "Are you ready to preview your CV?",
                        "Confirm Navigation",
                        JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION) {
                    boolean previewExists = false;

                    for (int i = 0; i < tabs.getTabCount(); i++) {
                        if (tabs.getTitleAt(i).equals("Preview")) {
                            tabs.setComponentAt(i, new CVPreview());
                            tabs.setSelectedIndex(i);
                            previewExists = true;
                            break;
                        }
                    }
                if (!previewExists) {
                    tabs.addTab("Preview", new CVPreview());
                    tabs.setSelectedIndex(tabs.getTabCount() - 1);
                }

            } else {
                tabs.setSelectedIndex(currentTab + 1);
            }
        }
    }
}
