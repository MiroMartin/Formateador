package miromartin.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Ventana extends JFrame implements ActionListener{

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
        button.addActionListener(this);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Elija el video");

                int userSelection = fileChooser.showOpenDialog(button);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Video seleccionado: " + selectedFile.getAbsolutePath());
                }
            }
        });

        button2 = new JButton("formato elegido");
        button2.setBounds(30, 110, 150, 30);
        add(button2);
        button2.addActionListener(this);

        button3 = new JButton("Formatear");
        button3.setBounds(30,200,150,30);
        add(button3);
        button3.addActionListener(this);

    }
    public String elegirVideo(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Elija el video");

        int userSelection = fileChooser.showOpenDialog(button);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Video seleccionado: " + selectedFile.getAbsolutePath());
            String vp = selectedFile.toString();
            return vp;
        }
        return null;
    }

    public String elegirFormato(){
        String format = JOptionPane.showInputDialog("Ingrese el fomato deseado");
        return format;
    }

    public void formatearVideo(String vp, String format){
        System.out.println("cd && cd video && ffmpeg -i " + vp + format);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button){
            elegirVideo();
        }else if (e.getSource()== button2){
            elegirFormato();
        }else if (e.getSource()== button3){
            formatearVideo();
        }
    }
}
