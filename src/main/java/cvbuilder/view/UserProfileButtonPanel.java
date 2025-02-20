package cvbuilder.view;

import cvbuilder.model.CVData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileButtonPanel extends JPanel implements ActionListener {
    JButton display = new JButton("Display Profile");
    JButton addp = new JButton("Add Profile");
    //User u;

    public UserProfileButtonPanel()
    {
        display.addActionListener(this);
        addp.addActionListener(this);
        display.setActionCommand("Display Profile");
        addp.setActionCommand("Add Profile");
        this.add(display);
        this.add(addp);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
//            case "Display Profile":
//                if (CVData.getInstance().getSelectedUser() != null)
//                {
//                    System.out.println(CVData.getInstance().getSelectedUser().getFormattedText());
//                    JOptionPane.showMessageDialog(this, "Hello, display coming soon" );
//                }
//                else {
//                    System.out.println("Null - No User Selected");
//                }
//                break;

            case "Add Profile":
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                new AddUserDialog(parentFrame);
                break;

        }
    }
}
