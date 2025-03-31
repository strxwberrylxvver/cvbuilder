package cvbuilder.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavPanel extends JPanel implements ActionListener {
    JButton prev = new JButton("Previous Section");
    JButton next = new JButton("Next Section");
    public NavPanel(){
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
        if (e.getActionCommand().equals("Previous")){

        }
        else if (e.getActionCommand().equals("Next")){

        }
    }
}
