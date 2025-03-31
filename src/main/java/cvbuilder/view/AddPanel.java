package cvbuilder.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddPanel extends JPanel {
    public AddPanel(String title, ArrayList<String> items, ButtonGroup buttonGroup) {
        setLayout(new GridLayout(0, 1));
        setBorder(BorderFactory.createTitledBorder(title));

        for (String item : items) {
            add(new addRow(item, title, buttonGroup));
        }
    }

}
