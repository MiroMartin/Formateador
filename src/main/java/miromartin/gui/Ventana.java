package miromartin.gui;

import javax.swing.*;

public class Ventana extends JFrame {

    JButton button;
    JButton button2;
    JButton button3;

    JTextField txt1;
    JTextField txt2;

    public Ventana() {
        super();
        setSize(210, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        addComponent();
    }

    public void addComponent() {

        button = new JButton("Elija el video");
        button.setBounds(30, 30, 150, 30);
        add(button);

        button2 = new JButton("formato elegido");
        button2.setBounds(30, 110, 150, 30);
        add(button2);

        button3 = new JButton("Formatear");
        button3.setBounds(30,200,150,30);
        add(button3);


    }
}
