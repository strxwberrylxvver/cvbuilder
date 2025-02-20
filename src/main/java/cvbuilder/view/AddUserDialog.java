package cvbuilder.view;

//import cvbuilder.model.User;
import cvbuilder.model.CVData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserDialog extends JDialog implements ActionListener {
    JPanel mainpanel = new JPanel(new BorderLayout());
    JPanel textbox = new JPanel(new GridLayout(4, 1, 5, 5));
    JPanel names = new JPanel(new GridLayout(4, 1, 5, 5));
    JPanel option = new JPanel(new FlowLayout());
    JTextField profile = new JTextField("Enter Profile Name");
    JTextField title = new JTextField("Enter Title");
    JTextField name = new JTextField("Enter Name");
    JTextField email = new JTextField("Enter eMail");

    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");


    public AddUserDialog(JFrame frame)
    {
        super(frame, "Add User", true);
        this.setSize(350, 200);
        setLocationRelativeTo(frame);

        names.add(new JLabel("profile"));
        names.add(new JLabel("title"));
        names.add(new JLabel("name"));
        names.add(new JLabel("email"));

        textbox.add(profile);
        textbox.add(title);
        textbox.add(name);
        textbox.add(email);

        option.add(ok);
        option.add(cancel);

        ok.addActionListener(this);
        cancel.addActionListener(this);
        ok.setActionCommand("OK");
        cancel.setActionCommand("Cancel");
        option.add(ok);
        option.add(cancel);

        mainpanel.add(textbox, BorderLayout.EAST);
        mainpanel.add(names, BorderLayout.WEST);
        mainpanel.add(option, BorderLayout.SOUTH);
        setContentPane(mainpanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "OK":
                String p = profile.getText().trim();
                String t = title.getText().trim();
                String n = name.getText().trim();
                String em = email.getText().trim();

               // User newUser = new User(p, t, n, em);
               // CVData.getInstance().addUser(newUser);
                //CVData.getInstance().writeSuperCsv("userprofile.csv");

                JOptionPane.showMessageDialog(this, "User added!");
                dispose();

                this.removeAll();
                MainViewer.getInstance().addPanel();
                break;

            case "Cancel":
                dispose();
                break;

        }
    }
}
