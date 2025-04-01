package cvbuilder.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavPanel extends JPanel implements ActionListener {
    JButton prev = new JButton("Previous Section");
    JButton next = new JButton("Next Section");
    private JTabbedPane mainTabs;
    private JTabbedPane userTabs;
    private JTabbedPane referenceTabs;

    public NavPanel(JTabbedPane mainTabs, JTabbedPane userTabs, JTabbedPane referenceTabs){
        this.mainTabs= mainTabs;
        this.userTabs= userTabs;
        this.referenceTabs= referenceTabs;

        this.prev = prev;
        this.next = next;
        prev.addActionListener(this);
        prev.setActionCommand("Previous");
        next.addActionListener(this);
        next.setActionCommand("Next");
        this.add(prev);
        this.add(next);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isNext = e.getSource() == next;
        JTabbedPane currentTabPane = (mainTabs.getSelectedIndex() == 0) ? userTabs : referenceTabs;

        int currentIndex = currentTabPane.getSelectedIndex();
        int tabCount = currentTabPane.getTabCount();

        if (isNext) {
            if (currentIndex < tabCount - 1) {
                currentTabPane.setSelectedIndex(currentIndex + 1);
            } else {
                mainTabs.setSelectedIndex(Math.min(mainTabs.getSelectedIndex() + 1, mainTabs.getTabCount() - 1));
            }
        } else {
            if (currentIndex > 0) {
                currentTabPane.setSelectedIndex(currentIndex - 1);
            } else {
                mainTabs.setSelectedIndex(Math.max(mainTabs.getSelectedIndex() - 1, 0));
            }
        }
    }
}