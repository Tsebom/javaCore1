package ru.geekbrains.javaCore1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My first window");
        setBounds(300, 300, 400, 400);

        JButton buttonOne = new JButton("One");
        JButton buttonTwo = new JButton("Two");

        JPanel panel = new JPanel(new GridLayout(1,2));
        panel.add(buttonOne);
        panel.add(buttonTwo);

        add(panel, BorderLayout.SOUTH);

        ActionListener actionListener = new CloseActionListener();
        buttonOne.addActionListener(actionListener);
    }
}
