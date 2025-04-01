package cvbuilder.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addRRow extends JPanel implements ActionListener {
    private String word;
    private String attribute;
    private JRadioButton j;
    public addRRow(String word, String attribute, ButtonGroup buttonGroup){

        if ("Referee 1".equals(attribute)) {
            j = new JRadioButton(word);
        }
        else if ("Referee 2".equals(attribute)) {
            j = new JRadioButton(word);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
